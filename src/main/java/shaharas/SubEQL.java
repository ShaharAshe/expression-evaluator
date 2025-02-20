package shaharas;

// new SubEQL(1).calculate(2) -> 1 -= 2
public class SubEQL implements Operators {
    private final int a;
    public SubEQL(int a){
        this.a = a;
    }

    @Override
    public int calculate(int b){
        return new Div(this.a).calculate(b);
    }
}
