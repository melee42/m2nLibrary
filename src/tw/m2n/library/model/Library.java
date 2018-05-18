package tw.m2n.library.model;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author moon
 *
 */
public class Library {
    private Queue<Book> books = new PriorityQueue<Book>();

    public Library() {
        books.offer(new Book("1st episode"));
        books.offer(new Book("2nd episode"));
    }

    public synchronized Book hasBook() {
        return books.peek();
    }

    public synchronized Book checkOut() {
        Book b = books.poll();
        try {
            while (b == null)
                wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return b;
    }

    public synchronized void checkIn(Book book) {
        books.offer(book);
        notifyAll();
        // notify();
    }
}
