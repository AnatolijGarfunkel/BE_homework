import java.util.*;

public class Main {
    public static void main(String[] args) {
/*
        Напишите класс который считывает вводимые пользователем строки с консоли до того момента как встретится строка
        quit После этого все до введенные ранее строки нужно распечатать в обратном порядке.
 */

        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        do {
            stack.push(scanner.next());
        } while (!stack.peek().equals("quit"));
        stack.pop();

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        scanner.close();

        /*
        ** 2. Напишите метод, который принимает на вход список целых и число k
        Метод должен возвратить список, в котором первые k чисел поменялись местами и должны находится в обратном порядке
        Например: [10, 20, 30, 40, 50], 4 -> [40, 30, 20, 10, 50]
        Желательно сделать с помощью стэков/очередей
         */

        Queue<Integer> nums = new LinkedList<>(
                Arrays.asList(10, 20, 30, 40, 50)
        );

        System.out.println(change(nums, 4));

    }

    public static List<Integer> change (Queue<Integer> nums, int k) {
        Stack<Integer> temp = new Stack<>();
        while (k > 0) {
            temp.add(nums.poll());
            k --;
        }

        List<Integer> result = new ArrayList<>();
        while (!temp.isEmpty()) {
            result.add(temp.pop());
        }

        while (!nums.isEmpty()) {
            result.add(nums.poll());
        }

        return result;
    }
}
