package shaharas;

public class Div implements Operators {
    private int a;

    public Div(){
        this.a = 0;
    }
    public Div(int a){
        this.a = a;
    }

    @Override
    public Operators setA(int a){
        this.a = a;
        return this;
    }

    @Override
    public int calculate(int b){
        if(b == 0) { throw new IllegalArgumentException("Cannot divide by zero."); }
        return this.a / b;
    }
}
