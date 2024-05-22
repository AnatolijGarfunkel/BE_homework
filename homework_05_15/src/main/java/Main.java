import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> countrie = new ArrayList<>(Arrays.asList("Andorra", "Belize", "Cayman", "France", "Argentina", "Cuba", "Sweden", "austria"));
        List<String> words = new ArrayList<>(Arrays.asList("Andorra", "Canada", "First", "candy", "austria", "Argentina", "wood", "parrot", "cat", "Alan", "Cuba", "Finland", "Axelrod" , "Avangard", "Cuba"));

        countrie.retainAll(words);

        List<Integer> num1 = new ArrayList<>(Arrays.asList(1, 2, 5, 5, 8, 9, 7, 10));
        List<Integer> num2 = new ArrayList<>(Arrays.asList(1, 0, 6, 15, 6, 4, 7, 0));
        List<Integer> num = new ArrayList<>();
        num.addAll(joint(num1, num2));

        for (Integer n: num) {
            System.out.println(n);
        }
    }

    public static List joint (List<Integer> num1, List<Integer> num2) {
        List<Integer> jointNums = new ArrayList<>();
        jointNums.addAll(num1);
        jointNums.retainAll(num2);

        return jointNums;
    }
}
