package HomeWorkPart2;

import java.util.Comparator;

public class Car implements Comparable<Car> {
    private String name;
    private int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Car o) {
        return name.compareTo(o.getName());
    }

    public String getName() {
        return name;
    }

    public static Comparator<Car> NameComparator = new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.compareTo(o2);
        }
    };
    public static Comparator<Car> PriceComparator = new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.getPrice() - o2.getPrice();
        }
    };
    public static Comparator<Car> CompByNameAndPrice = new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            if (o1.getName().indexOf(2) == o2.getName().indexOf(2)) {
                return o1.getPrice() - o2.getPrice();
            }
            return o1.compareTo(o2);
        }
    };
}

