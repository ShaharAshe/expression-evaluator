package shaharas;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

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
        HashMap<String, VariableEXP> variables = new HashMap<>();
        VariableEXP var = new VariableEXP("a", 5);
        variables.put("a", var);
        int temp = var.getValue()+1;
        assertEquals(temp, new AddOneLeft(variables).calculate("a"), "Post-increment should return old value");
    }

    /**
     * Test case to verify the behavior of post-increment.
     * Post-increment should return the old value of the variable before incrementing it.
     */
    @Test
    public void testPostIncrement() {
        HashMap<String, VariableEXP> variables = new HashMap<>();
        VariableEXP var = new VariableEXP("a", 5);
        variables.put("a", var);
        int temp = var.getValue();
        assertEquals(temp, new AddOneRight(variables).calculate("a"), "Post-increment should return old value");
    }

    /**
     * Test case to verify the behavior of pre-decrement.
     * Pre-decrement should decrease the variable's value by 1 and return the new value.
     */
    @Test
    public void testPreDecrement() {
        HashMap<String, VariableEXP> variables = new HashMap<>();
        VariableEXP var = new VariableEXP("a", 5);
        variables.put("a", var);
        int temp = var.getValue()-1;
        assertEquals(temp, new SubOneLeft(variables).calculate("a"), "Post-increment should return old value");
    }

    /**
     * Test case to verify the behavior of post-decrement.
     * Post-decrement should return the old value of the variable before decrementing it.
     */
    @Test
    public void testPostDecrement() {
        HashMap<String, VariableEXP> variables = new HashMap<>();
        VariableEXP var = new VariableEXP("a", 5);
        variables.put("a", var);
        int temp = var.getValue();
        assertEquals(temp, new SubOneRight(variables).calculate("a"), "Post-increment should return old value");
    }
}

