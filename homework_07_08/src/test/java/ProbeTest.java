import org.junit.Test;

import static org.junit.Assert.*;
/*
Для класса
public class Probe {
    public static int maxOfArray(int [] a)
    {
        // вернуть максимум массива
        return Arrays.stream(a).max().orElse(0);
    }

    public static boolean isOnlyPositive(int [] a)
    {
        // вернуть true если в массиве только положительные числа
        return Arrays.stream(a).allMatch(i -> i > 0);
    }
}
Проверьте что maxOfArray для {1,2,3,4} вернет 4
И что maxOfArray для пустого массива вернет 0 
*/
public class ProbeTest {
    @Test
    public void testMaxOfArray () {
        int [] i = {1, 2, 3, 4};
        int [] empty = new int[4];
        int [] negative = {-1, 2, 8, -5, 4};
        assertEquals(
                4,
                Probe.maxOfArray(i)
        );
        assertEquals(
                0,
                Probe.maxOfArray(empty)
        );
        assertTrue(
                Probe.isOnlyPositive(i)
        );
        assertFalse(
                Probe.isOnlyPositive(negative)
        );
    }
}
