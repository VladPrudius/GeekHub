package com.app.lesson2;

import java.util.Scanner;

class Circle implements Shape {

    private double perimeter, area, radius;

    Circle() {
        perimeter = 0;
        area = 0;
        System.out.print("Введите радиус круга: ");
        Scanner scan = new Scanner(System.in);
        radius = scan.nextDouble();
    }

    public void calculateArea() {
        area = (Math.PI * Math.pow(radius, 2));
        System.out.format("Радиус круга = %.3f%n", area);
    }

    public void calculatePerimeter() {
        perimeter = (2 * Math.PI * radius);
        System.out.format("Периметр круга =  %.3f%n", perimeter);
    }
}
