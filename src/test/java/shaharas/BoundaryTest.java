package shaharas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The BoundaryTest class contains test cases to verify the boundary conditions
 * and edge cases for mathematical operations such as addition and division.
 * It uses JUnit 5 for testing and includes tests for overflow, underflow,
 * and division by zero scenarios.
 */
public class BoundaryTest {
    /**
     * Test case to check addition with the maximum integer value.
     * This test verifies if adding 1 to the maximum integer value correctly causes an overflow.
     */
    @Test
    public void testMaxValueAddition() {
        Add add = new Add(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE + 1, add.calculate("x", 1), "Adding 1 to MAX_VALUE should overflow");
    }

    /**
     * Test case to check addition with the minimum integer value.
     * This test verifies if adding -1 to the minimum integer value correctly causes an underflow.
     */
    @Test
    public void testMinValueAddition() {
        Add add = new Add(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE - 1, add.calculate("x", -1), "Adding -1 to MIN_VALUE should underflow");
    }

    /**
     * Test case to check division by zero.
     * This test verifies that the system throws an ArithmeticException when attempting to divide by zero.
     */
    @Test
    public void testZeroDivision() {
        Div div = new Div(10);
        assertThrows(ArithmeticException.class, () -> div.calculate("x", 0), "Should throw exception for division by zero");
    }
}

