package com.aaslin.java.assignments.assignment_7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProductMapExample {
    public static void main(String[] args) {
        // Create the Map of product names and their prices
        Map<String, Integer> productPrices = new HashMap<>();
        productPrices.put("Laptop", 50000);
        productPrices.put("Mobile", 20000);
        productPrices.put("Headphones", 1500);
        productPrices.put("Keyboard", 800);

        // Get the entry set and create an iterator
        Iterator<Map.Entry<String, Integer>> iterator = productPrices.entrySet().iterator();

        // Iterate and print key-value pairs
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Product: " + entry.getKey() + ", Price: " + entry.getValue());
        }
    }
}
