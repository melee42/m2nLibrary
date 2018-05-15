package tw.m2n.library.model;

import tw.m2n.library.Library;

/**
 * @author moon
 *
 */
public class Reader implements Runnable {

    private Library lib;
    private String name;
    private int timeSpend;

    public Reader() {};

    public Reader(Library lib, String name) {
        this.lib = lib;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setTimeSpend() {
        this.timeSpend = (int) ((Math.random() + 1) * 5);
    }

    public int getTimeSpend() {
        return this.timeSpend;
    }

    @Override
    public void run() {
        Book b = lib.checkOut();
        if (b == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            this.setTimeSpend();
            try {
                wait(this.getTimeSpend() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " read " + b.getName() + " for " + this.getTimeSpend() + " sec.");
            lib.checkIn(b);
        }
    }
}
