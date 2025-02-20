package shaharas;

// new AddEQL(i).calculate(1) -> i += 1
public class AddEQL implements Operators {
    private final int a;
    public AddEQL(int a){
        this.a = a;
    }

    @Override
    public int calculate(int b){
        return new Add(this.a).calculate(b);
    }
}
