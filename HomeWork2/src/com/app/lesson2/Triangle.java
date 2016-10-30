package com.app.lesson2;

public class Triangle implements Shape {

    private double a;
    private double b;
    private double c;
    private double polPerimetr;

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculateArea() {

        polPerimetr = (a + b + c) / 2;
        return Math.sqrt(polPerimetr * (polPerimetr - a) * (polPerimetr - b) * (polPerimetr - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }
}
