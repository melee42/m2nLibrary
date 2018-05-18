package tw.m2n.library.model;

/**
 * @author moon
 *
 */
public class Reader implements Runnable {

    private Library lib;
    private String name;
    private int timeSpend;

    public Reader() {
    };

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
        System.out.println(name + " checks out.");
        Book b = lib.checkOut();
        if (b == null)
            System.out.println(name + " is waiting.");
        this.setTimeSpend();
        try {
            System.out.println(name + " is reading.");
            Thread.sleep(timeSpend * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " read " + b.getName() + " for " + timeSpend + " sec.");
        lib.checkIn(b);
        System.out.println(name + " checked in book " + b.getName());
    }
}
