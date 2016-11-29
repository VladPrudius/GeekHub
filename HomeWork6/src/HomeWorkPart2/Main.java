package HomeWorkPart2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArraySorter arraySorter = new ArraySorter();
        Comparable[] books = new Comparable[3];
        Comparable[] b;
        Car[] cars = new Car[3];
        PerformanceTest performanceTest = new PerformanceTest();
        performanceTest.pervormancedTest();

        books[0] = new Book("Book", 10);
        books[1] = new Book("Book2", 12);
        books[2] = new Book("Book3", 15);

        cars[0] = new Car("Shkoda", 5000);
        cars[1] = new Car("Shkoda3", 1000);
        cars[2] = new Car("Mersedec", 1500);
        Arrays.sort(cars, Car.CompByNameAndPrice);

        b = arraySorter.bubbleSort(books, Direction.ASC);
        b = arraySorter.selectionSort(books, Direction.ASC);
        b = arraySorter.insertionSort(books, Direction.ASC);
    }
}
