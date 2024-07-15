import java.util.List;
import org.hamcrest.Matchers;
import java.util.function.Predicate;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class MainTest {
    /*
    Напишите тест который проверит что в
    List<Integer> odds = List.of(22, 12, 6);
    Все значения четные.
    Воспользуйтесь LambdaMatcher
     */
    @Test
    public void TestIsEven () {
        List<Integer> odds = List.of(22, 12, 6);
        LambdaMatcher matcher = new LambdaMatcher(integer -> integer % 2 == 0);

        assertThat(
                odds,
                Matchers.everyItem(
                        matcher
                )
        );
    }

}
