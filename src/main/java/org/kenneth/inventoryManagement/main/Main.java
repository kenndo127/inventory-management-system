package org.kenneth.inventoryManagement.main;

public class Main {
    // create a static variable here
    public static void main(String[] args) {


        //Creating product objects
        Product product1 = new Product("1", "phone", 334.0, 5, "tech");
        Product product2 = new Product("2", "laptop", 334.0, 10, "tech");

        //Creating InventoryService Objects
        InventoryRepository inventoryRepository = new InventoryRepository();
        InventoryService inventoryService = new InventoryService(inventoryRepository);

        //adding products
        inventoryService.addProduct(product1);
        inventoryService.addProduct(product2);

        //testing the update quantity
        System.out.println("before 1:" + product1.getQuantity());
        System.out.println("before 2:" + product2.getQuantity());
        inventoryService.updateQuantity("phone", 10);
        inventoryService.updateQuantity("laptop", 20);
        System.out.println("after 1:" + product1.getQuantity());
        System.out.println("after 2:" + product2.getQuantity());

        //testing the search feature
        System.out.println("\n" + inventoryService.search("LaptoP"));

        //testing the list by sorted price
        inventoryService.listSortedByPrice();

        //testing total inventory value
        System.out.println(inventoryService.totalInventoryValue());

        //testing remove product
        inventoryService.removeProduct("phone");
        //searching removed object to be sure it doesn't exist anymore
        System.out.println("\n" + inventoryService.search("phone"));

    }
}
