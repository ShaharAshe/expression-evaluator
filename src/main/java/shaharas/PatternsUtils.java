package shaharas;

final class PatternsUtils {
    private PatternsUtils() {
        throw new IllegalStateException("Pattern class is a utility class and should not be instantiated.");
    }
    // Basic operators
    static final String PLUS = "\\+"; // +
    static final String MINUS = "-"; // -
    static final String MULTIPLY = "\\*"; // *
    static final String DIVIDE = "/"; // /
//    static final String POWER = "\\^"; // ^

    // Increment/Decrement
//    static final String PRE_INCREMENT = "\\+\\+(?=\\w+)"; // ++i
//    static final String POST_INCREMENT = "(?<=\\w+)\\+\\+"; // i++
//    static final String PRE_DECREMENT = "--(?=\\w+)";
//    static final String POST_DECREMENT = "(?<=\\w+)--";

    // Assignment operators
    static final String EQL = "=";
    static final String PLUS_EQL = "\\+=";
    static final String MINUS_EQL = "-=";
    static final String MULTIPLY_EQL = "\\*=";
    static final String DIVIDE_EQL = "/=";

    // Variables and numbers
    static final String VARIABLE = "[a-zA-Z_][a-zA-Z0-9_]*"; // Pattern for variable names (the first character must be a letter or an underscore)
    static final String NUMBER = "\\d+"; // Pattern for numbers
    static final String NUMBER_OR_VARIABLE = NUMBER + "|" + VARIABLE; // Pattern for numbers or variables

    // Parentheses
//    static final String OPEN_PAREN = "\\("; // (
//    static final String CLOSE_PAREN = "\\)"; // )
}
