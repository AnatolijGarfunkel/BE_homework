import javax.swing.plaf.IconUIResource;
import javax.swing.text.Position;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1.
        String s = "Hello, world!";
        System.out.println(getChars(s));


        // 2.
        Set<Integer> numbers = new HashSet<>(
                Arrays.asList(-1, 12,3,4,-8,-2)
        );

        setPositive(numbers);
        System.out.println(numbers);

        // 3.
        s = "один раз это один раз но только раз";
        System.out.println(getPositions(s));

    }

    public static Set<Character> getChars(String s) {
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < s.length(); i ++) {
            chars.add(s.charAt(i));
        }
        return chars;
    }

    public static void setPositive(Set<Integer> numbers) {
        Set<Integer> tempSet = new HashSet<>();
        for (Integer nums: numbers) {
            if (nums >= 0) {
                tempSet.add(nums);
            }
        }
        numbers.clear();
        numbers.addAll(tempSet);
    }

    public static List<Words> getPositions(String s) {
        Set<Words> words = new HashSet<>();
        List<Words> result = new ArrayList<>();
        Words temp;
        int position = 0;

        for (String data: s.split(" ")) {
            words.add(new Words(data, new TreeSet<>()));
            temp = new Words(data, new TreeSet<>());
            for (Words w: words) {
                if (w.equals(temp)) {
                    temp = w;
                    temp.position.add(position);
                    words.add(temp);
                }
            }
            position ++;
        }

        result.addAll(words);
        for (int i = 1; i < result.size(); i ++) {
            for (int j = 1; j < result.size(); j ++) {
                if (result.get(j - 1).position.first() > result.get(j).position.first()) {
                    Words t = result.get(j - 1);
                    result.set(j - 1, result.get(j));
                    result.set(j, t);
                }
            }
        }
        return result;
    }
}
