

// BinaryTreeStringBuilderTest.java
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
 * Tests for BinaryTree using StringBuilder.
 * @author  Dr. Jody Paul
 * @version $Revision: 201 $
 */
public class BinaryTreeStringBuilderTest {
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

    /** Common object ROOT. */
    private static final StringBuilder ROOT = new StringBuilder("ROOT");
    /** Common object LEFT. */
    private static final StringBuilder LEFT = new StringBuilder("LEFT");
    /** Common object RIGHT. */
    private static final StringBuilder RIGHT = new StringBuilder("RIGHT");

    /**
     * Generates a standard tree for testing.
     * @return testing tree
     */
    private BinaryTree<StringBuilder> generateStandardTestTree() {
        return new BinaryTree<StringBuilder>(
                    ROOT,
                    new BinaryTree<StringBuilder>(
                          LEFT,
                          new BinaryTree<StringBuilder>(new StringBuilder("LEFT-LEFT")),
                          new BinaryTree<StringBuilder>(new StringBuilder("LEFT-RIGHT"))),
                    new BinaryTree<StringBuilder>(
                          RIGHT,
                          new BinaryTree<StringBuilder>(
                                new StringBuilder("RIGHT-LEFT"),
                                null,
                                new BinaryTree<StringBuilder>(
                                      new StringBuilder("RIGHT-LEFT-RIGHT"))),
                                      new BinaryTree<StringBuilder>(new StringBuilder("RIGHT-RIGHT"),
                                      new BinaryTree<StringBuilder>(new StringBuilder("RIGHT-RIGHT-LEFT")),
                          null)));
    }

    /**
     * Generates a binary search tree.
     * @return testing search tree
     */
    private BinaryTree<StringBuilder> generateSearchTree() {
        return new BinaryTree<StringBuilder>(
            new StringBuilder("F"),
            new BinaryTree<StringBuilder>(
                new StringBuilder("D"),
                new BinaryTree<StringBuilder>(
                    new StringBuilder("B"),
                    new BinaryTree<StringBuilder>(new StringBuilder("A")),
                    new BinaryTree<StringBuilder>(new StringBuilder("C"))),
                new BinaryTree<StringBuilder>(new StringBuilder("E"))),
            new BinaryTree<StringBuilder>(
                new StringBuilder("H"),
                new BinaryTree<StringBuilder>(new StringBuilder("G")),
                new BinaryTree<StringBuilder>(
                    new StringBuilder("I"),
                    null,
                    new BinaryTree<StringBuilder>(
                        new StringBuilder("J"),
                        null,
                        new BinaryTree<StringBuilder>(new StringBuilder("K"))))));
    }

    /**
     * Tests valid methods for empty tree.
     */
    @Test
    public void emptyTreeTest() {
        BinaryTree<StringBuilder> mtTree = new BinaryTree<StringBuilder>();
        assertEquals(true, mtTree.isEmpty());
        assertEquals(0, mtTree.numberOfNodes());
        assertEquals(-1, mtTree.height());
    }

    /**
    * Verifies exception for value accessor on empty tree.
    */
    @Test(expected = NullPointerException.class)
    public void emptyTreeGetValueException() {
        BinaryTree<StringBuilder> mtTree = new BinaryTree<StringBuilder>();
        StringBuilder x = mtTree.getValue();
    }

    /**
    * Verifies exception for child accessor on empty tree.
    */
    @Test(expected = NullPointerException.class)
    public void emptyTreeGetChildException() {
        BinaryTree<StringBuilder> mtTree = new BinaryTree<StringBuilder>();
        BinaryTree<StringBuilder> x = mtTree.getLeftChild();
    }

    /**
    * Verifies exception for value mutator on empty tree.
    */
    @Test(expected = NullPointerException.class)
    public void emptyTreeSetValueException() {
        BinaryTree<StringBuilder> mtTree = new BinaryTree<StringBuilder>();
        mtTree.setValue(new StringBuilder("REJECT"));
    }

