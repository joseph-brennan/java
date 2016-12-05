import static org.junit.Assert.*;

import org.junit.Test;
/**
 * tests the weight class.
 * @author Joey Brennan
 *
 */
public class WeightTest {
    /** instances to be used thought the tests. */
    private Weight wt1 = new Weight(2);
    private Weight wt2 = new Weight(2);
    private Weight wt3 = new Weight(1);
    private Weight wt4 = new Weight(10);

    /**
     * testing the hashCode.
     */
    @Test
    public void testHashCode() {
        assert (wt1.hashCode() == wt2.hashCode());
    }

    /**
     * tests weight throw exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testWeight() {
        Weight wt0 = new Weight(0);
        Weight wtn = new Weight(-1);
    }

    /**
     * testing the get value.
     */
    @Test
    public void testGetValue() {
        assertEquals(wt1.getValue(), wt2.getValue());
    }

    /**
     * tests the override Equals.
     */
    @Test
    public void testEqualsObject() {
        assert (wt1.equals(wt2) == wt2.equals(wt1));
    }

    /**
     * tests the override compareTo.
     */
    @Test
    public void testCompareTo() {
        assert (wt1.compareTo(wt2) == wt2.compareTo(wt1));
    }

    /**
     * tests the override toString.
     */
    @Test
    public void testToString() {
        assertTrue(wt3.toString().contains("1"));
        assertTrue(wt4.toString().contains("10"));
    }

}
