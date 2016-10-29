package com.app.lesson2;

import java.util.Scanner;

public class Rectangle implements Shape {

    private double areaRectangle, perimetrRectangle, c, polPerimetr, areaTriangle, perimetrTriangle;
    private int a, b;

    Rectangle() {
        perimetrRectangle = 0;
        areaRectangle = 0;
        System.out.print("Введите длину стороны А: ");
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        System.out.print("Введите длину стороны B: ");
        b = scan.nextInt();
    }

    public void calculateArea() {

        areaRectangle = a * b;
        c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        polPerimetr = (a + b + c) / 2;
        areaTriangle = Math.sqrt(polPerimetr * (polPerimetr - a) * (polPerimetr - b) * (polPerimetr - c));
        System.out.format("calculateAreaRectangle = %.3f%n", areaRectangle);
        System.out.format("calculateAreaTriangle = %.3f%n", areaTriangle);

    }

    public void calculatePerimeter() {
        perimetrRectangle = 2 * (a + b);
        perimetrTriangle = a + b + c;
        System.out.println("create calculatePerimeterRectangle = " + perimetrRectangle);
        System.out.println("create calculatePerimeterTriangle = " + perimetrTriangle);

    }
}
