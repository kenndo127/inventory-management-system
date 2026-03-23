package org.kenneth.inventoryManagement.main;

import java.util.Scanner;

public class Main {
    // create a static variable here
    static Scanner scan = new Scanner(System.in);
    static InventoryRepository inventoryRepository = new InventoryRepository();
    static InventoryService inventoryService = new InventoryService(inventoryRepository);

    public static void main(String[] args) {


        System.out.println("Welcome to my Inventory Management App");
        System.out.println("""
                1. Add a new product
                2. Update the previous product quantity
                3. Search a product
                4. List Products
                5. See total inventory value
                6. Remove an existing product
                """);
        System.out.print("Menu (Enter a choice): ");
        int menuChoice = scan.nextInt();

        System.out.println(menuChoice);
    }
    private static void addProduct(){
        System.out.println("Fill in the values");

        System.out.println("Product_id: ");
        String id = scan.next();
        System.out.println("Product_name: ");
        String productName = scan.next();
        System.out.println("Product_price: ");
        double price = scan.nextDouble();
        System.out.println("Product_quantity: ");
        int quantity = scan.nextInt();
        System.out.println("Product_category: ");
        String category = scan.next();

        inventoryService.addProduct(new Product(id, productName, price, quantity, category));
        System.out.println(productName + "has been added to the Inventory");
    }

    private static void updateQuantity(String productName, int quantity){
        System.out.println("Enter the product name: ");
        String name = scan.next();
        System.out.println("Enter the current quantity: ");
        int currentQuantity  = scan.nextInt();

        System.out.println(inventoryService.updateQuantity(name, currentQuantity));
    }
}
