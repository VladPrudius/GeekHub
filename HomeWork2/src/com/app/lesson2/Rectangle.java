package com.app.lesson2;

public class Rectangle implements Shape {

    private double areaRectangle;
    private double perimetrRectangle;
    private double polPerimetr;
    private double areaTriangle;
    private double perimetrTriangle;
    private double c;

    Rectangle() {
        perimetrRectangle = 0;
        areaRectangle = 0;
    }

    public double calculateArea(double areaRectangle) {
       return 0;
    }

    public double calculatePerimeter(double radius) {
        return 0;
    }

    public double calculateArea(double a, double b) {

        areaRectangle = a * b;
        return areaRectangle;
    }
    public double calculateAreaTriangle(double a, double b){

        c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        polPerimetr = (a + b + c) / 2;
        areaTriangle = Math.sqrt(polPerimetr * (polPerimetr - a) * (polPerimetr - b) * (polPerimetr - c));
        return  areaTriangle;
    }

    public double calculatePerimeter(double a, double b) {

        perimetrRectangle = 2 * (a + b);
        return perimetrRectangle;
    }
    public double calculatePerimeterTriangle(double a, double b){

        perimetrTriangle = a + b + c;
        return perimetrTriangle;
    }
}
