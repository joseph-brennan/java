import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
/**
 * Test the recursive system.
 * @author Joey Brennan
 *
 */
public class RecursiveBalanceWeightSystemTest {
    /** private variables for testing. */
    private Collection<Weight> weights = new ArrayList<Weight>();
    private WeightFamily wf1;
    private RecursiveBalanceWeightSystem rbws1;
    private Weight totalWt1;

    /**
     * Tests the getFamily method.
     */
    @Test
    public void testGetFamily() {

        weights.add(new Weight(1));
        weights.add(new Weight(2));
        weights.add(new Weight(3));
        weights.add(new Weight(4));

        wf1 = new WeightFamily(weights);
        rbws1 = new RecursiveBalanceWeightSystem(wf1);

        assertEquals(wf1, rbws1.getFamily());

    }

    /**
     * Simple solution test.
     */
    @Test
    public void testSimpleCalculateSolution() {
        Collection<Weight> result = new ArrayList<Weight>();
        weights.add(new Weight(1));
        weights.add(new Weight(2));
        weights.add(new Weight(3));
        weights.add(new Weight(4));

        totalWt1 = new Weight(4);

        result.add(new Weight(4));

        wf1 = new WeightFamily(weights);
        rbws1 = new RecursiveBalanceWeightSystem(wf1);
//        System.out.println(result.toString() + " result");
//        System.out.println(wf1.toString() + " weightFamily");

        assertEquals(result.size(), rbws1.calculateSolution(totalWt1).size());
        assertEquals(result, rbws1.calculateSolution(totalWt1));
        assertEquals(result.size(),
                RecursiveBalanceWeightSystem.calculateSolution(wf1, totalWt1).size());
        assertEquals(result,
                RecursiveBalanceWeightSystem.calculateSolution(wf1, totalWt1));
    }

    /**
     * Prove recursive provides a minimum.
     */
    @Test
    public void testRecursiveCalculationSolution() {
        Collection<Weight> result = new ArrayList<Weight>();
        weights.add(new Weight(1));
        weights.add(new Weight(8));
        weights.add(new Weight(10));

        totalWt1 = new Weight(16);

        result.add(new Weight(8));
        result.add(new Weight(8));

        wf1 = new WeightFamily(weights);
        rbws1 = new RecursiveBalanceWeightSystem(wf1);
//        System.out.println(result.toString());
//        System.out.println(wf1.toString());

        assertEquals(result.size(), rbws1.calculateSolution(totalWt1).size());
        assertEquals(result, rbws1.calculateSolution(totalWt1));
        assertEquals(result.size(),
                RecursiveBalanceWeightSystem.calculateSolution(
                        wf1, totalWt1).size());
        assertEquals(result,
                RecursiveBalanceWeightSystem.calculateSolution(wf1, totalWt1));
    }

    /**
     * test larger case.
     */
    @Test
    public void testLargeRecursiveCalculationSolution() {
        Collection<Weight> result = new ArrayList<Weight>();
        for (int i = 1; i < 13; i++) {
            weights.add(new Weight(i));
        }

        totalWt1 = new Weight(23);

        result.add(new Weight(11));
        result.add(new Weight(12));

        wf1 = new WeightFamily(weights);
        rbws1 = new RecursiveBalanceWeightSystem(wf1);
//        System.out.println(result.toString());
//        System.out.println(wf1.toString());

        assertEquals(result.size(), rbws1.calculateSolution(totalWt1).size());
        assertEquals(result, rbws1.calculateSolution(totalWt1));
        assertEquals(result.size(),
                RecursiveBalanceWeightSystem.calculateSolution(
                        wf1, totalWt1).size());
        assertEquals(result,
                RecursiveBalanceWeightSystem.calculateSolution(wf1, totalWt1));
    }
}
