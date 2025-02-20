package shaharas;

public class Mul implements Operators {
    private final int a;
    public Mul(int a){
        this.a = a;
    }

    @Override
    public int calculate(int b){
        return this.a * b;
    }
}
