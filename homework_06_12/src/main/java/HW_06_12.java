import java.util.function.Function;
import java.util.function.UnaryOperator;



public class HW_06_12 {
    /**
     * Returns a {@link UnaryOperator} that accepts str to str function and returns the same function composed with trim
     *
     * @return function that composes functions with trim() function
     */
    public static UnaryOperator<Function<String, String>> composeWithTrimFunction() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return new UnaryOperator<Function<String, String>>() {
            @Override
            public Function<String, String> apply(Function<String, String> stringStringFunction) {
                return new Function<String, String>() {
                    @Override
                    public String apply(String string) {
                        return stringStringFunction.apply(string).trim();
                    }
                };
            }
        };
    }
}
