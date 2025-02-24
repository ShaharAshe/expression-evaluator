package shaharas;


final class Utilities {
    private Utilities() {
        throw new IllegalStateException("Utility class");
    }
    static final String INPUT = "-in";
    static final String OUTPUT = "-out";

    static final int NONE_PRIORITY = -1;
    static final int REGULAR_PRIORITY = 0;
    static final int MORE_1_PRIORITY = 1;
    static final int MORE_2_PRIORITY = 2;
    static final int MORE_3_PRIORITY = 3;
    static final int TOP_PRIORITY = 5;

    static final String BINARY = "binary";
    static final String UNARY = "unary";
    static final String NONE = "none";

    static final String PLUS = "+";
    static final String MINUS = "-";
    static final String MULTIPLY = "*";
    static final String DIVIDE = "/";

    static final String EQUALS = "=";
    static final String PLUS_EQL = "+=";
    static final String MINUS_EQL = "-=";
    static final String MULTIPLY_EQL = "*=";
    static final String DIVIDE_EQL = "/=";

    static final String MUL = "^";

    static final String INCREMENT = "++";
    static final String DECREMENT = "--";

    static final String OPEN_PARENTHESIS = "(";
    static final String CLOSE_PARENTHESIS = ")";

}