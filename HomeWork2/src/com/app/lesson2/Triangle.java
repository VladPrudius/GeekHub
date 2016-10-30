package com.app.lesson2;

public class Triangle implements Shape {

    private double area;
    private double perimetr;
    private double polPerimetr;

    Triangle() {
        perimetr = 0;
        area = 0;

    }

    public double calculateArea(double area) {
        return 0;
    }

    public double calculatePerimeter(double perimetr) {
        return 0;
    }

    public double calculateArea(double a, double b, double c) {

        polPerimetr = (a + b + c) / 2;
        area = Math.sqrt(polPerimetr * (polPerimetr - a) * (polPerimetr - b) * (polPerimetr - c));
        return area;
    }

    public double calculatePerimeter(double a, double b, double c) {

        perimetr = a + b + c;
        return perimetr;
    }
}
