package shaharas;

// new AddEQL(i).calculate(1) -> i += 1
public class AddEQL extends BaseBinaryOperators {
    public AddEQL() {
        super(0, Utilities.MORE_1_PRIORITY, Utilities.PLUS_EQL);
    }
    public AddEQL(AddEQL a) {
        super(a);
    }
    public AddEQL(int a) {
        super(a, Utilities.MORE_1_PRIORITY, Utilities.PLUS_EQL);
    }

    @Override
    public Operators clone() {
        return new AddEQL(this);
    }

    @Override
    public Operators setA(int a){
        super.setA(a);
        return this;
    }

    @Override
    public int calculate(String variable, int... args){
        int b = args[0];
        return new Add(super.getA()).calculate(variable, b);
    }
}
