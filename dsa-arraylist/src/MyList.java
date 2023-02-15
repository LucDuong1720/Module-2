import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        this.size = capacity;
        this.elements = new Object[capacity];
    }
    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }
    public int size() {
        return this.elements.length;
    }

    public boolean contains(E o) {
        Object[] es = elements;
        if (o == null) {
            for (int i = 0; i < elements.length; i++) {
                if (es[i] == null) {
                    return true;
                }
            }
        }else {
            for (int i = 0; i < elements.length; i++) {
                if (o.equals(es[i])) {
                    return true;
                }
            }
        }
        return false;
    }

}