import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
/**
 * Test the Greedy system.
 * @author Joey Brennan
 *
 */
public class GreedyBalanceWeightSystemTest {
    /** private variables for testing. */
    private Collection<Weight> weights = new ArrayList<Weight>();
    private WeightFamily wf1;
    private GreedyBalanceWeightSystem gbws1;
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
        gbws1 = new GreedyBalanceWeightSystem(wf1);

        assertEquals(wf1, gbws1.getFamily());

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
        gbws1 = new GreedyBalanceWeightSystem(wf1);
//        System.out.println(result.toString());
//        System.out.println(wf1.toString());

        assertEquals(result.size(), gbws1.calculateSolution(totalWt1).size());
        assertEquals(result, gbws1.calculateSolution(totalWt1));
        assertEquals(result.size(), GreedyBalanceWeightSystem.calculateSolution(
                wf1, totalWt1).size());
        assertEquals(result, GreedyBalanceWeightSystem.calculateSolution(
                wf1, totalWt1));
    }

    /**
     * Prove fail of greedy algorithm.
     */
    @Test
    public void testGreedCalculationSolutionExpectedFail() {
        Collection<Weight> result = new ArrayList<Weight>();
        weights.add(new Weight(1));
        weights.add(new Weight(8));
        weights.add(new Weight(10));

        totalWt1 = new Weight(16);

        result.add(new Weight(8));
        result.add(new Weight(8));

        wf1 = new WeightFamily(weights);
        gbws1 = new GreedyBalanceWeightSystem(wf1);
//        System.out.println(result.toString());
//        System.out.println(wf1.toString());

        System.out.println("This is supposed to fail");
        assertEquals(result.size(), gbws1.calculateSolution(totalWt1).size());
        assertEquals(result, gbws1.calculateSolution(totalWt1));
        assertEquals(result.size(), GreedyBalanceWeightSystem.calculateSolution(
                wf1, totalWt1).size());
        assertEquals(result, GreedyBalanceWeightSystem.calculateSolution(
                wf1, totalWt1));
    }

    /**
     * larger test.
     */
    @Test
    public void testLargeRecursiveCalculationSolution() {
        Collection<Weight> result = new ArrayList<Weight>();
        for (int i = 1; i < 13; i++) {
            weights.add(new Weight(i));
        }

        totalWt1 = new Weight(23);

        result.add(new Weight(12));
        result.add(new Weight(11));

        wf1 = new WeightFamily(weights);
        gbws1 = new GreedyBalanceWeightSystem(wf1);
//        System.out.println(result.toString());
//        System.out.println(wf1.toString());
//        System.out.println(result.size());
//        System.out.println(gbws1.calculateSolution(totalWt1).size());

        assertEquals(result.size(), gbws1.calculateSolution(totalWt1).size());
        assertEquals(result, gbws1.calculateSolution(totalWt1));
        assertEquals(result.size(),
                GreedyBalanceWeightSystem.calculateSolution(
                        wf1, totalWt1).size());
        assertEquals(result,
                GreedyBalanceWeightSystem.calculateSolution(wf1, totalWt1));
    }
}
