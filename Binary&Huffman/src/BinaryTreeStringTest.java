

// BinaryTreeStringTest.java
import static org.junit.Assert.assertEquals;
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
 * Tests for BinaryTree<String>.
 * @author  Dr. Jody Paul
 * @version $Revision: 201 $
 */
public class BinaryTreeStringTest {
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

    /**
     * Generates a standard tree for testing.
     * @return testing tree
     */
    private BinaryTree<String> generateStandardTestTree() {
        return new BinaryTree<String>(
            "ROOT",
            new BinaryTree<String>(
                "LEFT",
                new BinaryTree<String>("LEFT-LEFT"),
                new BinaryTree<String>("LEFT-RIGHT")),
            new BinaryTree<String>(
                "RIGHT",
                new BinaryTree<String>(
                    "RIGHT-LEFT",
                    null,
                    new BinaryTree<String>(
                        "RIGHT-LEFT-RIGHT")),
                new BinaryTree<String>("RIGHT-RIGHT",
                    new BinaryTree<String>("RIGHT-RIGHT-LEFT"),
                    null)));
    }

    /**
     * Generates a binary search tree.
     * @return testing search tree
     */
    private BinaryTree<String> generateSearchTree() {
        return new BinaryTree<String>(
            "F",
            new BinaryTree<String>(
                "D",
                new BinaryTree<String>(
                    "B",
                    new BinaryTree<String>("A"),
                    new BinaryTree<String>("C")),
                new BinaryTree<String>("E")),
            new BinaryTree<String>(
                "H",
                new BinaryTree<String>("G"),
                new BinaryTree<String>(
                    "I",
                    null,
                    new BinaryTree<String>(
                        "J",
                        null,
                        new BinaryTree<String>("K")))));
    }

    /**
     * Checks values returned by preorder traversal.
     */
    @Test
    public void preorderValuesTest() {
        BinaryTree<String> root = generateStandardTestTree();
        List<String> orderedV = Arrays.asList(
                "ROOT", "LEFT", "LEFT-LEFT", "LEFT-RIGHT",
                "RIGHT", "RIGHT-LEFT", "RIGHT-LEFT-RIGHT",
                "RIGHT-RIGHT", "RIGHT-RIGHT-LEFT");
        assertNotNull(root.preorderValues());
        assertEquals(orderedV, root.preorderValues());
        orderedV = Arrays.asList(
            "F", "D", "B", "A", "C", "E", "H", "G", "I", "J", "K");
        assertEquals(orderedV, generateSearchTree().preorderValues());
        BinaryTree<String> mt = new BinaryTree<String>();
        assertNotNull(mt.preorderValues());
        assertEquals(0, mt.preorderValues().size());
    }

