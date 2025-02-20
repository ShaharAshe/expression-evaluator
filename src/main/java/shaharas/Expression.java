package shaharas;

public class Expression {
    private final String expression;
    Expression(String expression) {
        this.expression = expression;
    }

    public void print() {
        System.out.println(this.expression);
    }
}
