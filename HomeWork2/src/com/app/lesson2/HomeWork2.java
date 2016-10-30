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

        if (str.equals(ShapeType.CIRCLE.toString())) {
            System.out.println("Вы выбрали фигуру: " + str);

            System.out.print("Введите радиус круга: ");
            area = scan.nextDouble();
            Circle circle = new Circle(area);
            System.out.format("Радиус круга = %.3f%n", circle.calculateArea());
            System.out.format("Периметр круга =  %.3f%n", circle.calculatePerimeter());
        }
        if (str.equals(ShapeType.TRIANGLE.toString())) {
            System.out.println("Вы выбрали фигуру: " + str);
            System.out.print("Введите длину стороны А: ");
            a = scan.nextInt();
            System.out.print("Введите длину стороны B: ");
            b = scan.nextInt();
            System.out.print("Введите длину стороны C: ");
            c = scan.nextInt();
            Triangle triangle = new Triangle(a, b, c);
            System.out.format("calculateArea = %.3f%n",  triangle.calculateArea());
            System.out.println("calculatePerimeter = " + triangle.calculatePerimeter());
        }

        if (str.equals(ShapeType.SQUARE.toString())) {
            System.out.println("Вы выбрали фигуру: " + str);
            System.out.print("Введите длину стороны А: ");
            a = scan.nextInt();
            Square square = new Square(a);
            System.out.format("calculateAreaSquare = %.3f%n",    square.calculateArea());
            System.out.format("calculateAreaTriangle = %.3f%n",  square.calculateAreaTriangle());
            System.out.println("calculatePerimeterSquare = " +   square.calculatePerimeter());
            System.out.println("calculatePerimeterTriangle = " + square.calculatePerimetrTriangle());
        }

        if (str.equals(ShapeType.RECTANGLE.toString())) {
            System.out.println("Вы выбрали фигуру: " + str);
            System.out.print("Введите длину стороны А: ");
            a = scan.nextInt();
            System.out.print("Введите длину стороны B: ");
            b = scan.nextInt();
            Rectangle rectangle = new Rectangle(a, b);
            System.out.format("calculateAreaRectangle = %.3f%n", rectangle.calculateArea());
            System.out.format("calculateAreaTriangle = %.3f%n", rectangle.calculateAreaTriangle());
            System.out.println("calculatePerimeterRectangle = " + rectangle.calculatePerimeter());
            System.out.println("calculatePerimeterTriangle = " + rectangle.calculatePerimeterTriangle());

        }

    }
}
