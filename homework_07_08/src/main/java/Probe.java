import java.util.Arrays;

public class Probe {
    public static int maxOfArray (int [] a) {
        return Arrays.stream(a).max().orElse(0);
    }

    public static boolean isOnlyPositive (int [] a) {
        return Arrays.stream(a).allMatch(i -> i > 0);
    }
}
