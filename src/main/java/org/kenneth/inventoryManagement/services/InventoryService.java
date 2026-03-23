package org.kenneth.inventoryManagement.services;

import org.kenneth.inventoryManagement.entity.Product;
import org.kenneth.inventoryManagement.repository.InventoryRepository;

public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public void addProduct(Product product){
        inventoryRepository.addProduct(product);
    }
    public String updateQuantity(String productName, int productQuantity){
        return inventoryRepository.updateQuantity(productName, productQuantity);
    }
    public String search(String productName){
        return inventoryRepository.search(productName);
    }
    public void listSortedByPrice(){
        inventoryRepository.listSortedByPrice();
    }
    public String removeProduct(String productName){
        return inventoryRepository.removeProduct(productName);
    }
    public double totalInventoryValue(){
        return inventoryRepository.totalInventoryValue();
    }
}
