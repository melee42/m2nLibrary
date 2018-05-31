package tw.m2n.library.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author moon
 *
 */
public class Reader implements Runnable {

    private Library lib;
    private String name;
    private int timeSpend;
    private String message = "%s %s spends %d seconds to read %s.";
    private SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

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
        while (true) {
            Book b = null;
            synchronized (lib) {
                while (!lib.hasBook()) {
                    try {
                        lib.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                b = lib.checkOut();
            }
            this.setTimeSpend();
            try {
                Thread.sleep(timeSpend * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format(message, sdf.format(new Date()), name, timeSpend, b.getName()));
            lib.checkIn(b);
            synchronized (lib) {
                lib.notifyAll();
            }
        }
    }
}
