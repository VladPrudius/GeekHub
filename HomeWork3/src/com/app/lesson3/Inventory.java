package com.app.lesson3;

import java.util.*;

public class Inventory {

    private Map<ProductType, List<Product>> productsByType = new HashMap<>();

    public void addProduct(ProductType type, Product product) {
        List<Product> products = productsByType.get(type);
        if (products == null) {
            products = new ArrayList<>();
            productsByType.put(type, products);
        }
        products.add(product);
    }

    public double calculateInventoryValue(ProductType type) {
        List<Product> products = productsByType.get(type);
        if (products == null) {
            return 0;
        }

        double price = 0;
        for (Product product : products) {
            price += product.getPrice();
        }

        return price;
    }

    public double calculateInventoryValue() {
        double priceAllProduct = 0;
        Set<ProductType> categories = productsByType.keySet();
        for (ProductType category : categories) {
            priceAllProduct += calculateInventoryValue(category);
        }
        return priceAllProduct;
    }
}
