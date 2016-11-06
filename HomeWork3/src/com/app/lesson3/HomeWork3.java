package com.app.lesson3;

import java.util.Scanner;

public class HomeWork3 {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        String productType;
        String name;
        double price;
        Inventory inventory = new Inventory();
        while (true) {
            System.out.println("Введите тип продукта: ");
            productType = scanner.next();

            if (productType.equals(ProductType.CHEESE.toString())) {
                System.out.println("Введите название сыра ");
                name = scanner.next();
                System.out.print("Введите стоимость сыра: ");
                price = scanner.nextInt();
                Product product = new Product(name, price);
                inventory.addProduct(ProductType.CHEESE, product);

            } else if (productType.equals(ProductType.LOAF.toString())) {
                System.out.println("Введите название батона: ");
                name = scanner.next();
                System.out.print("Введите стоимость батона: ");
                price = scanner.nextInt();
                Product product = new Product(name, price);
                inventory.addProduct(ProductType.LOAF, product);

            } else if (productType.equals(ProductType.SAUSAGE.toString())) {
                System.out.println("Введите название колбасы: ");
                name = scanner.next();
                System.out.print("Введите стоимость колбасы: ");
                price = scanner.nextInt();
                Product product = new Product(name, price);
                inventory.addProduct(ProductType.SAUSAGE, product);
            }
            System.out.println("Добавить ещё продукт (Yes)1/0(no)?");
            if (scanner.nextInt() == 0) {
                break;
            }
        }
        System.out.println("Сума стоимости сыров = " + inventory.calculateInventoryValue(ProductType.CHEESE));
        System.out.println("Сума стоимости батонов = " + inventory.calculateInventoryValue(ProductType.LOAF));
        System.out.println("Сума стоимости колбасы = " + inventory.calculateInventoryValue(ProductType.SAUSAGE));
        System.out.println("Общая стоимость всех товаров = " + inventory.calculateInventoryValue());
    }
}
