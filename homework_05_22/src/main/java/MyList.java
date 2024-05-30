import java.util.Iterator;

public interface MyList extends Iterable<Integer> {
    int size();
    boolean contains(int value);
    void set (int index, int value);
    void add(int value);
    void add(int index, int value);
    void remove(int index);
    int get(int index);
    Iterator<Integer> iterator();
    Iterator<Integer> backward();

}
