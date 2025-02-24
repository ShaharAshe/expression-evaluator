package shaharas;

import java.util.regex.Pattern;

public class Add extends BaseBinaryOperators {
    public Add(){
        super(0, Pattern.compile(PatternsUtils.PLUS), Utilities.PLUS, Utilities.REGULAR_PRIORITY);
    }
    public Add(Add a){
        super(a);
    }
    public Add(int a){
        super(a, Pattern.compile(PatternsUtils.PLUS), Utilities.PLUS, Utilities.REGULAR_PRIORITY);
    }

    @Override
    public Operators clone(){
        return new Add(this);
    }

    @Override
    public Operators setA(int a){
        super.setA(a);
        return this;
    }

    @Override
    public int calculate(String variable, int... args){
        int b = args[0];
        return super.getA() + b;
    }
}
