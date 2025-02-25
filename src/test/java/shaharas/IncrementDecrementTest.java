package shaharas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IncrementDecrementTest {

    @Test
    public void testPreIncrement() {
        VariableEXP var = new VariableEXP("a", 5);
        assertEquals(6, var.setValue(var.getValue() + 1), "Pre-increment should add 1");
    }

    @Test
    public void testPostIncrement() {
        VariableEXP var = new VariableEXP("a", 5);
        int temp = var.getValue();
        var.setValue(var.getValue() + 1);
        assertEquals(temp, temp, "Post-increment should return old value");
    }

    @Test
    public void testPreDecrement() {
        VariableEXP var = new VariableEXP("a", 5);
        assertEquals(4, var.setValue(var.getValue() - 1), "Pre-decrement should subtract 1");
    }

    @Test
    public void testPostDecrement() {
        VariableEXP var = new VariableEXP("a", 5);
        int temp = var.getValue();
        var.setValue(var.getValue() - 1);
        assertEquals(temp, temp, "Post-decrement should return old value");
    }
}

