package com.app.lesson2;

public class Square implements Shape {

    private double polPerimetr;
    private double b;
    private double a;

    Square(double a) {
        this.a = a;
    }

    @Override
    public double calculateArea() {
        return Math.pow(a, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 4 * a;
    }

    public double calculateAreaTriangle() {
        b = Math.sqrt(2 * (Math.pow(a, 2)));
        polPerimetr = (2 * a + b) / 2;
        return Math.sqrt(polPerimetr * 2 * (polPerimetr - a) * (polPerimetr - b));
    }

    public double calculatePerimetrTriangle() {
        return 2 * a + b;
    }
}
