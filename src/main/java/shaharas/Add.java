package shaharas;

public class Add implements Operators{
    private final int a;
    public Add(int a){
        this.a = a;
    }

    @Override
    public int calculate(int b){
        return this.a + b;
    }
}
