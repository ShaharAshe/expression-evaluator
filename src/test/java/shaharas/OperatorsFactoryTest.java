package shaharas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The OperatorsFactoryTest class tests the functionality of the OperatorsFactory class.
 * Specifically, it tests whether the factory correctly finds operators based on input expressions,
 * and handles cases where no operator is found.
 */
class OperatorsFactoryTest {

    private OperatorsFactory operatorsFactory; // OperatorsFactory instance to test

    /**
     * Set up the test environment.
     * This method is executed before each test case.
     * Initializes the OperatorsFactory with a map of variables.
     */
    @BeforeEach
    void setUp() {
        HashMap<String, VariableEXP> variables = new HashMap<>();
        variables.put("x", new VariableEXP("x", 5));
        operatorsFactory = new OperatorsFactory(variables);
    }

    /**
     * Test case to verify the functionality of finding a valid operator.
     * It checks that the operator "+" is correctly identified by the factory.
     */
    @Test
    void testFindOperator() {
        String expression = "+";
        OperatorInfo operatorInfo = operatorsFactory.findOperator(expression);
        assertNotNull(operatorInfo);
        assertEquals(Utilities.PLUS, operatorInfo.getSymbol());
    }

    /**
     * Test case to verify that the factory handles invalid operators correctly.
     * It checks that an unknown operator returns null.
     */
    @Test
    void testFindOperatorNotFound() {
        String expression = "&";
        OperatorInfo operatorInfo = operatorsFactory.findOperator(expression);
        assertNull(operatorInfo);
    }
}

