package com.app.lesson3;

import java.util.*;

public class Inventory {

    Map<ProductType, List<Product>> productTypeListMap = new HashMap<>();
    List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
        productTypeListMap.put(ProductType.CHEESE, products);

    }

}
