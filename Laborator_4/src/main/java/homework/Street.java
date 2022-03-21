package homework;

public class Street implements Comparable <Street>{
    private String name;
    private int length;

    public Street(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }

    @Override
    public int compareTo(Street o) {
        if(this.getLength() > o.getLength())
            return 1;
        if(this.getLength() < o.getLength())
            return -1;
        return 0;
    }
}
