import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
/**
 * <p>Greedy class for solution calculator to weight composition problem.
 * This class provides an implementation of a constructor using a family
 * of weights.
 *
 * Implement both the instance and the static version of the
 * <code>calculateSolution</code> method. The instance method is specified by
 * the abstract method in this class, and the static method should have the
 * following signature:</p>
 *
 * <pre>public Collection&lt;Weight&gt; calculateSolution(
 *                  WeightFamily family, Weight desiredTotalWeight)</pre>
 *
 * @author CS 390K Section 001
 * @version $Id: BalanceWeightSystem.java 446 2016-11-17 17:15:07Z joe $
 */
public class GreedyBalanceWeightSystem extends BalanceWeightSystem {
    /** the reversed order of the weight family. */
    private ArrayList<Weight> reversed;

    /**
     * Create a new balance weight system with the given family of weights.
     *
     * @param family the family of weights with which to calculate a solution
     */
    public GreedyBalanceWeightSystem(final WeightFamily family) {
        super(family);
        WeightFamily orignal = family;
        Iterator<Weight> iter = orignal.iterator();
        ArrayList<Weight> straight = new ArrayList<Weight>();

        while (iter.hasNext()) {
            straight.add(iter.next());
        }
        Collections.reverse(straight);
        reversed = straight;
    }

    /**
     * Return the family of weights associated with this system.
     *
     * @return the family of weights associated with this system
     */
    public WeightFamily getFamily() {
        return super.getFamily();
    }

    /**
     * Given a desired total weight, calculate and return a minimum-sized
     * collection of weights from this object's weight family such that the
     * sum of the weights of the solution is the given desired total weight.
     *
     * @param desiredTotalWeight the desired total weight of the solution
     * @return a minimum-sized collection of weights whose sum is the given
     *         desired total weight
     */
    public Collection<Weight> calculateSolution(
            final Weight desiredTotalWeight) {

        Collection<Weight> solution = new ArrayList<Weight>();

        int total = desiredTotalWeight.getValue();

        Iterator<Weight> iter = reversed.iterator();
        int currentWeight = iter.next().getValue();


        while (total >= 0) {

//            System.out.println(reversed.get(0).getValue() + " weight");
//            System.out.println(total + " total\n");

            if (total > currentWeight) {

                total -= currentWeight;

                solution.add(new Weight(currentWeight));

            } else if (total == currentWeight) {

                solution.add(new Weight(currentWeight));

                return solution;

            } else {

                currentWeight = iter.next().getValue();
            }

        }
        return solution;
    }

    /**
     * Given a desired total weight and WeightFamily, calculate and
     * return a minimum-sized collection of weights from this object's
     * weight family such that the sum of the weights of the solution is
     * the given desired total weight.
     *
     * @param gwf the greedy family of weights
     * @param desiredTotalWeight the desired total weight of the solution
     * @return a minimum-sized collection of weights whose sum is the given
     *         desired total weight
     */
    public static Collection<Weight> calculateSolution(
            final WeightFamily gwf,
            final Weight desiredTotalWeight) {
        GreedyBalanceWeightSystem gbws = new GreedyBalanceWeightSystem(gwf);

        return gbws.calculateSolution(desiredTotalWeight);
    }
}
