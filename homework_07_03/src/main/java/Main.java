import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    /*
    Напишите шаблонный метод getMax который принимает на вход массив произвольного типа и компаратор
    */

    public static <T> void getMax (T[] t, Comparator<T> comparator) {

    }

    /*
    Напишите шаблонный метод equals который принимает две пары параметризованные одинаковыми типами
    и проверяет их на эквивалентность, сравнивая по значениям все их поля
    */

    public static <K, V> boolean equals (AbstractMap.SimpleEntry<K, V> e1, AbstractMap.SimpleEntry<K, V> e2) {
        return e1.getKey().equals(e2.getKey()) && e1.getValue().equals(e2.getValue());
    }

}









































