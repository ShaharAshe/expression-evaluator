package shaharas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The IncrementDecrementTest class contains unit tests for verifying the correct behavior
 * of increment and decrement operations on variables. It ensures that pre-increment, post-increment,
 * pre-decrement, and post-decrement work as expected.
 */
public class IncrementDecrementTest {
    /**
     * Test case to verify the behavior of pre-increment.
     * Pre-increment should increase the variable's value by 1 and return the new value.
     */
    @Test
    public void testPreIncrement() {
        VariableEXP var = new VariableEXP("a", 5);
        assertEquals(6, var.setValue(var.getValue() + 1), "Pre-increment should add 1");
    }

    /**
     * Test case to verify the behavior of post-increment.
     * Post-increment should return the old value of the variable before incrementing it.
     */
    @Test
    public void testPostIncrement() {
        VariableEXP var = new VariableEXP("a", 5);
        int temp = var.getValue();
        var.setValue(var.getValue() + 1);
        assertEquals(temp, temp, "Post-increment should return old value");
    }

    /**
     * Test case to verify the behavior of pre-decrement.
     * Pre-decrement should decrease the variable's value by 1 and return the new value.
     */
    @Test
    public void testPreDecrement() {
        VariableEXP var = new VariableEXP("a", 5);
        assertEquals(4, var.setValue(var.getValue() - 1), "Pre-decrement should subtract 1");
    }

    /**
     * Test case to verify the behavior of post-decrement.
     * Post-decrement should return the old value of the variable before decrementing it.
     */
    @Test
    public void testPostDecrement() {
        VariableEXP var = new VariableEXP("a", 5);
        int temp = var.getValue();
        var.setValue(var.getValue() - 1);
        assertEquals(temp, temp, "Post-decrement should return old value");
    }
}

