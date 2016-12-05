// BinaryTree<T>Test.java
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * Tests for BinaryTree<T>.
 * @author  Joey Brennan
 * @version $Revision: 7 $ ($LastChangedDate: 2016-08-17 17:57:55 -0600 (Wed, 17 Aug 2016) $ by $Author: jody $)
 */
public class BinaryTreeTest<T> {

    /** Number of nodes in standard test tree. */
    private static final int NUM_NODES_TEST_TREE = 9;
    /** Number of leaves in standard test tree. */
    private static final int NUM_LEAVES_TEST_TREE = 4;
    /** Height of standard test tree. */
    private static final int HEIGHT_TEST_TREE = 3;
    /** Number of nodes in small test tree. */
    private static final int NUM_NODES_SM_TREE = 3;
    /** Number of nodes in medium-sized test tree. */
    private static final int NUM_NODES_MED_TREE = 5;

    /** String of nodes in standard test tree. */
    private static final int NUM_NODES_TEST_STRING_TREE = 9;
    /** String of leaves in standard test tree. */
    private static final int NUM_LEAVES_TEST_STRING_TREE = 4;
    /** Height of standard test tree. */
    private static final int HEIGHT_TEST_STRING_TREE = 3;
    /** String of nodes in small test tree. */
    private static final int NUM_NODES_SM_STRING_TREE = 3;
    /** String of nodes in medium-sized test tree. */
    private static final int NUM_NODES_MED_STRING_TREE = 5;


    /** Root indicator. */
    private static final Number ROOT = new Integer(42);
    /** Left child indicator. */
    private static final Number LEFT = new Integer(21);
    /** Right child indicator. */
    private static final Number RIGHT = new Integer(63);
    /** Left-Left child indicator. */
    private static final Number LEFT_LEFT = new Integer(10);
    /** Left-Right child indicator. */
    private static final Number LEFT_RIGHT = new Integer(30);
    /** Right-Left child indicator. */
    private static final Number RIGHT_LEFT = new Integer(50);
    /** Right-Right child indicator. */
    private static final Number RIGHT_RIGHT = new Integer(70);
    /** Right-Left-Right child indicator. */
    private static final Number RIGHT_LEFT_RIGHT = new Integer(55);
    /** Right-Right-LEFT child indicator. */
    private static final Number RIGHT_RIGHT_LEFT = new Integer(66);

    /** Root indicator. */
    private static final String STRING_ROOT = new String("42");
    /** Left child indicator. */
    private static final String STRING_LEFT = new String("21");
    /** Right child indicator. */
    private static final String STRING_RIGHT = new String("63");
    /** Left-Left child indicator. */
    private static final String STRING_LEFT_LEFT = new String("10");
    /** Left-Right child indicator. */
    private static final String STRING_LEFT_RIGHT = new String("30");
    /** Right-Left child indicator. */
    private static final String STRING_RIGHT_LEFT = new String("50");
    /** Right-Right child indicator. */
    private static final String STRING_RIGHT_RIGHT = new String("70");
    /** Right-Left-Right child indicator. */
    private static final String STRING_RIGHT_LEFT_RIGHT = new String("55");
    /** Right-Right-LEFT child indicator. */
    private static final String STRING_RIGHT_RIGHT_LEFT = new String("66");

    /**
     * Generates a standard tree for testing.
     * @return testing tree
     */
    private BinaryTree<Number> generateStandardTestTree() {
        return new BinaryTree<Number>(
                    ROOT,
                    new BinaryTree<Number>(
                          LEFT,
                          new BinaryTree<Number>(LEFT_LEFT),
                          new BinaryTree<Number>(LEFT_RIGHT)),
                    new BinaryTree<Number>(
                          RIGHT,
                          new BinaryTree<Number>(
                                RIGHT_LEFT,
                                null,
                                new BinaryTree<Number>(
                                      RIGHT_LEFT_RIGHT)),
                                      new BinaryTree<Number>(RIGHT_RIGHT,
                                      new BinaryTree<Number>(RIGHT_RIGHT_LEFT),
                          null)));
    }

    // Lettered value constants.
    private static final Number A =  0;
    private static final Number B =  1;
    private static final Number C =  2;
    private static final Number D =  3;
    private static final Number E =  4;
    private static final Number F =  5;
    private static final Number G =  6;
    private static final Number H =  7;
    private static final Number I =  8;
    private static final Number J =  9;
    private static final Number K = 10;
    /**
     * Generates a binary search tree.
     * @return testing search tree
     */
    private BinaryTree<Number> generateSearchTree() {
        return new BinaryTree<Number>(
            F,
            new BinaryTree<Number>(
                D,
                new BinaryTree<Number>(
                    B,
                    new BinaryTree<Number>(A),
                    new BinaryTree<Number>(C)),
                new BinaryTree<Number>(E)),
            new BinaryTree<Number>(
                H,
                new BinaryTree<Number>(G),
                new BinaryTree<Number>(
                    I,
                    null,
                    new BinaryTree<Number>(
                        J,
                        null,
                        new BinaryTree<Number>(K)))));
    }

