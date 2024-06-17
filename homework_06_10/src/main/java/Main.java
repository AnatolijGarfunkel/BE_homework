import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        /*
        выберите только элементы длиной меньше 7 символов
        преобразуйте их в верхний регистр
        добавьте к ним длину
        вызовите функцию которая преобразует строки в обратный порядок

        Пример: ["Dima", "Max", "Alexander"] -> ["4-AMID", "3-XAM"]
        */

        List<String> names = List.of("Dima", "Max", "Alexander");

        System.out.println(
                names
                        .stream()
                        .filter(n -> n.length() < 7)
                        .map(n -> n.toUpperCase())
                        .map(n -> n + "-" + n.length())
                        // операции со StringBuilder перепесал с домашки, до этого всё сам
                        .map(StringBuilder::new)
                        .map(builder -> builder.reverse())
                        .map(builder -> builder.toString())
                        .toList()
        );
    }
}
