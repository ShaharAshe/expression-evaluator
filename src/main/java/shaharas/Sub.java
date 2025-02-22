package shaharas;

public class Sub implements Operators {
    private int a;

    public Sub(){
        this.a = 0;
    }
    public Sub(int a){
        this.a = a;
    }

    @Override
    public Operators setA(int a){
        this.a = a;
        return this;
    }

    @Override
    public int calculate(int b){
        return this.a - b;
    }
}
