package tw.m2n.library.model;
/**
 * @author moon
 *
 */
public class Reader {

    private String name;
    private int rPeriod;

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

    public void setPeriod() {
        this.rPeriod = (int) ((Math.random() + 1) * 5);
    }

    public int getPeriod() {
        return this.rPeriod;
    }
}