    /**
    * Verifies exception for child mutator on empty tree.
    */
    @Test(expected = NullPointerException.class)
    public void emptyTreeSetChildException() {
        BinaryTree<StringBuilder> mtTree = new BinaryTree<StringBuilder>();
        mtTree.setLeftChild(new BinaryTree<StringBuilder>());
    }

    /**
     * Tests for single-node tree.
     */
    @Test
    public void oneNodeTest() {
        BinaryTree<StringBuilder> root = new BinaryTree<StringBuilder>(ROOT);
        assertEquals(false, root.isEmpty());
        assertEquals(1, root.numberOfNodes());
        assertEquals(0, root.height());
        assertNotNull(root.getValue());
        assertEquals("ROOT", root.getValue().toString());
        assertEquals(1, root.numberOfLeaves());
        assertNull(root.getLeftChild());
        assertNull(root.getRightChild());
        root.setValue(new StringBuilder("NEW VALUE"));
        assertEquals("NEW VALUE", root.getValue().toString());
    }

    /**
     * Tests for single-node tree using parameterized constructor.
     */
    @Test
    public void oneNodeSecondaryTest() {
        BinaryTree<StringBuilder> root = new BinaryTree<StringBuilder>(new StringBuilder("root"), null, null);
        assertEquals(false, root.isEmpty());
        assertEquals(1, root.numberOfNodes());
        assertEquals(0, root.height());
        assertNotNull(root.getValue());
        assertEquals("root", root.getValue().toString());
        assertEquals(1, root.numberOfLeaves());
        assertNull(root.getLeftChild());
        assertNull(root.getRightChild());
        root.setValue(new StringBuilder("new value"));
        assertEquals("new value", root.getValue().toString());
    }

    /**
     * Tests for multiple-node tree using parameterized constructor.
     */
    @Test
    public void multiNodeConstructionTest() {
        BinaryTree<StringBuilder> root = generateStandardTestTree();
        assertEquals(false, root.isEmpty());
        assertEquals(NUM_NODES_TEST_TREE, root.numberOfNodes());
        assertEquals(NUM_LEAVES_TEST_TREE, root.numberOfLeaves());
        assertEquals(HEIGHT_TEST_TREE, root.height());
        assertEquals("ROOT", root.getValue().toString());
        assertNotNull(root.getLeftChild());
        assertNotNull(root.getRightChild());
        assertNotNull(root.getLeftChild().getLeftChild());
        assertNotNull(root.getRightChild().getLeftChild());
        assertNull(root.getLeftChild().getLeftChild().getLeftChild());
        assertNotNull(root.getRightChild().getLeftChild().getRightChild());
        assertNull(root.getRightChild().getLeftChild().getLeftChild());
        assertEquals(NUM_NODES_SM_TREE, root.getLeftChild().numberOfNodes());
        assertEquals(NUM_NODES_MED_TREE, root.getRightChild().numberOfNodes());
        assertEquals(1, root.getLeftChild().height());
        assertEquals(2, root.getRightChild().height());
        assertEquals("RIGHT-LEFT-RIGHT",
            root.getRightChild().getLeftChild().getRightChild().getValue().toString());
        assertEquals("RIGHT-RIGHT-LEFT",
            root.getRightChild().getRightChild().getLeftChild().getValue().toString());
    }

    /**
     * Tests for proper tree modification.
     */
    @Test
    public void mutationTest() {
        BinaryTree<StringBuilder> root = new BinaryTree<StringBuilder>(ROOT);
        assertEquals(1, root.numberOfNodes());
        assertEquals(0, root.height());
        assertEquals(1, root.numberOfLeaves());
        assertNull(root.getLeftChild());
        assertNull(root.getRightChild());
        root.setLeftChild(null);
        assertEquals(1, root.numberOfNodes());
        assertNull(root.getLeftChild());
        root.setRightChild(new BinaryTree<StringBuilder>(RIGHT));
        assertEquals(2, root.numberOfNodes());
        assertEquals(1, root.height());
        assertEquals(1, root.numberOfLeaves());
        assertEquals("RIGHT", root.getRightChild().getValue().toString());
        assertNull(root.getLeftChild());
        root.getRightChild().setLeftChild(new BinaryTree<StringBuilder>(new StringBuilder("RIGHT-LEFT")));
        assertNotNull(root.getRightChild().getLeftChild());
        assertEquals(NUM_NODES_SM_TREE, root.numberOfNodes());
        assertEquals(2, root.height());
        assertEquals(1, root.numberOfLeaves());
        assertEquals("RIGHT-LEFT",
                     root.getRightChild().getLeftChild().getValue().toString());
    }

