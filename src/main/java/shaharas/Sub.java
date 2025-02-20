package shaharas;

public class Sub implements Operators {
    private final int a;
    Sub(int a){
        this.a = a;
    }

    @Override
    public int calculate(int b){
        return this.a - b;
    }
}
