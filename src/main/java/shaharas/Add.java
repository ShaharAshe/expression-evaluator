package shaharas;

public class Add implements Operators{
    private int a;
    private final int priority;
    private final String symbol;

    public Add(){
        this.a = 0;
        this.priority = Utilities.REGULAR_PRIORITY;
        this.symbol = Utilities.PLUS;
    }
    public Add(Add a){
        this.a = a.a;
        this.priority = Utilities.REGULAR_PRIORITY;
        this.symbol = Utilities.PLUS;
    }
    public Add(int a){
        this.a = a;
        this.priority = Utilities.REGULAR_PRIORITY;
        this.symbol = Utilities.PLUS;
    }

    public int getPriority(){
        return this.priority;
    }

    @Override
    public Operators clone(){
        return new Add(this);
    }

    @Override
    public Operators setA(int a){
        this.a = a;
        return this;
    }

    @Override
    public int calculate(int... args){
        int b = args[0];
        return this.a + b;
    }
}
