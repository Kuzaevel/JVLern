public class Lamp implements Comparable {

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String Name;
    public Lamp() {
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
