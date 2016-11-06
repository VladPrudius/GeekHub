package com.app.lesson3;

import java.util.*;

public class Inventory {

    private Map<ProductType, List<Product>> productsByType = new HashMap<>();

    public void addProduct(ProductType type, Product product) {
        List<Product> products = productsByType.get(type);
        products.add(product);
        productsByType.put(type, products);
    }

    public double calculateInventoryValue(ProductType type) {
        List<Product> products = productsByType.get(type);
        double price = 0;
        for (Product product : products) {
            price += product.getPrice();
        }
        return price;
    }

    public double calculateInventoryValue() {

        return 0;
    }
}
