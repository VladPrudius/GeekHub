package com.app.lesson2;

public class Triangle implements Shape {

    private double a;
    private double b;
    protected double c;

    Triangle(double a){
        this.a = a;
        this.b = a;
        this.c = Math.sqrt(2 *(Math.pow(a, 2)));
    }

    Triangle(double a, double b){
        this.a = a;
        this.b = b;
        this.c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculateArea() {
        double polPerimetr;
        polPerimetr = (a + b + c) / 2;
        return Math.sqrt(polPerimetr * (polPerimetr - a) * (polPerimetr - b) * (polPerimetr - c));
    }

    @Override
    public double calculatePerimeter() {

        return a + b + c;
    }
}
