package shaharas;

public class Div implements Operators {
    private final int a;
    public Div(int a){
        this.a = a;
    }

    @Override
    public int calculate(int b){
        if(b == 0) { throw new IllegalArgumentException("Cannot divide by zero."); }
        return this.a / b;
    }
}
