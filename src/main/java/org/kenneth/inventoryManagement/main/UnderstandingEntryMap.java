package org.kenneth.inventoryManagement.main;

import java.util.*;

public class UnderstandingEntryMap {
    public static void main(String[] args) {
        Map<String, Integer> testMap = new HashMap<>();

        testMap.put("Ken", 80);
        testMap.put("ben", 47);
        testMap.put("Men", 96);
        testMap.put("Pen", 38);

//        System.out.println(testMap.entrySet());

//        for(Map.Entry<String, Integer> entry : testMap.entrySet()){
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

//        ArrayList<Integer> mapList = new ArrayList<>(testMap.values());
//        Collections.sort(mapList);
//        for(int i : mapList){
//            System.out.println(i);
//        }

        List<Map.Entry<String, Integer>> mapList = new ArrayList<>(testMap.entrySet());
        Collections.sort(mapList, (a, b) -> Integer.compare(a.getValue(), b.getValue()));
        for(Map.Entry<String, Integer> i : mapList){
            System.out.println(i);
        }
    }
}
