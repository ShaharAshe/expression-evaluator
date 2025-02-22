package shaharas;

// new AddEQL(i).calculate(1) -> i += 1
public class AddEQL implements Operators {
    private int a;

    public AddEQL(){
        this.a = 0;
    }
    public AddEQL(int a){
        this.a = a;
    }

    @Override
    public Operators setA(int a){
        this.a = a;
        return this;
    }

    @Override
    public int calculate(int b){
        return new Add(this.a).calculate(b);
    }
}
