package shaharas;

/**
 * The Utilities class is a utility class that provides constant values used throughout the expression evaluation system.
 * It contains various constants for operator symbols, priorities, input/output identifiers, and operator types.
 * This class is designed to assist other classes with predefined values and settings to ensure consistency and reduce code duplication.
 * <p>
 * Since this is a utility class, its constructor is private to prevent instantiation, and it is intended solely for providing constants.
 * </p>
 */
final class Utilities {
    // Prevent instantiation of this utility class
    private Utilities() {
        throw new IllegalStateException("Utility class");
    }

    // Input/output identifiers for the expression evaluator
    static final String INPUT = "-in";
    static final String OUTPUT = "-out";

    // Operator priorities
    static final int NONE_PRIORITY = -1;
    static final int REGULAR_PRIORITY = 0;
    static final int MORE_1_PRIORITY = 1;
    static final int MORE_2_PRIORITY = 2;
    static final int MORE_3_PRIORITY = 3;
    static final int TOP_PRIORITY = 5;

    // Basic operators
    static final String PLUS = "+";
    static final String MINUS = "-";
    static final String MULTIPLY = "*";
    static final String DIVIDE = "/";

    // Equality operators
    static final String EQUALS = "=";
    static final String PLUS_EQL = "+=";
    static final String MINUS_EQL = "-=";
    static final String MULTIPLY_EQL = "*=";
    static final String DIVIDE_EQL = "/=";

//    static final String MUL = "^";

    // Increment/Decrement operators
    static final String INCREMENT = "++";
    static final String DECREMENT = "--";

    // Parentheses
    static final String OPEN_PARENTHESIS = "(";
    static final String CLOSE_PARENTHESIS = ")";

}