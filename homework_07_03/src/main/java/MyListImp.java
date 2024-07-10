import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class MyListImp <T> implements MyList<T> {
    private int size = 0;
    private T[] data;
    private static final int INITIAL_CAPACITY = 4;

    public MyListImp() {
        data = (T[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size(); i ++) {
            if (value.equals(data[i]))
                return true;
        }
        return false;
    }

    @Override
    public void set(int index, T value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        data[index] = value;
    }

    @Override
    public void add(T value) {
        if (size() == data.length)
            increaseCapacity();
        data[size] = value;
        size ++;
    }

    private void increaseCapacity() {
        T[] newData = (T[]) new Object[data.length * 2];
        for (int i = 0; i < data.length; i ++)
            newData[i] = data[i];

        data = newData;
    }

    @Override
    public String toString() {
        String r = "[";
        for (int i = 0; i < size(); i ++) {
            if (i != 0)
                r += ",";
            r += data[i];
        }
        r += "]";
        return r;
    }

    @Override
    public void add(int index, T value) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        if (size() == data.length)
            increaseCapacity();
        for (int i = size() - 1; i >= index; i --)
            data[i + 1] = data[i];
        data[index] = value;
        size ++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        for (int i = index + 1; i < size(); i ++)
            data[i - 1] = data[i];
        size --;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = -1;
            @Override
            public boolean hasNext() {
                return ++ position < size();
            }

            @Override
            public T next() {
                return get(position);
            }

            public void remove() {
                MyListImp.this.remove(position --);
            }
        };
    }

    @Override
    public Iterator<T> backward() {
        return new Iterator<T>() {
            private int position = size();
            @Override
            public boolean hasNext() {
                return -- position >= 0;
            }

            @Override
            public T next() {
                return get(position);
            }
        };
    }

    public Iterator<T> smallToBig () {
        return new SmallToBigIterator();
    }

    private class SmallToBigIterator implements Iterator<T> {
        private T[] source = (T[]) new Object[size()];
        private int position = -1;

        public SmallToBigIterator () {
            System.arraycopy(data, 0, source, 0, size());
            Arrays.sort(source);
        }

        @Override
        public boolean hasNext() {
            return ++ position < size;
        }

        @Override
        public T next() {
            return source[position];
        }
    }

    public ListIterator<T> listIterator () {
        return new ListIterator<T>() {
            private int position = -1;
            @Override
            public boolean hasNext() {
                return ++ position < size();
            }

            @Override
            public T next() {
                return get(position);
            }

            @Override
            public boolean hasPrevious() {
                return -- position >= 0;
            }

            @Override
            public T previous() {
                return get(position);
            }

            @Override
            public int nextIndex() {
                return Math.min(position + 1, size());
            }

            @Override
            public int previousIndex() {
                return Math.max(-1, position -1);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }

            @Override
            public void set(T t) {
                throw new UnsupportedOperationException("set");
            }

            @Override
            public void add(T t) {
                throw new UnsupportedOperationException("add");
            }
        };
    }
}









































