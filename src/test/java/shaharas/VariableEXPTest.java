package shaharas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The VariableEXPTest class is designed to test the functionality of the VariableEXP class.
 * This class contains tests for various methods of VariableEXP, including the constructor, setter and getter methods,
 * handling of different input values (including edge cases), and validation of input values.
 */
class VariableEXPTest {
    /**
     * Test case to verify the correct initialization of a VariableEXP object.
     * It checks that the constructor correctly assigns the name and value.
     */
    @Test
    void testConstructor() {
        VariableEXP var = new VariableEXP("x", 10);
        assertEquals("x", var.getName());
        assertEquals(10, var.getValue());
    }

    /**
     * Test case to verify that the setValue method correctly updates the value of the variable.
     */
    @Test
    void testSetValue() {
        VariableEXP var = new VariableEXP("y", 5);
        var.setValue(15);
        assertEquals(15, var.getValue());
    }

    /**
     * Test case to verify the correct retrieval of the variable name.
     */
    @Test
    void testGetName() {
        VariableEXP var = new VariableEXP("z", 20);
        assertEquals("z", var.getName());
    }

    /**
     * Test case to verify the creation of a VariableEXP object using a StringBuilder for the name.
     * The default value should be 0 when initialized with a StringBuilder.
     */
    @Test
    public void testVariableCreation() {
        VariableEXP var = new VariableEXP(new StringBuilder("a"));
        assertEquals(0, var.getValue(), "Initial value should be 0");
    }

    /**
     * Test case to verify setting a value for a VariableEXP object initialized with a StringBuilder.
     */
    @Test
    public void testSet2Value() {
        VariableEXP var = new VariableEXP(new StringBuilder("b"));
        var.setValue(10);
        assertEquals(10, var.getValue(), "Value should be set to 10");
    }

    /**
     * Test case to verify the correct retrieval of the variable name when initialized with a String.
     */
    @Test
    public void testGet2Name() {
        VariableEXP var = new VariableEXP("a", 10);
        assertEquals("a", var.getName(), "Name should be 'a'");
    }

    /**
     * Test case to verify that a negative value can be set correctly.
     */
    @Test
    void testSetValueNegative() {
        VariableEXP var = new VariableEXP("x", 5);
        var.setValue(-100);
        assertEquals(-100, var.getValue(), "Value should be -100");
    }

    /**
     * Test case to verify that the value can be set to zero correctly.
     */
    @Test
    void testSetValueZero() {
        VariableEXP var = new VariableEXP("x", 10);
        var.setValue(0);
        assertEquals(0, var.getValue(), "Value should be 0");
    }

    /**
     * Test case to verify that the value remains unchanged if it is set to the same value.
     */
    @Test
    void testSetValueSameValue() {
        VariableEXP var = new VariableEXP("y", 20);
        var.setValue(20);
        assertEquals(20, var.getValue(), "Value should remain the same");
    }

    /**
     * Test case to verify that a large number can be set as the variable's value.
     */
    @Test
    void testSetLargeValue() {
        VariableEXP var = new VariableEXP("z", 100000);
        var.setValue(1000000);
        assertEquals(1000000, var.getValue(), "Value should be 1000000");
    }

    /**
     * Test case to check the behavior when an empty string is passed as the variable name.
     * It should throw an IllegalArgumentException with the appropriate message.
     */
    @Test
    void testSetEmptyName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->  new VariableEXP("", 10));
        assertEquals("Variable name is not valid", exception.getMessage(), "Exception message should be 'Variable name is not valid'");
    }

    /**
     * Test case to verify that a long variable name (up to 1000 characters) is handled correctly.
     */
    @Test
    void testSetLongName() {
        String longName = "a".repeat(1000); // Generate a long name
        VariableEXP var = new VariableEXP(longName, 10);
        assertEquals(longName, var.getName(), "Name should be set correctly even for long strings");
    }

    /**
     * Test case to check the behavior when an invalid name (non-alphabetic starting character) is provided.
     * It should throw an IllegalArgumentException with the appropriate message.
     */
    @Test
    void testInvalidName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new VariableEXP("1invalid", 10));
        assertEquals("Variable name is not valid", exception.getMessage(), "Exception message should be 'Variable name is not valid'");
    }
}