   /**
     * Generates a standard tree for testing.
     * @return testing tree
     */
    private BinaryTree<String> generateStandardStringTestTree() {
        return new BinaryTree<String>(
                    STRING_ROOT,
                    new BinaryTree<String>(
                          STRING_LEFT,
                          new BinaryTree<String>(STRING_LEFT_LEFT),
                          new BinaryTree<String>(STRING_LEFT_RIGHT)),
                    new BinaryTree<String>(
                          STRING_RIGHT,
                          new BinaryTree<String>(
                                STRING_RIGHT_LEFT,
                                null,
                                new BinaryTree<String>(
                                      STRING_RIGHT_LEFT_RIGHT)),
                                      new BinaryTree<String>(STRING_RIGHT_RIGHT,
                                      new BinaryTree<String>(STRING_RIGHT_RIGHT_LEFT),
                          null)));
    }

    // Lettered value constants.
    private static final String STRING_A =  "1";
    private static final String STRING_B =  "2";
    private static final String STRING_C =  "3";
    private static final String STRING_D =  "3";
    private static final String STRING_E =  "4";
    private static final String STRING_F =  "5";
    private static final String STRING_G =  "6";
    private static final String STRING_H =  "7";
    private static final String STRING_I =  "8";
    private static final String STRING_J =  "9";
    private static final String STRING_K = "10";
    /**
     * Generates a binary search tree.
     * @return testing search tree
     */
    private BinaryTree<String> generateStringSearchTree() {
        return new BinaryTree<String>(
            STRING_F,
            new BinaryTree<String>(
                STRING_D,
                new BinaryTree<String>(
                    STRING_B,
                    new BinaryTree<String>(STRING_A),
                    new BinaryTree<String>(STRING_C)),
                new BinaryTree<String>(STRING_E)),
            new BinaryTree<String>(
                STRING_H,
                new BinaryTree<String>(STRING_G),
                new BinaryTree<String>(
                    STRING_I,
                    null,
                    new BinaryTree<String>(
                        STRING_J,
                        null,
                        new BinaryTree<String>(STRING_K)))));
    }

    /**
     * Tests valid methods for empty tree.
     */
    @Test
    public void emptyTreeTest() {
        BinaryTree<Number> mtTree = new BinaryTree<Number>();
        assertEquals(true, mtTree.isEmpty());
        assertEquals(0, mtTree.numberOfNodes());
        assertEquals(-1, mtTree.height());
    }

    /**
    * Verifies exception for value accessor on empty tree.
    */
    @Test(expected = NullPointerException.class)
    public void emptyTreeGetValueException() {
        BinaryTree<Number> mtTree = new BinaryTree<Number>();
        Number x = mtTree.getValue();
    }

    /**
    * Verifies exception for left child accessor on empty tree.
    */
    @Test(expected = NullPointerException.class)
    public void emptyTreeGetLeftChildException() {
        BinaryTree<Number> mtTree = new BinaryTree<Number>();
        BinaryTree<Number> x = mtTree.getLeftChild();
    }

    /**
     * Tests valid methods for empty tree.
     */
    @Test
    public void emptyStringTreeTest() {
        BinaryTree<String> mtTree = new BinaryTree<String>();
        assertEquals(true, mtTree.isEmpty());
        assertEquals(0, mtTree.numberOfNodes());
        assertEquals(-1, mtTree.height());
    }

    /**
    * Verifies exception for value accessor on empty tree.
    */
    @Test(expected = NullPointerException.class)
    public void emptyTreeGetStringValueException() {
        BinaryTree<String> mtTree = new BinaryTree<String>();
        String x = mtTree.getValue();
    }

    /**
    * Verifies exception for right child accessor on empty tree.
    */
    @Test(expected = NullPointerException.class)
    public void emptyTreeGetRightChildException() {
        BinaryTree<Number> mtTree = new BinaryTree<Number>();
        BinaryTree<Number> x = mtTree.getRightChild();
    }

    /**
    * Verifies exception for leaf predicate on empty tree.
    */
    @Test(expected = NullPointerException.class)
    public void emptyTreeIsLeafException() {
        BinaryTree<Number> mtTree = new BinaryTree<Number>();
        boolean b = mtTree.isLeaf();
    }

    /** Default reject value. */
    private static final Number REJECT = new Byte((byte) 255);
    /**
    * Verifies exception for value mutator on empty tree.
    */
    @Test(expected = NullPointerException.class)
    public void emptyTreeSetValueException() {
        BinaryTree<Number> mtTree = new BinaryTree<Number>();
        mtTree.setValue(REJECT);
    }

    /** Default reject value. */
    private static final String STRING_REJECT = "";
    /**
    * Verifies exception for value mutator on empty tree.
    */
//    @Test(expected = NullPointerException.class)
//    public void emptyTreeSetValueStringException() {
//        BinaryTree<String> mtTree = new BinaryTree<String>();
//        mtTree.setValue(STRING_REJECT);
//    }

