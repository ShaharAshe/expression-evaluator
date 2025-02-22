package shaharas;

public class Add implements Operators{
    private int a;

    public Add(){
        this.a = 0;
    }
    public Add(int a){
        this.a = a;
    }

    @Override
    public Operators setA(int a){
        this.a = a;
        return this;
    }

    @Override
    public int calculate(int b){
        return this.a + b;
    }
}
