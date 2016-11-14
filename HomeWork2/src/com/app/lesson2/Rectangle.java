package com.app.lesson2;

public class Rectangle implements Shape {

    Triangle triangle;

    Rectangle(Triangle triangle){
        this.triangle = triangle;
    }

    @Override
    public double calculateArea() {
        return triangle.calculateArea() + triangle.calculateArea();
    }

    @Override
    public double calculatePerimeter() {
        return triangle.calculatePerimeter() + triangle.calculatePerimeter() - triangle.c * 2;
    }

}