    /**
    * Verifies exception for left child mutator on empty tree.
    */
    @Test(expected = NullPointerException.class)
    public void emptyTreeSetLeftChildException() {
        BinaryTree<Number> mtTree = new BinaryTree<Number>();
        mtTree.setLeftChild(new BinaryTree<Number>());
    }

    /**
    * Verifies exception for right child mutator on empty tree.
    */
    @Test(expected = NullPointerException.class)
    public void emptyTreeSetRightChildException() {
        BinaryTree<Number> mtTree = new BinaryTree<Number>();
        mtTree.setRightChild(new BinaryTree<Number>());
    }

    /**
    * Verifies exception for numberOfLeaves accessor on empty tree.
    */
    @Test(expected = NullPointerException.class)
    public void emptyTreeNumberOfLeavesException() {
        BinaryTree<Number> mtTree = new BinaryTree<Number>();
        mtTree.numberOfLeaves();
    }

    /** Test value for new tree. */
    private static final Number NEW_VALUE = new Byte((byte) 102);
    /**
     * Tests for single-node tree.
     */
    @Test
    public void oneNodeTest() {
        BinaryTree<Number> root = new BinaryTree<Number>(ROOT);
        assertEquals(false, root.isEmpty());
        assertEquals(1, root.numberOfNodes());
        assertEquals(0, root.height());
        assertNotNull(root.getValue());
        assertEquals(ROOT, root.getValue());
        assertEquals(1, root.numberOfLeaves());
        assertNull(root.getLeftChild());
        assertNull(root.getRightChild());
        root.setValue(NEW_VALUE);
        assertEquals(NEW_VALUE, root.getValue());
    }

    /**
     * Tests for single-node tree using parameterized constructor.
     */
    @Test
    public void oneNodeSecondaryTest() {
        BinaryTree<Number> root = new BinaryTree<Number>(ROOT, null, null);
        assertEquals(false, root.isEmpty());
        assertEquals(1, root.numberOfNodes());
        assertEquals(0, root.height());
        assertNotNull(root.getValue());
        assertEquals(ROOT, root.getValue());
        assertEquals(1, root.numberOfLeaves());
        assertNull(root.getLeftChild());
        assertNull(root.getRightChild());
        root.setValue(NEW_VALUE);
        assertEquals(NEW_VALUE, root.getValue());
    }

    /**
     * Tests for multiple-node tree using parameterized constructor.
     */
    @Test
    public void multiNodeStringConstructionTest() {
        BinaryTree<String> root = generateStandardStringTestTree();
        assertFalse(root.isEmpty());
        assertEquals(NUM_NODES_TEST_STRING_TREE, root.numberOfNodes());
        assertEquals(NUM_LEAVES_TEST_STRING_TREE, root.numberOfLeaves());
        assertEquals(HEIGHT_TEST_STRING_TREE, root.height());
        assertEquals(STRING_ROOT, root.getValue());
        assertFalse(root.getLeftChild().isEmpty());
        assertFalse(root.getRightChild().isEmpty());
        assertFalse(root.getLeftChild().getLeftChild().isEmpty());
        assertFalse(root.getRightChild().getLeftChild().isEmpty());
        assertNull(root.getLeftChild().getLeftChild().getLeftChild());
        assertFalse(
            root.getRightChild().getLeftChild().getRightChild().isEmpty());
        assertNull(root.getRightChild().getLeftChild().getLeftChild());
        assertEquals(NUM_NODES_SM_STRING_TREE, root.getLeftChild().numberOfNodes());
        assertEquals(NUM_NODES_MED_STRING_TREE, root.getRightChild().numberOfNodes());
        assertEquals(1, root.getLeftChild().height());
        assertEquals(2, root.getRightChild().height());
        assertEquals(STRING_RIGHT_LEFT_RIGHT,
            root.getRightChild().getLeftChild().getRightChild().getValue());
        assertEquals(STRING_RIGHT_RIGHT_LEFT,
            root.getRightChild().getRightChild().getLeftChild().getValue());
    }
    
    /**
     * Tests for multiple-node tree using parameterized constructor.
     */
    @Test
    public void multiNodeConstructionTest() {
        BinaryTree<Number> root = generateStandardTestTree();
        assertFalse(root.isEmpty());
        assertEquals(NUM_NODES_TEST_TREE, root.numberOfNodes());
        assertEquals(NUM_LEAVES_TEST_TREE, root.numberOfLeaves());
        assertEquals(HEIGHT_TEST_TREE, root.height());
        assertEquals(ROOT, root.getValue());
        assertFalse(root.getLeftChild().isEmpty());
        assertFalse(root.getRightChild().isEmpty());
        assertFalse(root.getLeftChild().getLeftChild().isEmpty());
        assertFalse(root.getRightChild().getLeftChild().isEmpty());
        assertNull(root.getLeftChild().getLeftChild().getLeftChild());
        assertFalse(
            root.getRightChild().getLeftChild().getRightChild().isEmpty());
        assertNull(root.getRightChild().getLeftChild().getLeftChild());
        assertEquals(NUM_NODES_SM_TREE, root.getLeftChild().numberOfNodes());
        assertEquals(NUM_NODES_MED_TREE, root.getRightChild().numberOfNodes());
        assertEquals(1, root.getLeftChild().height());
        assertEquals(2, root.getRightChild().height());
        assertEquals(RIGHT_LEFT_RIGHT,
            root.getRightChild().getLeftChild().getRightChild().getValue());
        assertEquals(RIGHT_RIGHT_LEFT,
            root.getRightChild().getRightChild().getLeftChild().getValue());
    }

