package com.app.lesson2;

import java.util.Scanner;

public class HomeWork2 {

    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        String str = new String();
        double area;
        double a, b, c;
        System.out.println("Введите название фигуры: ");
        str = scan.nextLine();

        if (str.equals(ShapeType.Circle.toString())) {
            System.out.println("Вы выбрали фигуру: " + str);
            Circle circle = new Circle();
            System.out.print("Введите радиус круга: ");
            area = scan.nextDouble();
            System.out.format("Радиус круга = %.3f%n", circle.calculateArea(area));
            System.out.format("Периметр круга =  %.3f%n", circle.calculatePerimeter(area));
        }
        if (str.equals(ShapeType.Triangle.toString())) {
            System.out.println("Вы выбрали фигуру: " + str);
            Triangle triangle = new Triangle();
            System.out.print("Введите длину стороны А: ");
            a = scan.nextInt();
            System.out.print("Введите длину стороны B: ");
            b = scan.nextInt();
            System.out.print("Введите длину стороны C: ");
            c = scan.nextInt();
            System.out.format("calculateArea = %.3f%n",  triangle.calculateArea(a, b, c));
            System.out.println("calculatePerimeter = " + triangle.calculatePerimeter(a, b, c));
        }

        if (str.equals(ShapeType.Square.toString())) {
            System.out.println("Вы выбрали фигуру: " + str);
            Square square = new Square();
            System.out.print("Введите длину стороны А: ");
            a = scan.nextInt();
            System.out.format("calculateAreaSquare = %.3f%n",    square.calculateArea(a));
            System.out.format("calculateAreaTriangle = %.3f%n",  square.calculateAreaTriangle(a));
            System.out.println("calculatePerimeterSquare = " +   square.calculatePerimeter(a));
            System.out.println("calculatePerimeterTriangle = " + square.calculatePerimetrTriangle(a));
        }

        if (str.equals(ShapeType.Rectangle.toString())) {
            System.out.println("Вы выбрали фигуру: " + str);
            Rectangle rectangle = new Rectangle();
            System.out.print("Введите длину стороны А: ");
            a = scan.nextInt();
            System.out.print("Введите длину стороны B: ");
            b = scan.nextInt();
            System.out.format("calculateAreaRectangle = %.3f%n", rectangle.calculateArea(a , b));
            System.out.format("calculateAreaTriangle = %.3f%n", rectangle.calculateAreaTriangle(a, b));
            System.out.println("calculatePerimeterRectangle = " + rectangle.calculatePerimeter(a, b));
            System.out.println("calculatePerimeterTriangle = " + rectangle.calculatePerimeterTriangle(a, b));

        }

    }
}
