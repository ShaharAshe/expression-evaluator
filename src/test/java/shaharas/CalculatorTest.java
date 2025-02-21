package shaharas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    void testAdd() {
        // Add(1).calculate(2) -> 1 + 2
        assertEquals(3, new Add(1).calculate(2), " 1 + 2 should be 3");
        System.out.println("- testAdd passed");
    }

    @Test
    void testSub() {
        // Sub(1).calculate(2) -> 1 - 2
        assertEquals(-1, new Sub(1).calculate(2), " 1 - 2 should be -1");
        System.out.println("- testSub passed");
    }

    @Test
    void testMul() {
        // Mul(1).calculate(2) -> 1 * 2
        assertEquals(2, new Mul(1).calculate(2), " 1 * 2 should be 2");
        System.out.println("- testMul passed");
    }

    @Test
    void testDiv() {
        // Div(1).calculate(2) -> 4 / 2
        assertEquals(2, new Div(4).calculate(2), " 4 / 2 should be 2");
        System.out.println("- testDiv passed");
    }

    @Test
    void testDivByZero() {
        /* Save the exception */
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            // Div(1).calculate(0) -> 1 / 0
            new Div(1).calculate(0);
        });

        /* Check if the exception message is correct */
        assertEquals("Cannot divide by zero.", exception.getMessage(), "Exception message should be 'Cannot divide by zero.'");
        System.out.println("- testDivByZero passed");
    }

    /* TODO: Add more test cases */
}
