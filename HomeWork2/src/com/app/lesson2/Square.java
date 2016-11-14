package com.app.lesson2;

public class Square implements Shape {

    Triangle triangle;

    Square(Triangle triangle){
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
