package tw.m2n.library;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import tw.m2n.library.model.Book;

/**
 * @author moon
 *
 */
public class Library {
    private Lock lock = new ReentrantLock();

    private Queue<Book> books = new PriorityQueue<Book>();

    public Library() {
        books.offer(new Book("1st episode"));
        books.offer(new Book("2nd episode"));
    }

    public Book checkOut() {
        lock.lock();
        try {
            return books.poll();
        } finally {
            lock.unlock();
        }
    }

    public void checkIn(Book book) {
        lock.lock();
        try {
            this.books.offer(book);
            notify();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Library lib = new Library();
    }
}
