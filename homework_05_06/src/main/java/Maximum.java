public class Maximum {
    public static void main(String[] args) {
        int [][] numbers = {{8, 3, 9, 15},
                            {39, 3, 91, -6},
                            {-77, 0, 32, 56}
                            };

        if (isArray(numbers)) {
            getMaximum(numbers);
        }
        toPrint(numbers);
    }

    public static int getMaximum(int [][] numbers) {
        int max = numbers[0][0];
        for (int i = 0; i < numbers.length; i ++) {
            for (int j = 0; j < numbers[i].length; j ++) {
                max = numbers[i][j] > max ? numbers[i][j] : max;
            }
        }
        return max;
    }

    public static boolean isArray (int [] array) {
        return array.length > 0;
    }

    public static boolean isArray (int [][] array) {
        for (int i = 0; i < array.length; i ++) {
            if (!isArray(array[i])) {
                return false;
            }
        }
        return true;
    }

    public static void toPrint(int [][] array) {
        System.out.println("[");
        for (int i = 0; i < array.length; i ++) {
            System.out.print("  [");
            for (int j = 0; j < array[i].length; j ++) {
                if (array[i].length - j == 1) {
                    System.out.print(array[i][j]);
                }
                else {
                    System.out.print(array[i][j] + ", ");
                }
            }
            if (array.length - i == 1) {
                System.out.println("]");
            }
            else {
                System.out.println("],");
            }
        }
        System.out.println("]");
    }
}
