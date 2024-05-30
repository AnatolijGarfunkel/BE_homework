import java.util.Iterator;

public class MyLinkedListImpl implements MyLinkedList{

    private Node head;
    private int size = 0;

    @Override
    public int removeFirst() {
        if (head == null) {
            return head.getValue();
        }
        size --;
        int result = head.getValue();
        head = head.getNext();
        head.getNext().setPrev(head);
        return result;
    }

    @Override
    public void addFirst(int value) {
        size ++;
        head = new Node(value, null, head);
        head.getNext().setPrev(head.getNext());
    }

    @Override
    public int getFirst() {
        return head.getValue();
    }

    private static class Node {
        private int value;
        private Node prev;
        private Node next;

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNode(Node prev, Node next) {
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(int value) {
        Node n = head;
        while (n != null) {
            if (n.getValue() == value) {
                return true;
            }
            n = n.getNext();
        }
        return false;
    }

    private Node getNodeByIndex (int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node n = head;
        for (int i = 0; i < index; i ++) {
            if (n != null) {
                n = n.getNext();
            }
            else {
                throw new IndexOutOfBoundsException();
            }
        }
        if (n == null){
            throw new IndexOutOfBoundsException();
        }
        return n;
    }

    @Override
    public void set(int index, int value) {
        Node n = getNodeByIndex(index);
        if (n != null) {
            n.setValue(value);
        }
    }

    @Override
    public void add(int value) {
        size ++;
        Node node = new Node(value, null, null);
        if (head == null) {
            head = node;
            return;
        }
        Node n = head;
        while (n.getNext() != null) {
            n = n.getNext();
        }
        Node newLast = new Node(value, n, null);
        n.setNext(newLast);
        n.getNext().setPrev(n);
    }

    @Override
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        size ++;
        if (index == 0) {
            Node prevHead = head;
            head = new Node(value, null, prevHead);
        }
        else {
            Node prev = getNodeByIndex(index - 1);
            Node next = prev.next;
            Node newNode = new Node(value, prev, next);
            prev.setNext(newNode);
            next.setPrev(newNode);
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            if (head == null) {
                return;
            }
            head = head.getNext();
        }
        else if (index == size - 1) {
            Node prev = getNodeByIndex(index - 1);
            prev.setNext(null);
        }
        else {
            Node prev = getNodeByIndex(index - 1);
            Node current = getNodeByIndex(index);
            prev.setNext(current.getNext());
            current.getNext().setPrev(prev);
        }
        size --;
    }

    @Override
    public int get(int index) {
        Node n = getNodeByIndex(index);

        return n.getValue();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node n = new Node(0, null, head);
            @Override
            public boolean hasNext() {
                n = n.getNext();
                return n != null;
            }

            @Override
            public Integer next() {
                return n.getValue();
            }
        };
    }

    @Override
    public Iterator<Integer> backward() {
        return null;
    }

    @Override
    public String toString() {
        String result = "[";

        Node n = head;

        while (n != null) {
            int v = n.getValue();
            result += v;
            n = n.getNext();
            if (n != null) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    public void printElement (int index) {
        Node n = getNodeByIndex(index);
        if (n.getPrev() == null && n.getNext() == null) {
            System.out.println("null - " + n.getValue() + " - null");
        }
        else if (n.getPrev() == null) {
            System.out.println("null - " + n.getValue() + " - " + n.getNext().getValue());
        }
        else if (n.getNext() == null) {
            System.out.println(n.getPrev().getValue() + " - " + n.getValue() + " - null");
        }
        else {
            System.out.println(n.getPrev().getValue() + " - " + n.getValue() + " - " + n.getNext().getValue());
        }
    }

}
