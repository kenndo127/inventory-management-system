package org.kenneth.inventoryManagement.main;

public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public void addProduct(Product product){
        inventoryRepository.addProduct(product);
    }
    public void updateQuantity(String productName, int productQuantity){
        inventoryRepository.updateQuantity(productName, productQuantity);
    }
    public String search(String productName){
        return inventoryRepository.search(productName);
    }
    public void listSortedByPrice(){
        inventoryRepository.listSortedByPrice();
    }
    public void removeProduct(String productName){
        inventoryRepository.removeProduct(productName);
    }
    public double totalInventoryValue(){
        return inventoryRepository.totalInventoryValue();
    }
}
