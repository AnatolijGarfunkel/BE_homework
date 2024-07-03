import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int count;
        String pattern = "video";

        count = countLines("text.txt");
        System.out.println("count of lines: " + count);

        count = countWordsWithPattern("text.txt", pattern);
        System.out.println("patern: " + pattern + " count of pattern: " + count);

        count = countWords("text.txt");
        System.out.println("count words: " + count);
    }

    /*
    Напишите метод, принимающий на вход имя текстового файла и воззвращающий количество строк в нем
    public static int countLines(String fileName)
    */

    public static int countLines (String fileName) {
        int linesCount = -1;

        try (

                Reader reader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(reader);

        )
        {

            linesCount = (int) bufferedReader
                    .lines()
                    .count();

        }
        catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return linesCount;
    }

    /*
    Посчитайте количество строк текстового файла, содержащих определенную подстроку
    public static int countWordsWithPattern(String fileName, String pattern)
    */

    public static int countWordsWithPattern(String fileName, String pattern) {
        int linesCount = -1;

        try (
                Reader reader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(reader);
        )
        {

            linesCount = (int) bufferedReader
                    .lines()
                    .filter(p -> p.contains(pattern))
                    .count();

        }
        catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return linesCount;
    }

    /*
    Посчитайте количество слов в текстовом файле - считается что слова отделяются пробелами
    public static int countWords(String fileName)
    */

    public static int countWords(String fileName) {
        int wordsCount = -1;

        try (

                Reader reader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(reader);

        )
        {

            wordsCount = (int) bufferedReader
                    .lines()
                    .flatMap(p -> Arrays.stream(p.split(" ")))
                    .count();

        }
        catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return wordsCount;
    }
}








































