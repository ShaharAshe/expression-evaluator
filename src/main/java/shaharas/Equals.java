package shaharas;

import java.util.regex.Pattern;

/**
 * The Equals class represents the equality operator ("="), typically used for checking whether
 * two values are equal. This class extends from the BaseBinaryOperators class and is designed
 * to work with an expression where the equality operator is involved.
 *
 * However, unlike other operators, the Equals operator does not perform any calculation or
 * assignment, and attempting to use it will throw an exception. It is typically used as a placeholder
 * for equality in certain syntaxes or parsing operations.
 */
public class Equals extends BaseBinaryOperators {
    /**
     * Default constructor for the Equals class. Initializes the operator with a default value of 0
     * and sets the corresponding regex, symbol, and priority for the equality operator.
     */
    public Equals() {
        super(0, Pattern.compile(PatternsUtils.EQL), Utilities.EQUALS, Utilities.NONE_PRIORITY);
    }

    /**
     * Copy constructor for the Equals class. This constructor creates a new Equals operator with the
     * same properties as the provided Equals object.
     *
     * @param a The Equals object to copy.
     */
    public Equals(Equals a) {
        super(a);
    }

    /**
     * Clones the current Equals operator and returns a new instance with the same properties.
     *
     * @return A new Equals operator with the same values.
     */
    @Override
    public Operators clone() {
        return new Equals(this);
    }

    /**
     * Sets the value for the operator. However, setting the value for the Equals operator is not supported.
     *
     * @param a The value to set for the operator.
     * @throws UnsupportedOperationException Always thrown, as setting a value for Equals is invalid.
     */
    @Override
    public Operators setA(int a) {
        throw new UnsupportedOperationException("Invalid operation");
    }

    /**
     * Performs the equality operation, but the Equals operator does not support any calculation.
     * Hence, it throws an UnsupportedOperationException if this method is called.
     *
     * @param variable The variable used in the operation (not utilized in this method).
     * @param args The operands for the equality. No calculation is performed for Equals.
     * @throws UnsupportedOperationException Always thrown, as Equals does not support calculations.
     */
    @Override
    public int calculate(String variable, int... args) {
        throw new UnsupportedOperationException("Invalid operation");
    }
}
