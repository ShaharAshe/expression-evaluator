package shaharas;

// new DivEQL(2).calculate(4) -> 2 /= 4
public class DivEQL implements Operators {
    private int a;

    public DivEQL(){
        this.a = 0;
    }
    public DivEQL(int a){
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
