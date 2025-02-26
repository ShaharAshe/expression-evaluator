package shaharas;

/**
 * Utility class that holds the regular expression patterns for various types of operators,
 * assignment operations, variable and number patterns, and parentheses. This class is designed
 * to avoid instantiation and only provides static constants for use in the program.
 */
final class PatternsUtils {
    // Prevent instantiation of this utility class
    private PatternsUtils() {
        throw new IllegalStateException("Pattern class is a utility class and should not be instantiated.");
    }

    // Basic operators
    static final String PLUS = "^\\+$"; // +
    static final String MINUS = "^-$"; // -
    static final String MULTIPLY = "^\\*$"; // *
    static final String DIVIDE = "^/$"; // /
    // static final String POWER = "^([a-zA-Z_][a-zA-Z0-9_]*|\\d+)\\^([a-zA-Z_][a-zA-Z0-9_]*|\\d+)$"; // ^

    // Increment/Decrement
    static final String PRE_INCREMENT = "^\\+\\+([a-zA-Z_][a-zA-Z0-9_]*)$"; // ++i
    static final String POST_INCREMENT = "^([a-zA-Z_][a-zA-Z0-9_]*)\\+\\+$"; // i++
    static final String PRE_DECREMENT = "^--([a-zA-Z_][a-zA-Z0-9_]*)$"; // --i
    static final String POST_DECREMENT = "^([a-zA-Z_][a-zA-Z0-9_]*)--$"; // i--

    // Assignment operators
    static final String EQL = "^=$"; // =
    static final String PLUS_EQL = "^\\+=$"; // +=
    static final String MINUS_EQL = "^-=$"; // -=
    static final String MULTIPLY_EQL = "^\\*=$"; // *=
    static final String DIVIDE_EQL = "^/=$"; // /=

    // Variables and numbers
    static final String VARIABLE = "^[a-zA-Z_][a-zA-Z0-9_]*$"; // Pattern for variable names (the first character must be a letter or an underscore)
    static final String NUMBER = "^-?\\d+$"; // Pattern for numbers

    // Parentheses
    static final String OPEN_PAREN = "^\\($"; // (
    static final String CLOSE_PAREN = "^\\)$"; // )
}
