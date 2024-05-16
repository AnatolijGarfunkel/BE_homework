import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(
                Arrays.asList(-2, 13, 6, 8, 15, 3, 23)
        );

        List<String> names = new ArrayList<>(
                Arrays.asList(
                        "Dima",
                        "Sam",
                        "Dima",
                        "Sam",
                        "Sam",
                        "Alina",
                        "Dima"
                )
        );

        System.out.println(numbers);
        System.out.println(evennum(numbers));
        System.out.println(secondMax(numbers));
        System.out.println(change(numbers));

        System.out.println(names);
        System.out.println(delete(names));
    }

    public static List evennum(List<Integer> nums) {
        List<Integer> evenNums = new ArrayList<>();

        for (Integer n: nums) {
            if (n % 2 == 0) {
                evenNums.add(n);
            }
        }
        return evenNums;
    };

    public static int secondMax(List<Integer> nums) {
        int max = nums.get(0);
        int second = nums.get(1);

        for (Integer n: nums) {
            if (n > max) {
                second = max;
                max = n;
            }
            if (n < max && n > second) {
                second = n;
            }
        }
        return second;
    }

    public static List change (List<Integer> nums) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = nums.size() - 1; i >= 0; i --) {
            numbers.add(nums.get(i));
        }
        return numbers;
    }

    public static List delete (List<String> names) {
        List<String> temp = new ArrayList<>();
        temp.addAll(names);

        for (int i = 0; i < temp.size(); i ++) {
            int count = 0;
            for (int j = 0; j < temp.size(); j ++) {
                if (temp.get(i).equals(temp.get(j))) {
                    count ++;
                    if (count > 1) {
                        names.remove(j);
                        temp.clear();
                        temp.addAll(names);
                        i = -1;
                        break;
                    }
                }
            }
        }

        return names;
    }
}