    /**
     * Tests for proper tree modification.
     */
    @Test
    public void mutationTest() {
        BinaryTree<Number> root = new BinaryTree<Number>(ROOT);
        assertEquals(1, root.numberOfNodes());
        assertEquals(0, root.height());
        assertEquals(1, root.numberOfLeaves());
        assertNull(root.getLeftChild());
        assertNull(root.getRightChild());
        root.setLeftChild(null);
        assertEquals(1, root.numberOfNodes());
        assertNull(root.getLeftChild());
        root.setRightChild(null);
        assertEquals(1, root.numberOfNodes());
        assertNull(root.getRightChild());
        root.setRightChild(new BinaryTree<Number>(RIGHT));
        assertEquals(2, root.numberOfNodes());
        assertEquals(1, root.height());
        assertEquals(1, root.numberOfLeaves());
        assertEquals(RIGHT, root.getRightChild().getValue());
        assertNull(root.getLeftChild());
        root.getRightChild().setLeftChild(new BinaryTree<Number>(RIGHT_LEFT));
        assertFalse(root.getRightChild().getLeftChild().isEmpty());
        assertEquals(NUM_NODES_SM_TREE, root.numberOfNodes());
        assertEquals(2, root.height());
        assertEquals(1, root.numberOfLeaves());
        assertEquals(RIGHT_LEFT,
                     root.getRightChild().getLeftChild().getValue());
    }

    /**
    * Verifies exception for null value on non-empty tree construction.
    */
    @Test(expected = IllegalArgumentException.class)
    public void illegalValueConstructorException() {
        BinaryTree<Number> xtree = new BinaryTree<Number>(null);
    }

    /**
     * Checks string rendering.
     * Note that since no particular string rendering was specified,
     * any returned string that satisfies the loose specification must
     * be accepted.
     * That is, the string must not be null, must not be empty,
     * and must contain renderings of all of the values present
     * in the tree.
     */
    @Test
    public void treeToString() {
        BinaryTree<Number> root = new BinaryTree<Number>(ROOT);
        assertNotNull(root.toString());
        assertTrue(0 < ("" + root).length());
        String render = root.toString();
        assertTrue(0 <= render.indexOf("" + ROOT));
        root.setLeftChild(new BinaryTree<Number>(LEFT));
        root.setRightChild(new BinaryTree<Number>(RIGHT));
        root.getRightChild().setLeftChild(new BinaryTree<Number>(RIGHT_LEFT));
        assertNotNull(root.toString());
        assertTrue(0 < ("" + root).length());
        render = root.toString();
        assertTrue(0 <= render.indexOf("" + ROOT));
        assertTrue(0 <= render.indexOf("" + LEFT));
        assertTrue(0 <= render.indexOf("" + RIGHT));
        assertTrue(0 <= render.indexOf("" + RIGHT_LEFT));
        root = generateStandardTestTree();
        render = root.toString();
        assertTrue(0 <= render.indexOf("" + ROOT));
        assertTrue(0 <= render.indexOf("" + LEFT));
        assertTrue(0 <= render.indexOf("" + RIGHT));
        assertTrue(0 <= render.indexOf("" + LEFT_LEFT));
        assertTrue(0 <= render.indexOf("" + LEFT_RIGHT));
        assertTrue(0 <= render.indexOf("" + RIGHT_LEFT));
        assertTrue(0 <= render.indexOf("" + RIGHT_RIGHT));
        assertTrue(0 <= render.indexOf("" + RIGHT_LEFT_RIGHT));
        assertTrue(0 <= render.indexOf("" + RIGHT_RIGHT_LEFT));
        root = generateSearchTree();
        render = root.toString();
        for (int i = (int) A; i < (int) K; i++) {
            assertTrue(0 <= render.indexOf("" + i));
        }
    }

    /**
     * Checks values returned by preorder traversal.
     */
    @Test
    public void preorderValuesTest() {
        BinaryTree<Number> root = generateStandardTestTree();
        List<Number> orderedV = Arrays.asList(
                ROOT, LEFT, LEFT_LEFT, LEFT_RIGHT,
                RIGHT, RIGHT_LEFT, RIGHT_LEFT_RIGHT,
                RIGHT_RIGHT, RIGHT_RIGHT_LEFT);
        assertNotNull(root.preorderValues());
        assertEquals(orderedV, root.preorderValues());
        orderedV = Arrays.asList(
            F, D, B, A, C, E, H, G, I, J, K);
        assertEquals(orderedV, generateSearchTree().preorderValues());
        BinaryTree<Number> mt = new BinaryTree<Number>();
        assertNotNull(mt.preorderValues());
        assertEquals(0, mt.preorderValues().size());
    }

