package shaharas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The CalculatorTest class contains test cases for verifying the functionality
 * of basic arithmetic operations such as addition, subtraction, multiplication, and division.
 * It uses JUnit 5 for testing and includes tests for normal operations and error cases like division by zero.
 */
public class CalculatorTest {
    /**
     * Test case to verify the addition operation.
     * It tests if adding 1 and 2 correctly returns 3.
     */
    @Test
    void testAdd() {
        // Add(1).calculate(2) -> 1 + 2
        assertEquals(3, new Add(1).calculate("",2), " 1 + 2 should be 3");
    }

    /**
     * Test case to verify the subtraction operation.
     * It tests if subtracting 2 from 1 correctly returns -1.
     */
    @Test
    void testSub() {
        // Sub(1).calculate(2) -> 1 - 2
        assertEquals(-1, new Sub(1).calculate("",2), " 1 - 2 should be -1");
    }

    /**
     * Test case to verify the multiplication operation.
     * It tests if multiplying 1 and 2 correctly returns 2.
     */
    @Test
    void testMul() {
        // Mul(1).calculate(2) -> 1 * 2
        assertEquals(2, new Mul(1).calculate("",2), " 1 * 2 should be 2");
    }

    /**
     * Test case to verify the division operation.
     * It tests if dividing 4 by 2 correctly returns 2.
     */
    @Test
    void testDiv() {
        // Div(1).calculate(2) -> 4 / 2
        assertEquals(2, new Div(4).calculate("",2), " 4 / 2 should be 2");
    }

    /**
     * Test case to verify that division by zero throws an exception.
     * It checks if dividing by zero correctly throws an ArithmeticException with the expected message.
     */
    @Test
    void testDivByZero() {
        /* Save the exception */
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> new Div(1).calculate("",0));

        /* Check if the exception message is correct */
        assertEquals("Cannot divide by zero.", exception.getMessage(), "Exception message should be 'Cannot divide by zero.'");
    }
}