package com.app.lesson3;

import java.util.*;

public class Inventory {

    Map<ProductType, List<Product>> productsByType = new HashMap<>();
    List<Product> products = new ArrayList<>();

    public void addProduct(ProductType type , Product p) {
        products.add(p);
        productsByType.put(type, products);

    }

    public int inventoryValue(ProductType type){
        int price = 0;
        products = productsByType.get(type);
        for(int i = 0; i < products.size(); i++){
           price +=  products.get(i).getPrice();
        }
         return price;
    }
}
