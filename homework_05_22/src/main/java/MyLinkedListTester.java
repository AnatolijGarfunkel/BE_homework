import java.util.Iterator;

public class MyLinkedListTester {
    public static void main(String[] args) {
        MyLinkedListImpl list = new MyLinkedListImpl();
        list.add(24);
        list.add(17);
        list.add(99);
        list.add(74);

        System.out.println(list);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