    /**
     * Checks values returned by inorder traversal.
     */
    @Test
    public void inorderValuesTest() {
        BinaryTree<Number> root = generateStandardTestTree();
        List<Number> orderedV = Arrays.asList(
                LEFT_LEFT, LEFT, LEFT_RIGHT,
                ROOT, RIGHT_LEFT, RIGHT_LEFT_RIGHT, RIGHT,
                RIGHT_RIGHT_LEFT, RIGHT_RIGHT);
        assertNotNull(root.inorderValues());
        assertEquals(orderedV, root.inorderValues());
        orderedV = Arrays.asList(
            A, B, C, D, E, F, G, H, I, J, K);
        assertEquals(orderedV, generateSearchTree().inorderValues());
        BinaryTree<Number> mt = new BinaryTree<Number>();
        assertNotNull(mt.inorderValues());
        assertEquals(0, mt.inorderValues().size());
    }

    /**
     * Checks values returned by postorder traversal.
     */
    @Test
    public void postorderValuesTest() {
        BinaryTree<Number> root = generateStandardTestTree();
        List<Number> orderedV = Arrays.asList(
                LEFT_LEFT, LEFT_RIGHT, LEFT, RIGHT_LEFT_RIGHT,
                RIGHT_LEFT, RIGHT_RIGHT_LEFT, RIGHT_RIGHT,
                RIGHT, ROOT);
        assertNotNull(root.postorderValues());
        assertEquals(orderedV, root.postorderValues());
        orderedV = Arrays.asList(
            A, C, B, E, D, G, K, J, I, H, F);
        assertEquals(orderedV, generateSearchTree().postorderValues());
        BinaryTree<Number> mt = new BinaryTree<Number>();
        assertNotNull(mt.postorderValues());
        assertEquals(0, mt.postorderValues().size());
    }

    /**
     * Checks nodes returned by preorder traversal.
     */
    @Test
    public void preorderNodesTest() {
        BinaryTree<Number> root = generateStandardTestTree();
        Number[] orderedV = {ROOT, LEFT, LEFT_LEFT, LEFT_RIGHT,
                RIGHT, RIGHT_LEFT, RIGHT_LEFT_RIGHT,
                RIGHT_RIGHT, RIGHT_RIGHT_LEFT};
        assertNotNull(root.preorderSubtrees());
        assertEquals(orderedV.length, root.preorderSubtrees().size());
        int i = 0;
        for (BinaryTree<Number> nbt : root.preorderSubtrees()) {
            assertEquals(orderedV[i], nbt.getValue());
            i++;
        }
        BinaryTree<Number> mt = new BinaryTree<Number>();
        assertNotNull(mt.preorderSubtrees());
        assertEquals(0, mt.preorderSubtrees().size());
    }

    /**
     * Checks nodes returned by inorder traversal.
     */
    @Test
    public void inorderNodesTest() {
        BinaryTree<Number> root = generateStandardTestTree();
        Number[] orderedV = {LEFT_LEFT, LEFT, LEFT_RIGHT,
                ROOT, RIGHT_LEFT, RIGHT_LEFT_RIGHT, RIGHT,
                RIGHT_RIGHT_LEFT, RIGHT_RIGHT};
        assertNotNull(root.inorderSubtrees());
        assertEquals(orderedV.length, root.inorderSubtrees().size());
        int i = 0;
        for (BinaryTree<Number> nbt : root.inorderSubtrees()) {
            assertEquals(orderedV[i], nbt.getValue());
            i++;
        }
        BinaryTree<Number> mt = new BinaryTree<Number>();
        assertNotNull(mt.inorderSubtrees());
        assertEquals(0, mt.inorderSubtrees().size());
    }

    /**
     * Checks nodes returned by postorder traversal.
     */
    @Test
    public void postorderNodesTest() {
        BinaryTree<Number> root = generateStandardTestTree();
        Number[] orderedV = {LEFT_LEFT, LEFT_RIGHT, LEFT,
                RIGHT_LEFT_RIGHT, RIGHT_LEFT,
                RIGHT_RIGHT_LEFT, RIGHT_RIGHT,
                RIGHT, ROOT};
        assertNotNull(root.postorderSubtrees());
        assertEquals(orderedV.length, root.postorderSubtrees().size());
        int i = 0;
        for (BinaryTree<Number> nbt : root.postorderSubtrees()) {
            assertEquals(orderedV[i], nbt.getValue());
            i++;
        }
        assertEquals(orderedV.length, root.postorderSubtrees().size());
        BinaryTree<Number> mt = new BinaryTree<Number>();
        assertNotNull(mt.postorderSubtrees());
        assertEquals(0, mt.postorderSubtrees().size());
    }