    /**
    * Verifies exception for null value on non-empty tree construction.
    */
    @Test(expected = IllegalArgumentException.class)
    public void illegalValueConstructorException() {
        BinaryTree<StringBuilder> xtree = new BinaryTree<StringBuilder>(null);
    }

    /**
     * Demonstrates string rendering.
     * Note that since no particular string rendering was specified,
     * any returned string satisfies the specification.
     * Contains commented-out tests for non-null and non-empty string.
     */
    // @Test
    // public void showTree() {
    //     BinaryTree<StringBuilder> root = new BinaryTree<StringBuilder>(ROOT);
    //     System.out.println(root);
    //     root.setLeftChild(new BinaryTree<StringBuilder>(LEFT));
    //     System.out.println(root);
    //     root.setRightChild(new BinaryTree<StringBuilder>(RIGHT));
    //     System.out.println(root);
    //     root.getRightChild().setLeftChild(new BinaryTree<StringBuilder>(new StringBuilder("RIGHT-LEFT")));
    //     System.out.println(root);
    //     //assertNotNull(root.toStringBuilder());
    //     //assertTrue("" != "" + root);
    // }

    /**
     * Checks values returned by preorder traversal.
     */
    @Test
    public void preorderValuesTest() {
        BinaryTree<StringBuilder> root = generateStandardTestTree();
        List<String> orderedV = Arrays.asList(
                "ROOT", "LEFT", "LEFT-LEFT", "LEFT-RIGHT",
                "RIGHT", "RIGHT-LEFT", "RIGHT-LEFT-RIGHT",
                "RIGHT-RIGHT", "RIGHT-RIGHT-LEFT");
        List<StringBuilder> treeV = root.preorderValues();
        assertNotNull(treeV);
        for (int i = 0; i < orderedV.size(); i++) {
            assertEquals(orderedV.get(i), treeV.get(i).toString());
        }
        orderedV = Arrays.asList(
            "F", "D", "B", "A", "C", "E", "H", "G", "I", "J", "K");
        treeV = generateSearchTree().preorderValues();
        assertNotNull(treeV);
        for (int i = 0; i < orderedV.size(); i++) {
            assertEquals(orderedV.get(i), treeV.get(i).toString());
        }
        BinaryTree<StringBuilder> mt = new BinaryTree<StringBuilder>();
        assertNotNull(mt.preorderValues());
        assertEquals(0, mt.preorderValues().size());
    }

