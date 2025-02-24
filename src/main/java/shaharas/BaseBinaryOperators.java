package shaharas;

abstract class BaseBinaryOperators extends BaseOperators {
    public BaseBinaryOperators(int a, int priority, String symbol) {
        super(a, priority, symbol);
    }
    public BaseBinaryOperators(BaseBinaryOperators a) {
        super(a);
    }

    public Operators setA(int a){
        super.setA(a);
        return this;
    }
    public abstract Operators clone();
    public abstract int calculate(String variable, int... args);
}
