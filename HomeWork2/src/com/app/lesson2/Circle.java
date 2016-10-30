package com.app.lesson2;

class Circle implements Shape {

    private double area;

    Circle(double area) {
       this.area = area;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(area, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * area;
    }

}
