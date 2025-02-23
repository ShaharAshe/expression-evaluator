package shaharas;

// new AddEQL(i).calculate(1) -> i += 1
public class AddEQL implements Operators {
    private int a;
    private final int priority;
    private final String symbol;

    public AddEQL(){
        this.a = 0;
        this.priority = Utilities.MORE_2_PRIORITY;
        this.symbol = Utilities.PLUS_EQL;
    }
    public AddEQL(AddEQL a){
        this.a = a.a;
        this.priority = Utilities.MORE_2_PRIORITY;
        this.symbol = Utilities.PLUS_EQL;
    }
    public AddEQL(int a){
        this.a = a;
        this.priority = Utilities.MORE_2_PRIORITY;
        this.symbol = Utilities.PLUS_EQL;
    }

    public int getPriority(){
        return this.priority;
    }

    @Override
    public Operators clone(){
        return new AddEQL(this);
    }

    @Override
    public Operators setA(int a){
        this.a = a;
        return this;
    }

    @Override
    public int calculate(int... args){
        int b = args[0];
        return new Add(this.a).calculate(b);
    }
}
