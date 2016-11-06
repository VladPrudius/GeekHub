package com.app.lesson3;

import java.util.Scanner;

public class HomeWork3 {

    public static void main(String[] arg) {

        Scanner scan = new Scanner(System.in);
        String str = new String();
        String name = new String();
        int price;
        boolean stop = false;
        Inventory inventory = new Inventory();
        while (!stop) {
            System.out.println("Введите тип продукта: ");
            str = scan.next();

            if (str.equals(ProductType.CHEESE.toString())) {
                System.out.println("Введите название сыра ");
                name = scan.next();
                System.out.print("Введите стоимость сыра: ");
                price = scan.nextInt();
                Product product = new Product(name, price);
                inventory.addProduct(ProductType.CHEESE, product);
                System.out.println("Сума стоимости сыров = " + inventory.inventoryValue(ProductType.CHEESE));
            }
            if (str.equals(ProductType.LOAF.toString())) {
                System.out.println("Введите название батона ");
                name = scan.next();
                System.out.print("Введите стоимость батона: ");
                price = scan.nextInt();
                Product product = new Product(name, price);
                inventory.addProduct(ProductType.LOAF, product);
                System.out.println("Сума стоимости батонов = " + inventory.inventoryValue(ProductType.LOAF));
            }
            if (str.equals(ProductType.SAUSAGE.toString())) {
                System.out.println("Введите название колбасы ");
                name = scan.next();
                System.out.print("Введите стоимость колбасы: ");
                price = scan.nextInt();
                Product product = new Product(name, price);
                inventory.addProduct(ProductType.SAUSAGE, product);
                System.out.println("Сума стоимости колбасы = " + inventory.inventoryValue(ProductType.SAUSAGE));
            }
            System.out.println("Добавить ещё продукт (Yes)1/0(no)?");
            if( scan.nextInt() == 0) stop = true;

        }
    }
}