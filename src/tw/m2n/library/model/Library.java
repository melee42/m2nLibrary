package tw.m2n.library.model;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author moon
 *
 */
public class Library {
    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    private Queue<Book> books = new PriorityQueue<Book>();

    public Library() {
        books.offer(new Book("1st episode"));
        books.offer(new Book("2nd episode"));
    }

    public Book hasBook() {
        rwl.readLock().lock();
        try {
            return books.peek();
        } finally {
            rwl.readLock().unlock();
        }
    }

    public Book checkOut() {
        rwl.writeLock().lock();
        try {
            return books.poll();
        } finally {
            rwl.writeLock().unlock();
        }
    }

    public void checkIn(Book book) {
        rwl.writeLock().lock();
        try {
            this.books.offer(book);
            notify();
        } finally {
            rwl.writeLock().unlock();
        }
    }
}