    /**
     * Checks iterator; no specific order assumed.
     */
    @Test
    public void iteratorTest() {
        BinaryTree<Number> mt = new BinaryTree<Number>();
        Iterator<BinaryTree<Number>> itr = mt.iterator();
        assertNotNull(itr);
        assertEquals(false, itr.hasNext());
        BinaryTree<Number> root = generateStandardTestTree();
        List<Number> orderedV = Arrays.asList(
                LEFT_LEFT, LEFT_RIGHT, LEFT,
                RIGHT_LEFT_RIGHT, RIGHT_LEFT,
                RIGHT_RIGHT_LEFT, RIGHT_RIGHT,
                RIGHT, ROOT);
        itr = root.iterator();
        assertNotNull(itr);
        List<BinaryTree<Number>> nodes = listOfSubtreesInPreorder(root);
        assertEquals(orderedV.size(), nodes.size());
        BinaryTree<Number> current = null;
        for (int i = 0; i < root.numberOfNodes(); i++) {
            assertTrue(itr.hasNext());
            current = itr.next();
            assertTrue(orderedV.contains(current.getValue()));
            assertTrue(nodes.contains(current));
            assertTrue(i < orderedV.size());
        }
        assertEquals(false, itr.hasNext());
    }
    /**
     * Support for iterator test.
     * Returns a list of subtrees in the order in which
     *   they would be visited using preorder traversal.
     * @param nbt the tree under test
     * @return all subtrees in preorder
     */
    private List<BinaryTree<Number>>
      listOfSubtreesInPreorder(final BinaryTree<Number> nbt) {
        List<BinaryTree<Number>> treelist = new ArrayList<BinaryTree<Number>>();
        if (nbt.numberOfNodes() != 0) {
            treelist.add(nbt);
            if (nbt.getLeftChild() != null) {
                treelist.addAll(listOfSubtreesInPreorder(nbt.getLeftChild()));
            }
            if (nbt.getRightChild() != null) {
                treelist.addAll(listOfSubtreesInPreorder(nbt.getRightChild()));
            }
        }
        return treelist;
    }

    /**
     * Utility to compare two trees for shape and contents.
     * @param nbt1 first tree for comparison
     * @param nbt2 second tree for comparison
     * @return true if and only if both are non-null,
     *      have the same number of nodes and same height,
     *      and if non-empty then also have
     *      equal root values, and if present
     *      both the left children and right children
     *      also return true to this predicate
     */
    private boolean compareTrees(final BinaryTree<Number> nbt1,
                                final BinaryTree<Number> nbt2) {
        if (nbt1 == null || nbt2 == null) {
            return false;
        }
        if (nbt1.isEmpty()) {
            return nbt2.isEmpty();
        }
        if (nbt1.height() != nbt2.height()) {
            return false;
        }
        if (!nbt1.getValue().equals(nbt2.getValue())) {
            return false;
        }
        if (nbt1.getLeftChild() == null) {
            if (nbt2.getLeftChild() != null) {
                return false;
            }
        } else if (nbt2.getLeftChild() == null) {
            return false;
        }
        if (nbt1.getLeftChild() != null
                && !compareTrees(nbt1.getLeftChild(), nbt2.getLeftChild())) {
            return false;
        }
        if (nbt1.getRightChild() == null) {
            if (nbt2.getRightChild() != null) {
                return false;
            }
        } else if (nbt2.getRightChild() == null) {
            return false;
        }
        if (nbt1.getRightChild() != null
                && !compareTrees(nbt1.getRightChild(), nbt2.getRightChild())) {
            return false;
        }
        return true;
    }

    /** Serialization filename used to replace default. */
    public static final String SER_FILENAME = "bstTest.ser";

    /**
     * Verfies round-trip serialization-deserialization
     * of empty tree to default filename.
     */
    @Test
    public void serializationDefaultEmptyTest() {
        BinaryTree<Number> mt = new BinaryTree<Number>();
        assertNotNull(mt);
        assertEquals(0, mt.numberOfNodes());
        // Test the save(null) method.
        try {
            boolean saveStatus = mt.save(null);
            assertTrue(saveStatus);
        } catch (java.io.IOException e) {
            fail("serializationDefaultEmptyTest save IOException: " + e);
            return;
        } catch (Exception e) {
            fail("serializationDefaultEmptyTest save exception: " + e);
            return;
        }
        // Test the restore(null) method.
        BinaryTree<Number> nbt = new BinaryTree<Number>(ROOT);
        assertNotNull(nbt);
        assertEquals(1, nbt.numberOfNodes());
        assertEquals(false, compareTrees(mt, nbt));
        try {
            boolean restoreStatus = nbt.restore(null);
            assertTrue(restoreStatus);
        } catch (java.io.IOException e) {
            fail("serializationDefaultEmptyTest restore IOException: " + e);
            return;
        } catch (Exception e) {
            fail("serializationDefaultEmptyTest restore exception: " + e);
            return;
        }
        // Compare original and restored trees.
        assertTrue(compareTrees(mt, nbt));
    }

