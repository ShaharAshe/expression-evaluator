package shaharas;

public class VariableEXP {
    private final String name;
    private int value;

    public VariableEXP(StringBuilder name) {
        this.name = String.valueOf(name);
        this.value = 0;
    }
    public VariableEXP(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public int setValue(int value) {
        this.value = value;
        return this.value;
    }
}
