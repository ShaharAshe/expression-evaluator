package shaharas;

// new DivEQL(2).calculate(4) -> 2 /= 4
public class DivEQL extends BaseOperators {
    public DivEQL(){
        super(0, Utilities.MORE_2_PRIORITY, Utilities.DIVIDE_EQL);
    }
    public DivEQL(DivEQL a){
        super(a);
    }
    public DivEQL(int a){
        super(a, Utilities.MORE_2_PRIORITY, Utilities.DIVIDE_EQL);
    }

    @Override
    public Operators clone(){
        return new DivEQL(this);
    }

    @Override
    public Operators setA(int a){
        super.setA(a);
        return this;
    }

    @Override
    public int calculate(String variable, int... args){
        int b = args[0];
        return new Div(super.getA()).calculate(variable, b);
    }
}