    /**
     * Checks values returned by inorder traversal.
     */
    @Test
    public void inorderValuesTest() {
        BinaryTree<String> root = generateStandardTestTree();
        List<String> orderedV = Arrays.asList(
                "LEFT-LEFT", "LEFT", "LEFT-RIGHT",
                "ROOT", "RIGHT-LEFT", "RIGHT-LEFT-RIGHT", "RIGHT",
                "RIGHT-RIGHT-LEFT", "RIGHT-RIGHT");
        assertNotNull(root.inorderValues());
        assertEquals(orderedV, root.inorderValues());
        orderedV = Arrays.asList(
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K");
        assertEquals(orderedV, generateSearchTree().inorderValues());
        BinaryTree<String> mt = new BinaryTree<String>();
        assertNotNull(mt.inorderValues());
        assertEquals(0, mt.inorderValues().size());
    }

    /**
     * Checks values returned by postorder traversal.
     */
    @Test
    public void postorderValuesTest() {
        BinaryTree<String> root = generateStandardTestTree();
        List<String> orderedV = Arrays.asList(
                "LEFT-LEFT", "LEFT-RIGHT", "LEFT", "RIGHT-LEFT-RIGHT",
                "RIGHT-LEFT", "RIGHT-RIGHT-LEFT", "RIGHT-RIGHT",
                "RIGHT", "ROOT");
        assertNotNull(root.postorderValues());
        assertEquals(orderedV, root.postorderValues());
        orderedV = Arrays.asList(
            "A", "C", "B", "E", "D", "G", "K", "J", "I", "H", "F");
        assertEquals(orderedV, generateSearchTree().postorderValues());
        BinaryTree<String> mt = new BinaryTree<String>();
        assertNotNull(mt.postorderValues());
        assertEquals(0, mt.postorderValues().size());
    }

    /**
     * Checks nodes returned by preorder traversal.
     */
    @Test
    public void preorderNodesTest() {
        BinaryTree<String> root = generateStandardTestTree();
        String[] orderedV = {"ROOT", "LEFT", "LEFT-LEFT", "LEFT-RIGHT",
                "RIGHT", "RIGHT-LEFT", "RIGHT-LEFT-RIGHT",
                "RIGHT-RIGHT", "RIGHT-RIGHT-LEFT"};
        assertNotNull(root.preorderSubtrees());
        assertEquals(orderedV.length, root.preorderSubtrees().size());
        int i = 0;
        for (BinaryTree<String> sbt : root.preorderSubtrees()) {
            assertEquals(orderedV[i], sbt.getValue());
            i++;
        }
        BinaryTree<String> mt = new BinaryTree<String>();
        assertNotNull(mt.preorderSubtrees());
        assertEquals(0, mt.preorderSubtrees().size());
    }

    /**
     * Checks nodes returned by inorder traversal.
     */
    @Test
    public void inorderNodesTest() {
        BinaryTree<String> root = generateStandardTestTree();
        String[] orderedV = {"LEFT-LEFT", "LEFT", "LEFT-RIGHT",
                "ROOT", "RIGHT-LEFT", "RIGHT-LEFT-RIGHT", "RIGHT",
                "RIGHT-RIGHT-LEFT", "RIGHT-RIGHT"};
        assertNotNull(root.inorderSubtrees());
        assertEquals(orderedV.length, root.inorderSubtrees().size());
        int i = 0;
        for (BinaryTree<String> sbt : root.inorderSubtrees()) {
            assertEquals(orderedV[i], sbt.getValue());
            i++;
        }
        BinaryTree<String> mt = new BinaryTree<String>();
        assertNotNull(mt.inorderSubtrees());
        assertEquals(0, mt.inorderSubtrees().size());
    }

    /**
     * Checks nodes returned by postorder traversal.
     */
    @Test
    public void postorderNodesTest() {
        BinaryTree<String> root = generateStandardTestTree();
        String[] orderedV = {"LEFT-LEFT", "LEFT-RIGHT", "LEFT",
                "RIGHT-LEFT-RIGHT", "RIGHT-LEFT",
                "RIGHT-RIGHT-LEFT", "RIGHT-RIGHT",
                "RIGHT", "ROOT"};
        assertNotNull(root.postorderSubtrees());
        assertEquals(orderedV.length, root.postorderSubtrees().size());
        int i = 0;
        for (BinaryTree<String> sbt : root.postorderSubtrees()) {
            assertEquals(orderedV[i], sbt.getValue());
            i++;
        }
        assertEquals(orderedV.length, root.postorderSubtrees().size());
        BinaryTree<String> mt = new BinaryTree<String>();
        assertNotNull(mt.postorderSubtrees());
        assertEquals(0, mt.postorderSubtrees().size());
    }

    /**
     * Checks iterator; no specific order assumed.
     */
    @Test
    public void iteratorTest() {
        BinaryTree<String> mt = new BinaryTree<String>();
        Iterator<BinaryTree<String>> itr = mt.iterator();
        assertNotNull(itr);
        assertEquals(false, itr.hasNext());
        BinaryTree<String> root = generateStandardTestTree();
        List<String> orderedV = Arrays.asList(
                "LEFT-LEFT", "LEFT-RIGHT", "LEFT",
                "RIGHT-LEFT-RIGHT", "RIGHT-LEFT",
                "RIGHT-RIGHT-LEFT", "RIGHT-RIGHT",
                "RIGHT", "ROOT");
        itr = root.iterator();
        assertNotNull(itr);
        List<BinaryTree<String>> nodes = listOfSubtreesInPreorder(root);
        assertEquals(orderedV.size(), nodes.size());
        BinaryTree<String> current = null;
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
     * @param sbt binary tree to be processed
     * @return all subtrees in preorder
     */
    private List<BinaryTree<String>>
    listOfSubtreesInPreorder(final BinaryTree<String> sbt) {
        List<BinaryTree<String>> treelist = new ArrayList<BinaryTree<String>>();
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
    private boolean compareTrees(final BinaryTree<String> sbt1,
    final BinaryTree<String> sbt2) {
        if (sbt1 == null || sbt2 == null) {
            return false;
        }
        if (sbt1.isEmpty()) {
            return sbt2.isEmpty();
        }
        if (sbt1.height() != sbt2.height()) {
            return false;
        }
        if (!sbt1.getValue().equals(sbt2.getValue())) {
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
    public static final String SER_FILENAME = "bstTest.ser";

    /**
     * Verfies round-trip serialization-deserialization
     * of empty tree to default filename.
     */
    @Test
    public void serializationDefaultEmptyTest() {
        BinaryTree<String> mt = new BinaryTree<String>();
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
        BinaryTree<String> sbt = new BinaryTree<String>("ROOT");
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
        BinaryTree<String> mt = new BinaryTree<String>();
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
        BinaryTree<String> sbt = new BinaryTree<String>("ROOT");
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
        BinaryTree<String> sbt = generateStandardTestTree();
        assertNotNull(sbt);
        assertEquals(NUM_NODES_TEST_TREE, sbt.numberOfNodes());
        // Test the save(filename) method.
        try {
            boolean saveStatus = sbt.save(SER_FILENAME);
            assertTrue(saveStatus);
        } catch (java.io.IOException e) {
            fail("serializationNonemptyTest save IOException: " + e);
            return;
        } catch (Exception e) {
            fail("serializationNonemptyTest save exception: " + e);
            return;
        }
        // Test the restore(filename) method.
        BinaryTree<String> restoredbt = new BinaryTree<String>("ROOT ONLY");
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
        BinaryTree<String> sbt = generateStandardTestTree();
        assertNotNull(sbt);
        assertEquals(NUM_NODES_TEST_TREE, sbt.numberOfNodes());
        // Test the save(null) method.
        try {
            boolean saveStatus = sbt.save(null);
            assertTrue(saveStatus);
        } catch (java.io.IOException e) {
            fail("serializationDefaultNonemptyTest save IOException: " + e);
            return;
        } catch (Exception e) {
            fail("serializationDefaultNonemptyTest save exception: " + e);
            return;
        }
        // Test the restore(null) method.
        BinaryTree<String> restoredbt = new BinaryTree<String>("ROOT ONLY");
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

    /** Empty tree equality tests. */
    @Test
    public void equalsMTTest() {
        BinaryTree<String> mt1 = new BinaryTree<String>();
        assertTrue(mt1.equals(mt1));
        BinaryTree<String> mt2 = new BinaryTree<String>();
        assertTrue(mt1.equals(mt2));
        assertTrue(mt2.equals(mt1));
        assertFalse(mt1.equals(null));
    }

    /** Single node tree equality tests. */
    @Test
    public void equalsRootOnlyTest() {
        BinaryTree<String> sbt1 = new BinaryTree<String>("ROOT");
        assertTrue(sbt1.equals(sbt1));
        BinaryTree<String> sbt2 = new BinaryTree<String>("ROOT");
        assertTrue(sbt1.equals(sbt2));
        assertTrue(sbt2.equals(sbt1));
        assertFalse(sbt1.equals(null));
        BinaryTree<String> mt1 = new BinaryTree<String>();
        assertFalse(sbt1.equals(mt1));
        assertFalse(mt1.equals(sbt1));
    }

    /** Test of equals predicate. */
    @Test
    public void equalsStandardTest() {
        BinaryTree<String> sbt1 = generateStandardTestTree();
        assertTrue(sbt1.equals(sbt1));
        BinaryTree<String> sbt2 = generateStandardTestTree();
        assertTrue(sbt1.equals(sbt2));
        assertTrue(sbt2.equals(sbt1));
        assertFalse(sbt1.equals(null));
        BinaryTree<String> searchTree = generateSearchTree();
        assertFalse(sbt1.equals(searchTree));
        assertFalse(searchTree.equals(sbt1));
        BinaryTree<String> searchTree2 = generateSearchTree();
        assertTrue(searchTree.equals(searchTree2));
    }

    /** Verifies hashCode method as consistent with equals. */
    @Test
    public void hashCodeTest() {
        BinaryTree<String> mt1 = new BinaryTree<String>();
        BinaryTree<String> mt2 = new BinaryTree<String>();
        assertEquals(true, mt2.equals(mt1));
        assertEquals(mt1.hashCode(), mt2.hashCode());
    }

    /** Verifies behavior of static values(...) method. */
    @Test
    public void valuesTest() {
        BinaryTree<String> mt1 = new BinaryTree<String>();
        BinaryTree<String> mt2 = new BinaryTree<String>();
        BinaryTree<String> sbt1 = new BinaryTree<String>("ONE");
        BinaryTree<String> sbt2 = new BinaryTree<String>("TWO");
        List<BinaryTree<String>> alsbt = new ArrayList<BinaryTree<String>>();
        alsbt.add(sbt1);
        List<String> alstring = BinaryTree.values(alsbt);
        assertNotNull(alstring);
        assertEquals(1, alstring.size());
        assertTrue(alstring.contains("ONE"));
        alsbt.add(sbt2);
        alstring = BinaryTree.values(alsbt);
        assertNotNull(alstring);
        assertEquals(2, alstring.size());
        assertTrue(alstring.contains("ONE"));
        assertTrue(alstring.contains("TWO"));
        alsbt = new ArrayList<BinaryTree<String>>();
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

