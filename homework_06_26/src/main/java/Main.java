import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        String fileName = "hw.txt";
        uniqueWords(fileName);
        getUnique(fileName);
    }

    /*
    Распечатайте уникальные слова из файла в обратном порядке - имя файла передается в метод в виде параметра
    public static void uniqueWords(String filename)
    */

    public static void uniqueWords (String filename) {
        try (
                Reader reader = new FileReader(filename);
                BufferedReader bufferedReader = new BufferedReader(reader);
                )
        {

            List<String> list = bufferedReader
                            .lines()
                            .map(m -> m.replace(",", ""))
                            .flatMap(m -> Arrays.stream(m.split(" ")))
                            .distinct()
                            .toList();

            Stack<String> stack = new Stack<>();
            stack.addAll(list);

            while (!stack.isEmpty()) {
                System.out.printf(stack.pop() + " ");
            }

        }
        catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    /*
    (xxx) Распечатайте в каких строках файла содержатся уникальные слова
    Например, если строки файла:
    один раз
    это один раз
    но только раз
    но один это два
    Результат:
    [{один: [0,1,2]}, {раз: [0,1,3]}, {это: [1,3]},{но:[2,3]} ...]
    Обратите внимание на IntStream.range(...)
     */

    public static void getUnique (String filename) {
        System.out.println("не получается.");
    }
}









































