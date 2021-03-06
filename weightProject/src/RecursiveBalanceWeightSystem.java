import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
/**
 * <p>Recursive class for solution calculator to weight composition problem.
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
public class RecursiveBalanceWeightSystem extends BalanceWeightSystem {
    /** the reversed order of the weight family. */
    private ArrayList<Weight> reversed;

    /**
     * Create a new balance weight system with the given family of weights.
     *
     * @param family the family of weights with which to calculate a solution
     */
    public RecursiveBalanceWeightSystem(final WeightFamily family) {
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

        ArrayList<Weight> solution = getCollection(
                desiredTotalWeight.getValue());

        Collections.sort(solution);

        return solution;
    }

    /**
     * Given a desired total weight and a WeightFamily, calculate and
     * return a minimum-sized collection of weights from this object's
     * weight family such that the sum of the weights of the solution
     * is the given desired total weight.
     *
     * @param rwf the family of weights.
     * @param desiredTotalWeight the desired total weight of the solution
     * @return a minimum-sized collection of weights whose sum is the given
     *         desired total weight
     */
    public static Collection<Weight> calculateSolution(
            final WeightFamily rwf,
            final Weight desiredTotalWeight) {
        RecursiveBalanceWeightSystem rbws =
                new RecursiveBalanceWeightSystem(rwf);

        return rbws.calculateSolution(desiredTotalWeight);
    }

    /**
     * recursively solves for a minimum solution.
     * @param total current total weight value
     * @return a ArrayList of weights
     */
    private ArrayList<Weight> getCollection(
            final int total) {
        ArrayList<ArrayList<Weight>> subSolution =
                new ArrayList<ArrayList<Weight>>();

        ArrayList<Weight> solution = new ArrayList<Weight>();

        if (total == 0) {
            return solution;

        } else {

            for (Weight w : reversed) {
                if (w.getValue() <= total) {
                    ArrayList<Weight> sub = new ArrayList<Weight>();

                    sub.add(w);

                    sub.addAll(getCollection(total - w.getValue()));

                    subSolution.add(sub);
                }
            }

            ArrayList<Weight> minSub = subSolution.get(0);

            for (ArrayList<Weight> s : subSolution) {
                if (s.size() < minSub.size() && s.size() > 0) {
                    int testResult = 0;

                    Iterator<Weight> iter = s.iterator();

                    while (iter.hasNext()) {
                        testResult += iter.next().getValue();
                    }

                    if (testResult == total) {
                        minSub = s;
                    }
                }
            }
            solution = minSub;
        }
        return solution;
    }
}
