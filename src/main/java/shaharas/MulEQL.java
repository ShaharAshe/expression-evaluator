package shaharas;

// new MulEQL(2).calculate(3) -> 2 *= 3
public class MulEQL implements Operators {
    private int a;

    public MulEQL(){
        this.a = 0;
    }
    public MulEQL(int a){
        this.a = a;
    }

    @Override
    public Operators setA(int a){
        this.a = a;
        return this;
    }

    @Override
    public int calculate(int b){
        return new Mul(this.a).calculate(b);
    }
}
