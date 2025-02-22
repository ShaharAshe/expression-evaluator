package shaharas;

public class VariableEXP {
    private final String name;
    private int value;

    public VariableEXP(StringBuilder name) {
        this.name = String.valueOf(name);
        this.value = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
