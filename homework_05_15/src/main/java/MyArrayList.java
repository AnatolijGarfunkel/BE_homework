import java.util.*;

public class MyArrayList implements MyList{
    private int size = 0;
    private int [] data;
    private static final int INITIAL_CAPACITY = 4;

    public MyArrayList() {
        this.data = new int[INITIAL_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size(); i ++) {
            if (value == data[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = value;
    }

    @Override
    public void add(int value) {
        if (size() == data.length) {
            increaseCapacity();
        }
        data[size] = value;
        size ++;
    }

    private void increaseCapacity () {
        int [] newData = new int[data.length * 2];
        for (int i = 0; i < data.length; i ++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public void add(int index, int value) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if (size() == data.length) {
            increaseCapacity();
        }
        for (int i = size() - 1; i >= index; i --) {
            data[i + 1] = data[i];
        }
        size ++;
    }

    @Override
    public void remove(int index) {
        if (index <= 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index + 1; i < size(); i ++) {
            data[i - 1] = data[i];
        }
        size --;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int position = -1;
            @Override
            public boolean hasNext() {
                return ++position < size();
            }

            @Override
            public Integer next() {
                return get(position);
            }

            @Override
            public void remove() {
                MyArrayList.this.remove(position --);
            }
        };
    }

    @Override
    public Iterator<Integer> backward() {
        return new Iterator<Integer>() {
            private int position = size();
            @Override
            public boolean hasNext() {
                return -- position >= 0;
            }

            @Override
            public Integer next() {
                return get(position);
            }
        };
    }

    private List<Integer> sort (List<Integer> list) {
        Arrays.sort(list);
        return list.sort();
    }

    @Override
    public Iterator<Integer> sortIterator() {
        return new Iterator<Integer>() {
            private int position = -1;
            List<Integer> sortData = new ArrayList<>();
            /*
            думал создать новый масив и его отсортировать а там уже извлекать элементы по возрастающей, но java
            не позволяет что либо с этим массивом делать. Не знаю, как с этим быть.

             */
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return 0;
            }
        };
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return new ListIterator<Integer>() {
            private int position = -1;
            @Override
            public boolean hasNext() {
                return ++ position < size();
            }

            @Override
            public Integer next() {
                return data[position];
            }

            @Override
            public boolean hasPrevious() {
                return -- position >= 0;
            }

            @Override
            public Integer previous() {
                return data[position];
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(Integer integer) {

            }

            @Override
            public void add(Integer integer) {

            }
        };
    }

    @Override
    public String toString() {
        String r = "[";
        for (int i = 0; i < size(); i ++) {
            if (i != 0) {
                r += ",";
            }
            r += data[i];
        }
        r += "]";
        return r;
    }
}





























