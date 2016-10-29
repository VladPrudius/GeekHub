package com.app.lesson2;

import java.util.Scanner;

public class HomeWork2 {

    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        String str = new String();
        System.out.println("Введите название фигуры: ");
        str = scan.nextLine();

        if (str.equals(TypeShape.Circle.toString())) {
            System.out.println("Вы выбрали фигуру: " + str);
            Circle circle = new Circle();
            circle.calculateArea();
            circle.calculatePerimeter();
        }
        if (str.equals(TypeShape.Rectangle.toString())) {
            System.out.println("Вы выбрали фигуру: " + str);
            Rectangle rectangle = new Rectangle();
            rectangle.calculateArea();
            rectangle.calculatePerimeter();
        }
        if (str.equals(TypeShape.Triangle.toString())) {
            System.out.println("Вы выбрали фигуру: " + str);
            Triangle triangle = new Triangle();
            triangle.calculateArea();
            triangle.calculatePerimeter();
        }
        if (str.equals(TypeShape.Square.toString())) {
            System.out.println("Вы выбрали фигуру: " + str);
            Square square = new Square();
            square.calculateArea();
            square.calculatePerimeter();
        }


    }
}
