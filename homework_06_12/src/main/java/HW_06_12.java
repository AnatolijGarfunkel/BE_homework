import java.util.function.Function;
import java.util.function.UnaryOperator;



public class HW_06_12 {
    /**
     * Returns a {@link LongBinaryOperator} sum operation.
     *
     * @return binary sum operation
     */
    public static LongBinaryOperator longSumOperation() {
        // throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return (left, right) -> left + right;
    }

    /**
     * Returns a {@link ToIntFunction<String>} that converts string to integer.
     *
     * @return string to int converter
     */
    public static ToIntFunction<String> stringToIntConverter() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String value) {
                return Integer.parseInt(value);
            }
        };
    }

    /**
     * Receives int parameter n, and returns a {@link Supplier} that supplies {@link IntUnaryOperator}
     * that is a function f(x) = n * x
     *
     * @param n a multiplier
     * @return a function supplier
     */
    public static Supplier<IntUnaryOperator> nMultiplyFunctionSupplier(int n) {
         //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return () -> operand -> operand * n;

    }

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
//  на большее меня не хватило
}
