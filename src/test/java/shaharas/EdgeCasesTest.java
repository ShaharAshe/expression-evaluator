package shaharas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The EdgeCasesTest class contains test cases for verifying the behavior of arithmetic operations in edge cases.
 * It tests the handling of special scenarios such as division by zero, negative values, and large values (integer overflow).
 * These tests ensure that the calculator behaves correctly under non-typical conditions.
 */
public class EdgeCasesTest {
    /**
     * Test case to verify that dividing by zero correctly throws an ArithmeticException.
     * This simulates an edge case where the divisor is zero.
     */
    @Test
    public void testDivisionByZero() {
        Div div = new Div(10);
        assertThrows(ArithmeticException.class, () -> div.calculate("x", 0), "Should throw ArithmeticException for division by zero");
    }

    /**
     * Test case to verify the behavior of addition when one of the operands is negative.
     * This ensures that negative values are handled correctly during calculations.
     */
    @Test
    public void testNegativeValues() {
        Add add = new Add(-10);
        assertEquals(-5, add.calculate("x", 5), "-10 + 5 should be -5");
    }

    /**
     * Test case to verify the behavior of the calculator when working with large integer values.
     * This tests for overflow by adding a large integer value to a number.
     */
    @Test
    public void testLargeValue() {
        Add add = new Add(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE + 10, add.calculate("x", 10), "Max int value should handle overflow");
    }
}

