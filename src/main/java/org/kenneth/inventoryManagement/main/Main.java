package org.kenneth.inventoryManagement.main;

import org.kenneth.inventoryManagement.entity.Product;
import org.kenneth.inventoryManagement.repository.InventoryRepository;
import org.kenneth.inventoryManagement.services.InventoryService;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static InventoryRepository inventoryRepository = new InventoryRepository();
    static InventoryService inventoryService = new InventoryService(inventoryRepository);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n Welcome to my Inventory Management App");
            System.out.println("""
                1. Add a new product
                2. Update the previous product quantity
                3. Search a product
                4. List Products
                5. See total inventory value
                6. Remove an existing product
                7. Exit
                """);
            System.out.print("Menu (Enter a choice): ");
            int menuChoice = scan.nextInt();

            switch (menuChoice){
                case 1 -> addProduct();
                case 2 -> updateQuantity();
                case 3 -> searchProduct();
                case 4 -> listProducts();
                case 5 -> totalInventoryValue();
                case 6 -> removeProduct();
                case 7 -> System.exit(0);
                default -> System.out.println("Restart and Enter a valid choice");
            };
        }

    }

    private static void addProduct(){
        System.out.println("Fill in the values");

        System.out.print("Product_id: ");
        String id = scan.next();
        System.out.print("Product_name: ");
        String productName = scan.next();
        System.out.print("Product_price: ");
        double price = scan.nextDouble();
        System.out.print("Product_quantity: ");
        int quantity = scan.nextInt();
        System.out.print("Product_category: ");
        String category = scan.next();

        inventoryService.addProduct(new Product(id, productName, price, quantity, category));
        System.out.println(productName + " has been added to the Inventory");
    }

    private static void updateQuantity(){
        System.out.print("Enter the product name: ");
        String productName = scan.next();
        System.out.print("Enter the current quantity: ");
        int currentQuantity  = scan.nextInt();

        System.out.println(inventoryService.updateQuantity(productName, currentQuantity));
    }

    private static void searchProduct(){
        System.out.print("Enter product name: ");
        String productName = scan.next();

        System.out.println(inventoryService.search(productName));
    }

    private static void listProducts(){
        inventoryService.listSortedByPrice();
    }

    private static void totalInventoryValue(){
        DecimalFormat myFormatter = new DecimalFormat("###,###.##");
        System.out.println(myFormatter.format(inventoryService.totalInventoryValue()));
    }

    private static void removeProduct(){
        System.out.print("Enter the product name: ");
        String productName = scan.next();

        System.out.println(inventoryService.removeProduct(productName));
    }
}
