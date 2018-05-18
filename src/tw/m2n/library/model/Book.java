package tw.m2n.library.model;
/**
 * @author moon
 *
 */
public class Book implements Comparable<Book> {

    private String name;

    public Book() {};

    public Book(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Book o) {
        return this.hashCode() - o.hashCode();
    }
}
