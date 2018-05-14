package tw.m2n.library.model;
/**
 * @author moon
 *
 */
public class Reader {

    private String name;
    private int timeSpend;

    public Reader() {};

    public Reader(String name) {
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
}
