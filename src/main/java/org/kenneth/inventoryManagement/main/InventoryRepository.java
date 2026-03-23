package org.kenneth.inventoryManagement.main;

import java.util.*;

public class InventoryRepository {
    HashMap<String, Product> productHashMap = new HashMap<>();

    public void addProduct(Product product){
        productHashMap.put(product.getId(), product);
    }

    public String updateQuantity(String productName, int productQuantity){
        for(Product product : productHashMap.values()){
            if(product.getName().equals(productName)){
                product.setQuantity(productQuantity);
                return productName + " quantity updated to " + productQuantity;
            }
        }
        return productName + "not found!";
    }

    public String search(String productName){
        for(Product product : productHashMap.values()){
            if (product.getName().equalsIgnoreCase(productName)) {
                return product.toString();
            }
        }
        return "Product not found!";
    }

    public void listSortedByPrice(){
        //Turn map into a list
        List<Map.Entry<String, Product>> priceList = new ArrayList<>(productHashMap.entrySet());

        //use the comparator to sort
        Collections.sort(priceList, (a, b) -> Double.compare(a.getValue().getPrice(), b.getValue().getPrice()));

        //display the result
        for (Map.Entry<String, Product> productEntry : priceList){
            System.out.println(productEntry.getValue().getName() + " : " + productEntry.getValue().getPrice());
        }
    }

    public String removeProduct(String productName){
        for(Map.Entry<String, Product> productEntry : productHashMap.entrySet()){
            if (productEntry.getValue().getName().equalsIgnoreCase(productName)) {
                productHashMap.remove(productEntry.getKey());
                return productEntry.getValue().getName() + " has been removed!";
            }
        }
        return productName + "does not exist! ";
    }

    public double totalInventoryValue(){
        double totalInventoryValue = 0;
        for(Map.Entry<String, Product> productEntry : productHashMap.entrySet()){
            totalInventoryValue += (productEntry.getValue().getPrice() * productEntry.getValue().getQuantity());
        }
        return totalInventoryValue;
    }
}
