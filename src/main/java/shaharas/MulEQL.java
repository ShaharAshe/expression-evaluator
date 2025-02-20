package shaharas;

// new MulEQL(2).calculate(3) -> 2 *= 3
public class MulEQL implements Operators {
    private final int a;
    public MulEQL(int a){
        this.a = a;
    }

    @Override
    public int calculate(int b){
        return new Mul(this.a).calculate(b);
    }
}
