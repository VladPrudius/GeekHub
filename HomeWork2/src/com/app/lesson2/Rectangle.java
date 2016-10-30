package com.app.lesson2;

public class Rectangle implements Shape {

    private double polPerimetr;
    private double a;
    private double b;
    private double c;

    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculateArea() {
        return a * b;
    }

    public double calculateAreaTriangle(){

        c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        polPerimetr = (a + b + c) / 2;
        return  Math.sqrt(polPerimetr * (polPerimetr - a) * (polPerimetr - b) * (polPerimetr - c));
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (a + b);
    }

    public double calculatePerimeterTriangle(){
        return a + b + c;
    }
}
