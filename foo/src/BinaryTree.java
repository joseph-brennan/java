import java.util.List;
/**
 * A generic binary tree whose root holds a non-null value.
 * <p>
 * The BinaryTree datatype is defined recursively as
 * the empty tree or
 * a rooted tree comprised of a root value,
 * a non-null reference to a left child of type BinaryTree, and
 * a non-null reference to a right child of type BinaryTree.
 * As this datatype represents a binary tree,
 * there must be no duplicate references nor any references
 * to the root.
 * </p>
 * <p>
 * The empty tree is distinguished by the following properties:<br>
 * <code>isEmpty() == true</code>, and<br>
 * <code>height() == -1</code>,<br>
 * <code>numberOfNodes() == 0</code>.<br>
 * Further, the empty tree throws exceptions when any of the following
 * methods is invoked:<br>
 * <code>getLeftChild()</code>,
 * <code>getRightChild()</code>,
 * <code>getValue()</code>,
 * <code>isLeaf()</code>,
 * <code>numberOfLeaves()</code>,
 * <code>setLeftChild()</code>,
 * <code>setRightChild()</code>,
 * <code>setValue()</code>.
 * </p>
 * <p>
 * Every leaf node has the empty tree as its left child
 * and the empty tree as its right child.
 * </p>
 * <p>
 * Two binary trees are equal if and only if<br>
 * (1) they have the same structure and<br>
 * (2) respective elements stored at respective nodes
 * in both trees are equal.<br>
 * <small>[Walicki, M., <i>Introduction to Mathematical Logic,</i>
 *        World Scientific, 2011]</small>
 * </p>
 * <p>&nbsp;</p>
 * Terminology:<ul>
 * <li><em>ancestor</em> = a parent, grandparent,
 *        great-grandparent, etc.</li>
 * <li><em>descendant</em> = a child, grandchild,
 *        great-grandchild, etc.</li>
 * <li><em>height</em> = the length of the longest downward path to a leaf</li>
 * <li><em>internal</em> = a tree with at least one child</li>
 * <li><em>leaf</em> = a tree with no children</li>
 * <li><em>root</em> = any BinaryTree object</li>
 * <li><em>tree</em> = a BinaryTree with all its descendants</li>
 * <li><em>subtree of tree A</em> = a tree whose root is within tree A</li>
 * </ul>
 *
 * @param <T> the type of value stored by this tree
 *
 * @author Programming Pragmatics (Fall 2016)
 * @version $Revision: 191 $
 */
