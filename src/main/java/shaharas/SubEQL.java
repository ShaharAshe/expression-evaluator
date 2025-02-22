package shaharas;

// new SubEQL(1).calculate(2) -> 1 -= 2
public class SubEQL implements Operators {
    private int a;

    public SubEQL(){
        this.a = 0;
    }
    public SubEQL(int a){
        this.a = a;
    }

    @Override
    public Operators setA(int a){
        this.a = a;
        return this;
    }

    @Override
    public int calculate(int b){
        return new Div(this.a).calculate(b);
    }
}
