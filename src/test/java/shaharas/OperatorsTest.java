package shaharas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The OperatorsTest class tests the calculation methods of the operators.
 * It ensures that the mathematical operators (addition, subtraction, multiplication, and division)
 * produce the correct results when performing calculations with operands.
 */
class OperatorsTest {
    /**
     * Test case to verify the calculation of addition.
     * It checks that adding 3 to 5 results in 8.
     */
    @Test
    void testAddCalculation() {
        Add addOperator = new Add(5);
        int result = addOperator.calculate("", 3);
        assertEquals(8, result);
    }

    /**
     * Test case to verify the calculation of subtraction.
     * It checks that subtracting 4 from 10 results in 6.
     */
    @Test
    void testSubCalculation() {
        Sub subOperator = new Sub(10);
        int result = subOperator.calculate("", 4);
        assertEquals(6, result);
    }

    /**
     * Test case to verify the calculation of multiplication.
     * It checks that multiplying 3 by 4 results in 12.
     */
    @Test
    void testMulCalculation() {
        Mul mulOperator = new Mul(3);
        int result = mulOperator.calculate("", 4);
        assertEquals(12, result);
    }

    /**
     * Test case to verify the calculation of division.
     * It checks that dividing 10 by 2 results in 5.
     */
    @Test
    void testDivCalculation() {
        Div divOperator = new Div(10);
        int result = divOperator.calculate("", 2);
        assertEquals(5, result);
    }

    /**
     * Test case for subtraction where the result is 5.
     * It checks that subtracting 5 from 10 results in 5.
     */
    @Test
    public void testSubtraction() {
        Sub sub = new Sub(10);
        assertEquals(5, sub.calculate("x", 5), "10 - 5 should be 5");
    }

    /**
     * Test case for addition where the result is 8.
     * It checks that adding 3 to 5 results in 8.
     */
    @Test
    public void testAddition() {
        Add add = new Add(5);
        assertEquals(8, add.calculate("x", 3), "5 + 3 should be 8");
    }

    /**
     * Test case for multiplication where the result is 9.
     * It checks that multiplying 3 by 3 results in 9.
     */
    @Test
    public void testMultiplication() {
        Mul mul = new Mul(3);
        assertEquals(9, mul.calculate("x", 3), "3 * 3 should be 9");
    }

    /**
     * Test case for division where the result is 3.
     * It checks that dividing 6 by 2 results in 3.
     */
    @Test
    public void testDivision() {
        Div div = new Div(6);
        assertEquals(3, div.calculate("x", 2), "6 / 2 should be 3");
    }
}

