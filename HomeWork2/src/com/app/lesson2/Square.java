package com.app.lesson2;

import java.util.Scanner;

public class Square {

    private double areaRectangle, perimetrRectangle, polPerimetr, areaTriangle, perimetrTriangle, b;
    private int a;

    Square() {
        perimetrRectangle = 0;
        areaRectangle = 0;
        System.out.print("Введите длину стороны А: ");
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
    }

    public void calculateArea() {

        areaRectangle = Math.pow(a, 2);
        b = Math.sqrt(2 * (Math.pow(a, 2)));
        polPerimetr = (2 * a + b) / 2;
        areaTriangle = Math.sqrt(polPerimetr * 2 * (polPerimetr - a) * (polPerimetr - b));
        System.out.format("calculateAreaRectangle = %.3f%n", areaRectangle);
        System.out.format("calculateAreaTriangle = %.3f%n", areaTriangle);

    }

    public void calculatePerimeter() {
        perimetrRectangle = 4 * a;
        perimetrTriangle = 2 * a + b;
        System.out.println("create calculatePerimeterRectangle = " + perimetrRectangle);
        System.out.println("create calculatePerimeterTriangle = " + perimetrTriangle);

    }
}
