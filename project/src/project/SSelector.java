
public class SSelector implements Selector {
    private int i = 0;
    private Sequence seq;

    public SSelector(Sequence seq) {
        this.seq = seq;
    }

    @Override
    public boolean end() {
        return i == seq.getObjects().length;
    }

    @Override
    public Object current() {
        return seq.getObjects()[i];
    }

    @Override
    public void next() {
        if (i < seq.getObjects().length) i++;
    }
}