    /**
     * Verfies round-trip serialization-deserialization
     * of empty tree to filename passed as parameter.
     */
    @Test
    public void serializationEmptyTest() {
        BinaryTree<Number> mt = new BinaryTree<Number>();
        assertNotNull(mt);
        assertEquals(0, mt.numberOfNodes());
        // Test the save(filename) method.
        try {
            boolean saveStatus = mt.save(SER_FILENAME);
            assertTrue(saveStatus);
        } catch (java.io.IOException e) {
            fail("serializationEmptyTest save IOException: " + e);
            return;
        } catch (Exception e) {
            fail("serializationEmptyTest save exception: " + e);
            return;
        }
        // Test the restore(filename) method.
        BinaryTree<Number> nbt = new BinaryTree<Number>(ROOT);
        assertNotNull(nbt);
        assertEquals(1, nbt.numberOfNodes());
        assertEquals(false, compareTrees(mt, nbt));
        try {
            boolean restoreStatus = nbt.restore(SER_FILENAME);
            assertTrue(restoreStatus);
        } catch (java.io.IOException e) {
            fail("serializationEmptyTest restore IOException: " + e);
            return;
        } catch (Exception e) {
            fail("serializationEmptyTest restore exception: " + e);
            return;
        }
        // Compare original and restored trees.
        assertTrue(compareTrees(mt, nbt));
    }

    /**
     * Verfies round-trip serialization-deserialization
     * of nonempty tree to filename passed as parameter.
     */
    @Test
    public void serializationNonemptyTest() {
        BinaryTree<Number> nbt = generateStandardTestTree();
        assertNotNull(nbt);
        assertEquals(NUM_NODES_TEST_TREE, nbt.numberOfNodes());
        // Test the save(filename) method.
        try {
            boolean saveStatus = nbt.save(SER_FILENAME);
            assertTrue(saveStatus);
        } catch (java.io.IOException e) {
            fail("serializationNonemptyTest save IOException: " + e);
            return;
        } catch (Exception e) {
            fail("serializationNonemptyTest save exception: " + e);
            return;
        }
        // Test the restore(filename) method.
        BinaryTree<Number> restoredbt = new BinaryTree<Number>(LEFT);
        assertNotNull(restoredbt);
        assertEquals(1, restoredbt.numberOfNodes());
        assertEquals(false, compareTrees(nbt, restoredbt));
        try {
            boolean restoreStatus = restoredbt.restore(SER_FILENAME);
            assertTrue(restoreStatus);
        } catch (java.io.IOException e) {
            fail("serializationNonemptyTest restore IOException: " + e);
            return;
        } catch (Exception e) {
            fail("serializationNonemptyTest restore exception: " + e);
            return;
        }
        // Compare original and restored trees.
        assertTrue(compareTrees(nbt, restoredbt));
    }

    /**
     * Verfies round-trip serialization-deserialization
     * of nonempty tree to default.
     */
    @Test
    public void serializationDefaultNonemptyTest() {
        BinaryTree<Number> nbt = generateStandardTestTree();
        assertNotNull(nbt);
        assertEquals(NUM_NODES_TEST_TREE, nbt.numberOfNodes());
        // Test the save(null) method.
        try {
            boolean saveStatus = nbt.save(null);
            assertTrue(saveStatus);
        } catch (java.io.IOException e) {
            fail("serializationDefaultNonemptyTest save IOException: " + e);
            return;
        } catch (Exception e) {
            fail("serializationDefaultNonemptyTest save exception: " + e);
            return;
        }
        // Test the restore(null) method.
        BinaryTree<Number> restoredbt = new BinaryTree<Number>(RIGHT);
        assertNotNull(restoredbt);
        assertEquals(1, restoredbt.numberOfNodes());
        assertEquals(false, compareTrees(nbt, restoredbt));
        try {
            boolean restoreStatus = restoredbt.restore(null);
            assertTrue(restoreStatus);
        } catch (java.io.IOException e) {
            fail("serializationDefaultNonemptyTest restore IOException: " + e);
            return;
        } catch (Exception e) {
            fail("serializationDefaultNonemptyTest restore exception: " + e);
            return;
        }
        // Compare original and restored trees.
        assertTrue(compareTrees(nbt, restoredbt));
    }

    /**
     * Verfies inequality of null.
     */
    @Test
    public void equalsNullTest() {
        BinaryTree<Number> nbt1 = new BinaryTree<Number>(ROOT);
        assertFalse(nbt1.equals(null));
        BinaryTree<Number> mt1 = new BinaryTree<Number>();
        assertFalse(mt1.equals(null));
    }

    /**
     * Verfies inequality with object of difference class.
     */
    @Test
    public void equalsOtherClassTest() {
        BinaryTree<Number> nbt1 = new BinaryTree<Number>(ROOT);
        assertFalse(nbt1.equals(ROOT));
        BinaryTree<Number> mt1 = new BinaryTree<Number>();
        assertFalse(mt1.equals(""));
    }

