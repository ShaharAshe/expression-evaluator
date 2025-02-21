package shaharas;

public class Expression {
    private final String expression;
    Expression(String expression) {
        this.expression = expression;
    }

    public void print() {
        System.out.println(this.expression);
    }

    public void calculate() {/* TODO: Implement the calculate method */}

    public int size() {
        return this.expression.length();
    }

    public String getExpressionByIndex(int index) {
        return String.valueOf(this.expression.charAt(index));
    }
}
