package com.app.lesson2;

class Circle implements Shape {

    private double perimeter;
    private double area;

    Circle() {
        perimeter = 0;
        area = 0;
    }

    public double calculateArea(double radius) {

        area = (Math.PI * Math.pow(radius, 2));
        return area;
    }

    public double calculatePerimeter(double radius) {

        perimeter = (2 * Math.PI * radius);
        return perimeter;
    }
}