    /**
     * Verfies equality of empty trees.
     */
    @Test
    public void equalsMTTest() {
        BinaryTree<Number> mt1 = new BinaryTree<Number>();
        assertTrue(mt1.equals(mt1));
        BinaryTree<Number> mt2 = new BinaryTree<Number>();
        assertTrue(mt1.equals(mt2));
        assertTrue(mt2.equals(mt1));
        assertFalse(mt1.equals(null));
    }

    /**
     * Verifies equality of trees with only a root.
     */
    @Test
    public void equalsRootOnlyTest() {
        BinaryTree<Number> nbt1 = new BinaryTree<Number>(ROOT);
        assertTrue(nbt1.equals(nbt1));
        BinaryTree<Number> nbt2 = new BinaryTree<Number>(ROOT);
        assertTrue(nbt1.equals(nbt2));
        assertTrue(nbt2.equals(nbt1));
        assertFalse(nbt1.equals(null));
        BinaryTree<Number> mt1 = new BinaryTree<Number>();
        assertFalse(nbt1.equals(mt1));
        assertFalse(mt1.equals(nbt1));
    }

    /**
     * Verfies equality of arbitrary trees.
     */
    @Test
    public void equalsStandardTest() {
        BinaryTree<Number> nbt1 = generateStandardTestTree();
        assertTrue(nbt1.equals(nbt1));
        BinaryTree<Number> nbt2 = generateStandardTestTree();
        assertTrue(nbt1.equals(nbt2));
        assertTrue(nbt2.equals(nbt1));
        assertFalse(nbt1.equals(null));
        BinaryTree<Number> searchTree = generateSearchTree();
        assertFalse(nbt1.equals(searchTree));
        assertFalse(searchTree.equals(nbt1));
        BinaryTree<Number> searchTree2 = generateSearchTree();
        assertTrue(searchTree.equals(searchTree2));
    }

    /**
     * Verifies hashcode meets equals contract.
     */
    @Test
    public void hashCodeTest() {
        BinaryTree<Number> mt1 = new BinaryTree<Number>();
        BinaryTree<Number> mt2 = new BinaryTree<Number>();
        assertEquals(true, mt2.equals(mt1));
        assertEquals(mt1.hashCode(), mt2.hashCode());
        BinaryTree<Number> nbt1 = generateStandardTestTree();
        BinaryTree<Number> nbt2 = generateStandardTestTree();
        assertEquals(nbt1.hashCode(), nbt2.hashCode());
    }

    /**
     * Verifies behavior of values() method.
     */
    @Test
    public void valuesTest() {
        BinaryTree<Number> mt1 = new BinaryTree<Number>();
        BinaryTree<Number> mt2 = new BinaryTree<Number>();
        BinaryTree<Number> nbt1 = new BinaryTree<Number>(B);
        BinaryTree<Number> nbt2 = new BinaryTree<Number>(C);
        List<BinaryTree<Number>> alnbt = new ArrayList<BinaryTree<Number>>();
        alnbt.add(nbt1);
        List<Number> alnumber = BinaryTree.values(alnbt);
        assertNotNull(alnumber);
        assertEquals(1, alnumber.size());
        assertTrue(alnumber.contains(B));
        alnbt.add(nbt2);
        alnumber = BinaryTree.values(alnbt);
        assertNotNull(alnumber);
        assertEquals(2, alnumber.size());
        assertTrue(alnumber.contains(B));
        assertTrue(alnumber.contains(C));
        alnbt = new ArrayList<BinaryTree<Number>>();
        alnbt.add(mt1);
        alnumber = BinaryTree.values(alnbt);
        assertNotNull(alnumber);
        assertEquals(0, alnumber.size());
        alnbt.add(mt2);
        alnumber = BinaryTree.values(alnbt);
        assertNotNull(alnumber);
        assertEquals(0, alnumber.size());
    }
    /**
     * Verifies behavior of values() method.
     */
    @Test
    public void valuesStringTest() {
        BinaryTree<String> mt1 = new BinaryTree<String>();
        BinaryTree<String> mt2 = new BinaryTree<String>();
        BinaryTree<String> nbt1 = new BinaryTree<String>(STRING_B);
        BinaryTree<String> nbt2 = new BinaryTree<String>(STRING_C);
        List<BinaryTree<String>> alnbt = new ArrayList<BinaryTree<String>>();
        alnbt.add(nbt1);
        List<String> alnumber = BinaryTree.values(alnbt);
        assertNotNull(alnumber);
        assertEquals(1, alnumber.size());
        assertTrue(alnumber.contains(B));
        alnbt.add(nbt2);
        alnumber = BinaryTree.values(alnbt);
        assertNotNull(alnumber);
        assertEquals(2, alnumber.size());
        assertTrue(alnumber.contains(B));
        assertTrue(alnumber.contains(C));
        alnbt = new ArrayList<BinaryTree<String>>();
        alnbt.add(mt1);
        alnumber = BinaryTree.values(alnbt);
        assertNotNull(alnumber);
        assertEquals(0, alnumber.size());
        alnbt.add(mt2);
        alnumber = BinaryTree.values(alnbt);
        assertNotNull(alnumber);
        assertEquals(0, alnumber.size());
    }
}
