import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;
/**
 * Tests the weight family and its methods.
 *
 * @author Joey Brennan
 *
 */
public class WeightFamilyTest {
    /** instances to be used thought the tests. */
    private WeightFamily wf1 = new WeightFamily();
    private WeightFamily wf2 = new WeightFamily();

    /**
     * tests weightFamily was created.
     */
    @Test
    public void testWeightFamily() {
        Collection<Weight> weights = new ArrayList<Weight>();

        weights.add(new Weight(1));

        WeightFamily wf4 = new WeightFamily(weights);

        assertEquals(wf4.toString(), "[1]");
    }

    /**
     * tests that the null throws the exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testWeightFamilyCollectionOfWeightNull() {
        WeightFamily wt3 = new WeightFamily(null);
    }

    /**
     * tests that it takes a collection.
     */
    @Test
    public void testWeightFamilyCollectionOfWeight() {
        Collection<Weight> weights = new ArrayList<Weight>();
        Collection<Weight> weights2 = new ArrayList<Weight>();

        weights.add(new Weight(1));
        weights.add(new Weight(2));
        weights.add(new Weight(3));

        weights2.add(new Weight(2));
        weights2.add(new Weight(3));

        WeightFamily wf4 = new WeightFamily(weights);
        WeightFamily wf5 = new WeightFamily(weights2);

        assertEquals("[1, 2, 3]", wf4.toString());
        assertEquals(wf4.toString(), wf5.toString());
    }

    /**
     * tests that getWeight works.
     */
    @Test
    public void testGetWeights() {
        Collection<Weight> weights = new TreeSet<Weight>();

        weights.add(new Weight(1));
        weights.add(new Weight(2));
        weights.add(new Weight(3));

        WeightFamily wt3 = new WeightFamily(weights);

        assertEquals(weights, wt3.getWeights());
    }

    /**
     * Tests the size.
     */
    @Test
    public void testSize() {
        assertEquals(1, wf1.size());
    }

    /**
     * tests the Iterator.
     */
    @Test
    public void testIterator() {
        Collection<Weight> weights = new ArrayList<Weight>();

        weights.add(new Weight(1));
        weights.add(new Weight(2));
        weights.add(new Weight(3));

        WeightFamily wt3 = new WeightFamily(weights);

        Iterator<Weight> wI = wt3.iterator();

        String iter = "";
        while (wI.hasNext()) {
            iter += wI.next().getValue();
            iter += ", ";
        }

        assertEquals("1, 2, 3, ", iter);
    }

    /**
     * Tests toString.
     */
    @Test
    public void testToString() {
        Collection<Weight> weights = new ArrayList<Weight>();

        weights.add(new Weight(1));
        weights.add(new Weight(2));
        weights.add(new Weight(3));

        WeightFamily wt3 = new WeightFamily(weights);

        assertEquals("[1, 2, 3]", wt3.toString());
    }

}
