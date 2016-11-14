package com.app.lesson4;

import java.time.*;
import java.util.Scanner;

public class HomeWork4 {
    public static void main(String[] args) {

        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        String name;
        String category;

        while (true) {
            System.out.println("Введите категорию: ");
            category = scanner.next();
            System.out.println("Введите название: ");
            name = scanner.next();

            Task task = new Task(category, name);
            LocalDateTime localDateTime = LocalDateTime.now();
            manager.add(localDateTime, task);

            System.out.println("Добавить ещё товар (Yes)1/0(no)?");
            if (scanner.nextInt() == 0) {
                break;
            }
            System.out.println("Кол-ство товаров " + manager.getTasksForToday());

        }
        System.out.println("Кол-ство товаров " + manager.getTasksForToday());
        System.out.println("Категории " + manager.getCategories());
    }
}
