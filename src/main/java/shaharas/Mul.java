package shaharas;

public class Mul implements Operators {
    private int a;

    public Mul(){
        this.a = 0;
    }
    public Mul(int a){
        this.a = a;
    }

    @Override
    public Operators setA(int a){
        this.a = a;
        return this;
    }

    @Override
    public int calculate(int b){
        return this.a * b;
    }
}
