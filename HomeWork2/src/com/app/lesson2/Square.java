package com.app.lesson2;

public class Square implements Shape {

    private double areaRectangle;
    private double perimetrRectangle;
    private double polPerimetr;
    private double areaTriangle;
    private double perimetrTriangle;
    private double b;

    Square() {
        perimetrRectangle = 0;
        areaRectangle = 0;

    }

    public double calculateArea( double a) {

        areaRectangle = Math.pow(a, 2);
        b = Math.sqrt(2 * (Math.pow(a, 2)));
        return areaRectangle;
    }

    public double calculateAreaTriangle(double a) {

        polPerimetr = (2 * a + b) / 2;
        areaTriangle = Math.sqrt(polPerimetr * 2 * (polPerimetr - a) * (polPerimetr - b));
        return areaTriangle;
    }

    public double calculatePerimeter(double a) {

        perimetrRectangle = 4 * a;
        return perimetrRectangle;
    }

    public double calculatePerimetrTriangle(double a) {

        perimetrTriangle = 2 * a + b;
        return perimetrTriangle;
    }
}
