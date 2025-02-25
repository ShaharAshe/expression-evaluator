package shaharas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VariableEXPTest {

    @Test
    void testConstructor() {
        VariableEXP var = new VariableEXP("x", 10);
        assertEquals("x", var.getName());
        assertEquals(10, var.getValue());
    }

    @Test
    void testSetValue() {
        VariableEXP var = new VariableEXP("y", 5);
        var.setValue(15);
        assertEquals(15, var.getValue());
    }

    @Test
    void testGetName() {
        VariableEXP var = new VariableEXP("z", 20);
        assertEquals("z", var.getName());
    }

    @Test
    public void testVariableCreation() {
        VariableEXP var = new VariableEXP(new StringBuilder("a"));
        assertEquals(0, var.getValue(), "Initial value should be 0");
    }

    @Test
    public void testSet2Value() {
        VariableEXP var = new VariableEXP(new StringBuilder("b"));
        var.setValue(10);
        assertEquals(10, var.getValue(), "Value should be set to 10");
    }

    @Test
    public void testGet2Name() {
        VariableEXP var = new VariableEXP("a", 10);
        assertEquals("a", var.getName(), "Name should be 'a'");
    }
    // Test with negative value
    @Test
    void testSetValueNegative() {
        VariableEXP var = new VariableEXP("x", 5);
        var.setValue(-100);
        assertEquals(-100, var.getValue(), "Value should be -100");
    }

    // Test with zero value
    @Test
    void testSetValueZero() {
        VariableEXP var = new VariableEXP("x", 10);
        var.setValue(0);
        assertEquals(0, var.getValue(), "Value should be 0");
    }

    // Test if the value does not change if set to the same value
    @Test
    void testSetValueSameValue() {
        VariableEXP var = new VariableEXP("y", 20);
        var.setValue(20);
        assertEquals(20, var.getValue(), "Value should remain the same");
    }

    // Test with a large number
    @Test
    void testSetLargeValue() {
        VariableEXP var = new VariableEXP("z", 100000);
        var.setValue(1000000);
        assertEquals(1000000, var.getValue(), "Value should be 1000000");
    }

    // Test with an edge case string
    @Test
    void testSetEmptyName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new VariableEXP("", 10);
        });

        /* Check if the exception message is correct */
        assertEquals("Variable name is not valid", exception.getMessage(), "Exception message should be 'Variable name is not valid'");
    }

    @Test
    void testSetLongName() {
        String longName = "a".repeat(1000); // Generate a long name
        VariableEXP var = new VariableEXP(longName, 10);
        assertEquals(longName, var.getName(), "Name should be set correctly even for long strings");
    }

    // Test with invalid name (non-alphabetic start)
    @Test
    void testInvalidName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new VariableEXP("1invalid", 10);
        });

        /* Check if the exception message is correct */
        assertEquals("Variable name is not valid", exception.getMessage(), "Exception message should be 'Variable name is not valid'");
    }
}