    /**
     * Checks values returned by inorder traversal.
     */
    @Test
    public void inorderValuesTest() {
        BinaryTree<StringBuilder> root = generateStandardTestTree();
        List<String> orderedV = Arrays.asList(
                "LEFT-LEFT", "LEFT", "LEFT-RIGHT",
                "ROOT", "RIGHT-LEFT", "RIGHT-LEFT-RIGHT", "RIGHT",
                "RIGHT-RIGHT-LEFT", "RIGHT-RIGHT");
        List<StringBuilder> treeV = root.inorderValues();
        assertNotNull(treeV);
        for (int i = 0; i < orderedV.size(); i++) {
            assertEquals(orderedV.get(i), treeV.get(i).toString());
        }
        orderedV = Arrays.asList(
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K");
        treeV = generateSearchTree().inorderValues();
        assertNotNull(treeV);
        for (int i = 0; i < orderedV.size(); i++) {
            assertEquals(orderedV.get(i), treeV.get(i).toString());
        }
        BinaryTree<StringBuilder> mt = new BinaryTree<StringBuilder>();
        assertNotNull(mt.inorderValues());
        assertEquals(0, mt.inorderValues().size());
    }

    /**
     * Checks values returned by postorder traversal.
     */
    @Test
    public void postorderValuesTest() {
        BinaryTree<StringBuilder> root = generateStandardTestTree();
        List<String> orderedV = Arrays.asList(
                "LEFT-LEFT", "LEFT-RIGHT", "LEFT", "RIGHT-LEFT-RIGHT",
                "RIGHT-LEFT", "RIGHT-RIGHT-LEFT", "RIGHT-RIGHT",
                "RIGHT", "ROOT");
        List<StringBuilder> treeV = root.postorderValues();
        assertNotNull(treeV);
        for (int i = 0; i < orderedV.size(); i++) {
            assertEquals(orderedV.get(i), treeV.get(i).toString());
        }
        orderedV = Arrays.asList(
            "A", "C", "B", "E", "D", "G", "K", "J", "I", "H", "F");
        treeV = generateSearchTree().postorderValues();
        assertNotNull(treeV);
        for (int i = 0; i < orderedV.size(); i++) {
            assertEquals(orderedV.get(i), treeV.get(i).toString());
        }
        BinaryTree<StringBuilder> mt = new BinaryTree<StringBuilder>();
        assertNotNull(mt.postorderValues());
        assertEquals(0, mt.postorderValues().size());
    }

    /**
     * Checks nodes returned by preorder traversal.
     */
    @Test
    public void preorderNodesTest() {
        BinaryTree<StringBuilder> root = generateStandardTestTree();
        String[] orderedV = {"ROOT", "LEFT", "LEFT-LEFT", "LEFT-RIGHT",
                "RIGHT", "RIGHT-LEFT", "RIGHT-LEFT-RIGHT",
                "RIGHT-RIGHT", "RIGHT-RIGHT-LEFT"};
        assertNotNull(root.preorderSubtrees());
        assertEquals(orderedV.length, root.preorderSubtrees().size());
        int i = 0;
        for (BinaryTree<StringBuilder> sbt : root.preorderSubtrees()) {
            assertEquals(orderedV[i], sbt.getValue().toString());
            i++;
        }
        BinaryTree<StringBuilder> mt = new BinaryTree<StringBuilder>();
        assertNotNull(mt.preorderSubtrees());
        assertEquals(0, mt.preorderSubtrees().size());
    }

    /**
     * Checks nodes returned by inorder traversal.
     */
    @Test
    public void inorderNodesTest() {
        BinaryTree<StringBuilder> root = generateStandardTestTree();
        String[] orderedV = {"LEFT-LEFT", "LEFT", "LEFT-RIGHT",
                "ROOT", "RIGHT-LEFT", "RIGHT-LEFT-RIGHT", "RIGHT",
                "RIGHT-RIGHT-LEFT", "RIGHT-RIGHT"};
        assertNotNull(root.inorderSubtrees());
        assertEquals(orderedV.length, root.inorderSubtrees().size());
        int i = 0;
        for (BinaryTree<StringBuilder> sbt : root.inorderSubtrees()) {
            assertEquals(orderedV[i], sbt.getValue().toString());
            i++;
        }
        BinaryTree<StringBuilder> mt = new BinaryTree<StringBuilder>();
        assertNotNull(mt.inorderSubtrees());
        assertEquals(0, mt.inorderSubtrees().size());
    }

    /**
     * Checks nodes returned by postorder traversal.
     */
    @Test
    public void postorderNodesTest() {
        BinaryTree<StringBuilder> root = generateStandardTestTree();
        String[] orderedV = {"LEFT-LEFT", "LEFT-RIGHT", "LEFT",
                "RIGHT-LEFT-RIGHT", "RIGHT-LEFT",
                "RIGHT-RIGHT-LEFT", "RIGHT-RIGHT",
                "RIGHT", "ROOT"};
        assertNotNull(root.postorderSubtrees());
        assertEquals(orderedV.length, root.postorderSubtrees().size());
        int i = 0;
        for (BinaryTree<StringBuilder> sbt : root.postorderSubtrees()) {
            assertEquals(orderedV[i], sbt.getValue().toString());
            i++;
        }
        assertEquals(orderedV.length, root.postorderSubtrees().size());
        BinaryTree<StringBuilder> mt = new BinaryTree<StringBuilder>();
        assertNotNull(mt.postorderSubtrees());
        assertEquals(0, mt.postorderSubtrees().size());
    }

    /**
     * Checks iterator; no specific order assumed.
     */
    @Test
    public void iteratorTest() {
        BinaryTree<StringBuilder> mt = new BinaryTree<StringBuilder>();
        Iterator<BinaryTree<StringBuilder>> itr = mt.iterator();
        assertNotNull(itr);
        assertEquals(false, itr.hasNext());
        BinaryTree<StringBuilder> root = generateStandardTestTree();
        List<String> orderedV = Arrays.asList(
                "LEFT-LEFT", "LEFT-RIGHT", "LEFT",
                "RIGHT-LEFT-RIGHT", "RIGHT-LEFT",
                "RIGHT-RIGHT-LEFT", "RIGHT-RIGHT",
                "RIGHT", "ROOT");
        itr = root.iterator();
        assertNotNull(itr);
        List<BinaryTree<StringBuilder>> nodes = listOfSubtreesInPreorder(root);
        assertEquals(orderedV.size(), nodes.size());
        BinaryTree<StringBuilder> current = null;
        for (int i = 0; i < root.numberOfNodes(); i++) {
            assertTrue(itr.hasNext());
            current = itr.next();
            assertTrue(orderedV.contains(current.getValue().toString()));
            assertTrue(nodes.contains(current));
            assertTrue(i < orderedV.size());
        }
        assertEquals(false, itr.hasNext());
    }
    /**
     * Support for iterator test.
     * Returns a list of subtrees in the order in which
     *   they would be visited using preorder traversal.
     * @param sbt the tree to be traversed
     * @return all subtrees in preorder
     */
    private List<BinaryTree<StringBuilder>> listOfSubtreesInPreorder(final BinaryTree<StringBuilder> sbt) {
        List<BinaryTree<StringBuilder>> treelist = new ArrayList<BinaryTree<StringBuilder>>();
        if (sbt.numberOfNodes() != 0) {
            treelist.add(sbt);
            if (sbt.getLeftChild() != null) {
                treelist.addAll(listOfSubtreesInPreorder(sbt.getLeftChild()));
            }
            if (sbt.getRightChild() != null) {
                treelist.addAll(listOfSubtreesInPreorder(sbt.getRightChild()));
            }
        }
        return treelist;
    }

    /**
     * Utility to compare two trees for shape and contents.
     * @param sbt1 first tree for comparison
     * @param sbt2 second tree for comparison
     * @return true if and only if both are non-null,
     *      have the same number of nodes and same height,
     *      and if non-empty then also have
     *      equal root values, and if present
     *      both the left children and right children
     *      also return true to this predicate
     */
    private boolean compareTrees(final BinaryTree<StringBuilder> sbt1,
                                 final BinaryTree<StringBuilder> sbt2) {
        if (sbt1 == null || sbt2 == null) {
            return false;
        }
        if (sbt1.isEmpty()) {
            return sbt2.isEmpty();
        }
        if (sbt1.height() != sbt2.height()) {
            return false;
        }
        if (!sbt1.getValue().toString().equals(sbt2.getValue().toString())) {
            return false;
        }
        if (sbt1.getLeftChild() == null) {
            if (sbt2.getLeftChild() != null) {
                return false;
            }
        } else if (sbt2.getLeftChild() == null) {
            return false;
        }
        if (sbt1.getLeftChild() != null
                && !compareTrees(sbt1.getLeftChild(), sbt2.getLeftChild())) {
            return false;
        }
        if (sbt1.getRightChild() == null) {
            if (sbt2.getRightChild() != null) {
                return false;
            }
        } else if (sbt2.getRightChild() == null) {
            return false;
        }
        if (sbt1.getRightChild() != null
                && !compareTrees(sbt1.getRightChild(), sbt2.getRightChild())) {
            return false;
        }
        return true;
    }

    /** Serialization filename used to replace default. */
    public static final String SER_FILENAME = "btTest.ser";

    /**
     * Verfies round-trip serialization-deserialization
     * of empty tree to default filename.
     */
    @Test
    public void serializationDefaultEmptyTest() {
        BinaryTree<StringBuilder> mt = new BinaryTree<StringBuilder>();
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
        BinaryTree<StringBuilder> sbt = new BinaryTree<StringBuilder>(ROOT);
        assertNotNull(sbt);
        assertEquals(1, sbt.numberOfNodes());
        assertEquals(false, compareTrees(mt, sbt));
        try {
            boolean restoreStatus = sbt.restore(null);
            assertTrue(restoreStatus);
        } catch (java.io.IOException e) {
            fail("serializationDefaultEmptyTest restore IOException: " + e);
            return;
        } catch (Exception e) {
            fail("serializationDefaultEmptyTest restore exception: " + e);
            return;
        }
        // Compare original and restored trees.
        assertTrue(compareTrees(mt, sbt));
    }

    /**
     * Verfies round-trip serialization-deserialization
     * of empty tree to filename passed as parameter.
     */
    @Test
    public void serializationEmptyTest() {
        BinaryTree<StringBuilder> mt = new BinaryTree<StringBuilder>();
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
        BinaryTree<StringBuilder> sbt = new BinaryTree<StringBuilder>(ROOT);
        assertNotNull(sbt);
        assertEquals(1, sbt.numberOfNodes());
        assertEquals(false, compareTrees(mt, sbt));
        try {
            boolean restoreStatus = sbt.restore(SER_FILENAME);
            assertTrue(restoreStatus);
        } catch (java.io.IOException e) {
            fail("serializationEmptyTest restore IOException: " + e);
            return;
        } catch (Exception e) {
            fail("serializationEmptyTest restore exception: " + e);
            return;
        }
        // Compare original and restored trees.
        assertTrue(compareTrees(mt, sbt));
    }

    /**
     * Verfies round-trip serialization-deserialization
     * of nonempty tree to filename passed as parameter.
     */
    @Test
    public void serializationNonemptyTest() {
        BinaryTree<StringBuilder> sbt = generateStandardTestTree();
        assertNotNull(sbt);
        assertEquals(NUM_NODES_TEST_TREE, sbt.numberOfNodes());
        // Test the save(filename) method.
        try {
            boolean saveStatus = sbt.save(SER_FILENAME);
            // assertTrue(saveStatus);
        } catch (java.io.IOException e) {
            fail("serializationNonemptyTest save IOException: " + e);
            return;
        } catch (Exception e) {
            fail("serializationNonemptyTest save exception: " + e);
            return;
        }
        // Test the restore(filename) method.
        BinaryTree<StringBuilder> restoredbt = new BinaryTree<StringBuilder>(new StringBuilder("ROOT ONLY"));
        assertNotNull(restoredbt);
        assertEquals(1, restoredbt.numberOfNodes());
        assertEquals(false, compareTrees(sbt, restoredbt));
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
        assertTrue(compareTrees(sbt, restoredbt));
    }

    /**
     * Verfies round-trip serialization-deserialization
     * of nonempty tree to default.
     */
    @Test
    public void serializationDefaultNonemptyTest() {
        BinaryTree<StringBuilder> sbt = generateStandardTestTree();
        assertNotNull(sbt);
        assertEquals(NUM_NODES_TEST_TREE, sbt.numberOfNodes());
        // Test the save(null) method.
        try {
            boolean saveStatus = sbt.save(null);
            // assertTrue(saveStatus);
        } catch (java.io.IOException e) {
            fail("serializationDefaultNonemptyTest save IOException: " + e);
            return;
        } catch (Exception e) {
            fail("serializationDefaultNonemptyTest save exception: " + e);
            return;
        }
        // Test the restore(null) method.
        BinaryTree<StringBuilder> restoredbt = new BinaryTree<StringBuilder>(new StringBuilder("ROOT ONLY"));
        assertNotNull(restoredbt);
        assertEquals(1, restoredbt.numberOfNodes());
        assertEquals(false, compareTrees(sbt, restoredbt));
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
        assertTrue(compareTrees(sbt, restoredbt));
    }

    /**
     * Verifies equality of empty trees.
     */
    @Test
    public void equalsMTTest() {
        BinaryTree<StringBuilder> mt1 = new BinaryTree<StringBuilder>();
        assertTrue(mt1.equals(mt1));
        BinaryTree<StringBuilder> mt2 = new BinaryTree<StringBuilder>();
        assertTrue(mt1.equals(mt2));
        assertTrue(mt2.equals(mt1));
        assertFalse(mt1.equals(null));
    }

    /**
     * Checks equality of trees consisting of only a root.
     */
    @Test
    public void equalsRootOnlyTest() {
        StringBuilder root = ROOT;
        BinaryTree<StringBuilder> sbt1 = new BinaryTree<StringBuilder>(root);
        assertTrue(sbt1.equals(sbt1));
        BinaryTree<StringBuilder> sbt2 = new BinaryTree<StringBuilder>(root);
        assertTrue(sbt1.equals(sbt2));
        assertTrue(sbt2.equals(sbt1));
        assertFalse(sbt1.equals(null));
        BinaryTree<StringBuilder> mt1 = new BinaryTree<StringBuilder>();
        assertFalse(sbt1.equals(mt1));
        assertFalse(mt1.equals(sbt1));
    }

    /**
     * Checks equality of arbitrary trees.
     */
    @Test
    public void equalsStandardTest() {
        BinaryTree<StringBuilder> sbt1 = generateStandardTestTree();
        assertTrue(sbt1.equals(sbt1));
        BinaryTree<StringBuilder> sbt2 = generateStandardTestTree();
        assertTrue(compareTrees(sbt1, sbt2));
        assertTrue(compareTrees(sbt2, sbt1));
        assertFalse(sbt1.equals(null));
        BinaryTree<StringBuilder> searchTree = generateSearchTree();
        assertFalse(sbt1.equals(searchTree));
        assertFalse(searchTree.equals(sbt1));
        BinaryTree<StringBuilder> searchTree2 = generateSearchTree();
        assertTrue(compareTrees(searchTree, searchTree2));
    }

    /**
     * Checks that hashCode meets the equality requirement.
     */
    @Test
    public void hashCodeTest() {
        BinaryTree<StringBuilder> mt1 = new BinaryTree<StringBuilder>();
        BinaryTree<StringBuilder> mt2 = new BinaryTree<StringBuilder>();
        assertEquals(true, mt2.equals(mt1));
        assertEquals(mt1.hashCode(), mt2.hashCode());
    }

    /**
     * Verifies behavior of the values class method.
     */
    @Test
    public void valuesTest() {
        BinaryTree<StringBuilder> mt1 = new BinaryTree<StringBuilder>();
        BinaryTree<StringBuilder> mt2 = new BinaryTree<StringBuilder>();
        StringBuilder one = new StringBuilder("ONE");
        StringBuilder two = new StringBuilder("TWO");
        BinaryTree<StringBuilder> sbt1 = new BinaryTree<StringBuilder>(one);
        BinaryTree<StringBuilder> sbt2 = new BinaryTree<StringBuilder>(two);
        List<BinaryTree<StringBuilder>> alsbt = new ArrayList<BinaryTree<StringBuilder>>();
        alsbt.add(sbt1);
        List<StringBuilder> alstring = BinaryTree.values(alsbt);
        assertNotNull(alstring);
        assertEquals(1, alstring.size());
        assertTrue(alstring.contains(one));
        alsbt.add(sbt2);
        alstring = BinaryTree.values(alsbt);
        assertNotNull(alstring);
        assertEquals(2, alstring.size());
        assertTrue(alstring.contains(one));
        assertTrue(alstring.contains(two));
        alsbt = new ArrayList<BinaryTree<StringBuilder>>();
        alsbt.add(mt1);
        alstring = BinaryTree.values(alsbt);
        assertNotNull(alstring);
        assertEquals(0, alstring.size());
        alsbt.add(mt2);
        alstring = BinaryTree.values(alsbt);
        assertNotNull(alstring);
        assertEquals(0, alstring.size());
    }
}

