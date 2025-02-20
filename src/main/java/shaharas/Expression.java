package shaharas;

public class Expression {
    private String expression;
    Expression(String expression) {
        this.expression = expression;
    }

    public void print() {
        System.out.println(this.expression);
    }
}
