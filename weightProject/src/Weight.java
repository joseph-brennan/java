/**
 * Represents a weight in the weight composition problem.
 *
 * @author CS 390K Section 001
 * @version $Id: Weight.java 446 2016-11-17 17:15:07Z joe $
 */
public class Weight implements Comparable<Weight> {
    /** internal representation of weight. */
    private int value;

    /** Default return value for boolean methods. */
    private static final boolean DEFAULT_RETURN_BOOLEAN = false;

    /** Default return value for int methods. */
    private static final int DEFAULT_RETURN_INT = -42;

    // Default return value for object methods is null.

    /**
     * Constructs a new weight with the given value.
     * @param value the value of this weight
     * @throws IllegalArgumentException if the value is negative or zero
     */
    public Weight(final int value) throws IllegalArgumentException {
        if (value <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.value = value;
        }
    }

    /**
     * Returns the value associated with this weight.
     * @return the value associated with this weight
     */
    public int getValue() {
        int temp = this.value;
        return temp;
    }

    /**
     * Predicate that verifies whether or not some other object is a weight
     * object with the same value as this one.
     * @param o the object with which to compare
     * @return true if and only if both objects possess the same value
     * @see #hashCode()
     */
    @Override
    public boolean equals(final Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        } else {
            Weight weight = (Weight) o;

            return this.getValue() == weight.getValue();
        }
    }

    /**
     * Returns a hash code value for this weight.
     * @return a hash code value for this weight
     * @see #equals(Object o)
     */
    @Override
    public int hashCode() {
        return this.getValue();
    }

    /**
     * <p>Compares this weight with the parameter for order. Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>Ensures that <code>sgn(x.compareTo(y) == -sgn(y.compareTo(x))</code>
     * for all <code>x</code> and <code>y</code>. (This implies that
     * <code>x.compareTo(y)</code> must throw an exception if and only if
     * <code>y.compareTo(x)</code> throws an exception.)</p>
     *
     * <p>The relation in transitive:
     * <code>(x.compareTo(y)>0 && y.compareTo(z)>0)</code> implies
     * <code>x.compareTo(z)>0</code>.</p>
     *
     * <p>Ensures that <code>x.compareTo(y)==0</code> implies that
     * <code>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</code>, for all
     * <code>z</code>.</p>
     *
     * <p>The natural ordering is consistent with
     * {@link #equals equals}, that is,
     * <code>(x.compareTo(y)==0) == (x.equals(y))</code>.</p>
     *
     * <p>In the foregoing description, the notation
     * <code>sgn</code>(<i>expression</i>) designated the mathematical
     * <i>signum</i> function, which is defined to return
     * one of <code>1</code>, <code>0</code>, or <code>-1</code> according to
     * whether the value of expression is negative, zero, or positive.
     * @param other the object to be compared
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.</p>
     */
    @Override
    public int compareTo(final Weight other) {
        if (other != null) {
            return this.getValue() - other.getValue();
        } else {
            return this.getValue();
        }
    }

    /**
     * Renders this weight as a string.
     * Rendering must include the value of this weight
     * in a human-readable format.
     * @return the rendering of this weight as a string
     */
    @Override
    public String toString() {
        return "" + this.getValue();
    }
}
