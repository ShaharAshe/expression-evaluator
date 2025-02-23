package shaharas;

// new SubEQL(1).calculate(2) -> 1 -= 2
public class SubEQL extends BaseOperators {
    public SubEQL(){
        super(0, Utilities.MORE_2_PRIORITY, Utilities.MINUS_EQL);
    }
    public SubEQL(SubEQL a){
        super(a);
    }
    public SubEQL(int a){
        super(a, Utilities.MORE_2_PRIORITY, Utilities.MINUS_EQL);
    }

    @Override
    public Operators clone(){
        return new SubEQL(this);
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