public class BinaryTree<T>
        implements Iterable<BinaryTree<T>>, java.io.Serializable {

    /** Default return value for boolean methods. */
    private static final boolean DEFAULT_RETURN_BOOLEAN = false;
    /** Default return value for int methods. */
    private static final int DEFAULT_RETURN_INT = -42;
    // Default return value for object methods is null.

    /** Default state save/restore file name. */
    public static final String SERIAL_FILENAME = "sbt.ser";

    /**
     * Serialization version indicator used to determine
     *    if a file is compatible with this class.
     */
    private static final long serialVersionUID = 2016090422L;

    /**
     * Constructs an empty tree.
     */
    public BinaryTree() {
    }

    /**
     * Constructs a tree with no children
     * whose value is specified by the parameter.
     * @param rootvalue the value stored at the root of the tree
     * @throws IllegalArgumentException if parameter is null
     */
    public BinaryTree(final T rootvalue)
            throws IllegalArgumentException {
    }

    /**
     * Constructs a tree with specified value,
     *   left child, and right child.
     * @param rootvalue the value stored at the root of the tree
     * @param leftchild the left child of the root;
     *        <code>null</code> if no such child
     * @param rightchild the right child of the root;
     *        <code>null</code> if no such child
     * @throws IllegalArgumentException
     *         if <code>rootvalue</code> parameter is null
     */
    public BinaryTree(final T rootvalue,
                      final BinaryTree<T> leftchild,
                      final BinaryTree<T> rightchild)
            throws IllegalArgumentException {
    }

    /**
     * Empty tree predicate.
     * @return <code>true</code> if this is an empty tree;
     *         <code>false</code> otherwise
     */
    public boolean isEmpty() {
        return DEFAULT_RETURN_BOOLEAN;
    }

    /**
     * Returns the number of nodes (subtrees) in this tree;
     *   0 if empty tree.
     * @return the number of nodes (subtrees)
     */
    public int numberOfNodes() {
        return DEFAULT_RETURN_INT;
    }

    /**
     * Leaf predicate.
     * @return <code>true</code> if this is a leaf;
     *         <code>false</code> otherwise.
     * @throws java.lang.NullPointerException if this tree is empty
     */
    public boolean isLeaf() throws NullPointerException {
        return DEFAULT_RETURN_BOOLEAN;
    }

    /**
     * Returns the value of the root of this tree.
     * @return the value of the root
     * @throws java.lang.NullPointerException if this tree is empty
     */
    public T getValue() throws NullPointerException {
        return null;
    }

    /**
     * Returns the left child of this tree.
     * @return the left child; null if no such child
     * @throws java.lang.NullPointerException if this tree is empty
     */
    public BinaryTree<T> getLeftChild() throws NullPointerException {
        return null;
    }

    /**
     * Returns the right child of this tree.
     * @return the right child; null if no such child
     * @throws java.lang.NullPointerException if this tree is empty
     */
    public BinaryTree<T> getRightChild() throws NullPointerException {
        return null;
    }

    /**
     * Modifies the value of the root of this tree.
     * @param value the new value for the root
     * @throws java.lang.NullPointerException if this tree is empty
     */
    public void setValue(final T value) throws NullPointerException {
    }

    /**
     * Replaces the left child of the root of this tree.
     * @param child the new left child for this tree;
     *                  null or empty tree indicates no child
     * @throws java.lang.NullPointerException if this tree is empty
     */
    public void setLeftChild(final BinaryTree<T> child) {
    }

    /**
     * Replaces the right child of the root of this tree.
     * @param child the new right child for this tree;
     *                  null or empty tree indicates no child
     * @throws java.lang.NullPointerException if this tree is empty
     */
    public void setRightChild(final BinaryTree<T> child) {
    }

    /**
     * Determines the number of leaves of this tree.
     * @return the number of leaves
     * @throws java.lang.NullPointerException if this tree is empty
     */
    public int numberOfLeaves() throws NullPointerException {
        return DEFAULT_RETURN_INT;
    }

    /**
     * Determines the height of this tree.
     * The height of a tree is the height of its root,
     * which is the number of edges on the longest downward path
     * between the root and a leaf.
     * @return the height of this tree, -1 if empty
     */
    public final int height() {
        return DEFAULT_RETURN_INT;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * @param obj the reference object with which to compare
     * @return true if and only if
     *  <ul>
     *    <li>both are non-null</li>
     *    <li>both have the same number of subtrees</li>
     *    <li>both are the same height</li>
     *    <li>if non-empty, both have equal root values</li>
     *    <li>if left-children are present, they are equal to each other</li>
     *    <li>if right-children are present, they are equal to each other</li>
     *  </ul>
     * @see #hashCode()
     */
    @Override
    public boolean equals(final Object obj) {
        return DEFAULT_RETURN_BOOLEAN;
    }

    /**
     * Returns a hash code value for this tree.
     * @return a hash code value for this tree
     * @see #equals(Object o)
     */
    @Override
    public int hashCode() {
        return DEFAULT_RETURN_INT;
    }

    /**
     * Returns a list of values in the order in which
     *   the nodes would be visited using preorder traversal.
     *   If this tree is empty, returns the empty list.
     * @return values of all nodes in preorder
     */
    public List<T> preorderValues() {
        return null;
    }

    /**
     * Returns a list of values in the order in which
     *   the nodes would be visited using inorder traversal.
     *   If this tree is empty, returns the empty list.
     * @return values of all nodes in inorder
     */
    public List<T> inorderValues() {
        return null;
    }

    /**
     * Returns a list of values in the order in which
     *   the nodes would be visited using postorder traversal.
     *   If this tree is empty, returns the empty list.
     * @return values of all nodes in postorder
     */
    public List<T> postorderValues() {
        return null;
    }

    /**
     * Returns a list of subtrees in the order in which
     *   they would be visited using preorder traversal.
     *   If this tree is empty, returns the empty list.
     * @return all subtrees in preorder
     */
    public List<BinaryTree<T>> preorderSubtrees() {
        return null;
    }

    /**
     * Returns a list of subtrees in the order in which
     *   they would be visited using inorder traversal.
     *   If this tree is empty, returns the empty list.
     * @return all subtrees in inorder
     */
    public List<BinaryTree<T>> inorderSubtrees() {
        return null;
    }

    /**
     * Returns a list of subtrees in the order in which
     *   they would be visited using postorder traversal.
     *   If this tree is empty, returns the empty list.
     * @return all subtrees in postorder
     */
    public List<BinaryTree<T>> postorderSubtrees() {
        return null;
    }

    /**
     * Converts a list of trees into a list of the
     * root values of those trees.
     *   If the parameter is an empty list, returns the empty list.
     *
     * @param <E> the type of values stored by trees in the parameter
     * @param listOfTrees the list of trees from which to extract values
     * @return all root values in the order they appear in the parameter
     */
    public static <E> List<E> values(
            final List<BinaryTree<E>> listOfTrees) {
        return null;
    }

    /**
     * Returns an iterator over the subtrees (nodes) of this tree.
     * @return an iterator over subtrees of this tree
     */
    @Override
    public java.util.Iterator<BinaryTree<T>> iterator() {
        return null;
    }

    /**
     * Renders tree as a non-null and non-empty string.
     * The rendering must include every value of the root of
     * every subtree in the tree.
     * It may include additional characters to provide
     * human-readable results.
     * @return string rendering of this object
     */
    @Override
    public String toString() {
        return null;
    }

    /**
     * Saves this tree to a file.
     * @param filename the name of the file in which to save this tree;
     *                 if null, uses default file name
     * @return <code>true</code> if successful save;
     *         <code>false</code> otherwise
     * @throws java.io.IOException if unexpected IO error
     */
    public final boolean save(final String filename)
            throws java.io.IOException {
        return DEFAULT_RETURN_BOOLEAN;
    }

    /**
     * Restores this tree from a file.
     * <br><em>Postconditions:</em>
     * <blockquote>If successful, previous contents of this tree have
     * been replaced by the contents of the file.
     * If unsuccessful, content of the tree is unchanged.</blockquote>
     * @param filename the name of the file from which to restore this tree;
     *                 if null, uses default file name
     * @return <code>true</code> if successful restore;
     *         <code>false</code> otherwise
     * @throws java.io.IOException if unexpected IO error
     */
    public final boolean restore(final String filename) throws
            java.io.IOException {
        return DEFAULT_RETURN_BOOLEAN;
    }
}
