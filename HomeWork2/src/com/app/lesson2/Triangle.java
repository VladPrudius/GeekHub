package com.app.lesson2;

import java.util.Scanner;

public class Triangle implements Shape {

    private double area, perimetr, polPerimetr;
    private int a, b, c;

    Triangle() {
        perimetr = 0;
        area = 0;
        System.out.print("Введите длину стороны А: ");
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        System.out.print("Введите длину стороны B: ");
        b = scan.nextInt();
        System.out.print("Введите длину стороны C: ");
        c = scan.nextInt();
    }

    public void calculateArea() {
        polPerimetr = (a + b + c) / 2;
        area = Math.sqrt(polPerimetr * (polPerimetr - a) * (polPerimetr - b) * (polPerimetr - c));
        System.out.format("calculateArea = %.3f%n", area);

    }

    public void calculatePerimeter() {
        perimetr = a + b + c;
        System.out.println("create calculatePerimeter = " + perimetr);

    }
}
