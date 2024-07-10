import java.util.Iterator;

public interface MyList <T> extends Iterable<T> {
    int size();
    boolean contains(T value);
    void set(int index, T value);
    void add(T value);
    void add(int index, T value);
    void remove(int index);
    T get(int index);

    Iterator<T> iterator();
    Iterator<T> backward();
}
