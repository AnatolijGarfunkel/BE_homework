import java.util.function.Predicate;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class LambdaMatcher extends BaseMatcher{
    private String description;
    private final Predicate<Integer> predicate;

    public LambdaMatcher(Predicate<Integer> predicate) {
        this.predicate = predicate;
    }

    public LambdaMatcher(Predicate<Integer> predicate, String description) {
        this.predicate = predicate;
        this.description = description;
    }

    @Override
    public boolean matches(Object o) {
        return predicate.test((Integer) o);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(this.description);
    }
}
