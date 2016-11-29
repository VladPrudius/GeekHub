package HomeWorkPart2;

/**
 * Created by Влад on 27.11.2016.
 */
public class Book implements Comparable<Book> {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Book o) {
        return name.compareTo(o.getName());
    }

    public String getName() {
        return name;
    }
}
