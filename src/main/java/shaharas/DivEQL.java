package shaharas;

// new DivEQL(2).calculate(4) -> 2 /= 4
public class DivEQL implements Operators {
    private final int a;
    public DivEQL(int a){
        this.a = a;
    }

    @Override
    public int calculate(int b){
        return new Div(this.a).calculate(b);
    }
}
