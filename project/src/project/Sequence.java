
public class Sequence {
    private Object[] objects;
    private int next = 0;

    public Sequence(int size) {
        objects = new Object[size];
    }

    public void add(Object x) {
        if (next < objects.length) {
            objects[next] = x;
            next++;
        }
    }

    public Selector getSelector() {
        return new SSelector(this);
    }
    Object[] getObjects() {
        return objects;
    }
}
