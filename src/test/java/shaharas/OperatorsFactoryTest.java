package shaharas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OperatorsFactoryTest {

    private OperatorsFactory operatorsFactory;

    @BeforeEach
    void setUp() {
        HashMap<String, VariableEXP> variables = new HashMap<>();
        variables.put("x", new VariableEXP("x", 5));
        operatorsFactory = new OperatorsFactory(variables);
    }

    @Test
    void testFindOperator() {
        String expression = "+";
        OperatorInfo operatorInfo = operatorsFactory.findOperator(expression);
        assertNotNull(operatorInfo);
        assertEquals(Utilities.PLUS, operatorInfo.getSymbol());
    }

    @Test
    void testFindOperatorNotFound() {
        String expression = "&";
        OperatorInfo operatorInfo = operatorsFactory.findOperator(expression);
        assertNull(operatorInfo);
    }
}

