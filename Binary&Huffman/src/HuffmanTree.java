import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * A HuffmanTree is a specialized BinaryTree used for developing and storing a HuffmanCode. 
 * Note that there is no empty tree constructor.
 *
 * @author Joey Brennan
 * @version 7
 *
 */
public class HuffmanTree extends BinaryTree<HuffmanTreeNodeValues>
	implements Comparable<HuffmanTree> {

	/**
	 * I added this not sure why yet but was in BinarayTree.
	 */
	private static long serialVersionUID = 1L;

	/**
	 * Maximum difference to accept two double values as equal.
	 */
	public static final double EPSILON = 0;

	/**
	 * holds the nodeValues from that class.
	 */
	private HuffmanTreeNodeValues nodeValue;

	/**
	 * the leafs of the tree.
	 */
	private HuffmanTree leftChild, rightChild;
	
	
	/**
	 * Constructor for leaf node.
	 * @param data - an object containing the symbol, frequency, 
	 * and code for this node
	 */
	public HuffmanTree(final HuffmanTreeNodeValues data) {
		this.nodeValue = data;
	}

	/**
	 * Constructor for internal node.
	 * @param data - an object containing the symbol, code, and 
	 * frequency for this node
	 * @param leftChild - the left child for this node
	 * @param rightChild - the right child for this node
	 */
	public HuffmanTree(final HuffmanTreeNodeValues data,
           final HuffmanTree leftChild,
           final HuffmanTree rightChild) {

		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.nodeValue = data;
	}

	/**
	 * Parameterized constructor for leaf node.
	 * @param symbol - the symbol stored in this node
	 * @param frequency - the frequency stored in this node
	 * @param code - the code stored in this node
	 */
	public HuffmanTree( final Character symbol,
           final Double frequency,
           final StringOfBits code) {
	
		this.nodeValue = new HuffmanTreeNodeValues(symbol, frequency, code);
	}

	/**
	 * Fully parameterized constructor. 
	 *
	 * @param symbol - the symbol stored in this node
	 * @param frequency - the frequency stored in this node
	 * @param code - the code stored in this node
	 * @param leftChild - the left child for this node
	 * @param rightChild - the right child for this node
	 */
	public HuffmanTree(final Character symbol,
           final Double frequency,
           final StringOfBits code,
           final HuffmanTree leftChild,
           final HuffmanTree rightChild) {

		this.nodeValue = new HuffmanTreeNodeValues(symbol, frequency, code);
		this.leftChild = leftChild;
		this.rightChild = rightChild;

	}
	
	/**
	 * Frequency and children constructor; 
	 * useful for internal nodes. 
	 * Sets symbol and code to null.
	 * @param frequency - the frequency stored in this node
	 * @param leftChild - the left child of this node
	 * @param rightChild - the right child of this node
	 */
	public HuffmanTree(final Double frequency,
           final HuffmanTree leftChild,
           final HuffmanTree rightChild){
		
		this.nodeValue = new HuffmanTreeNodeValues(null, frequency, null);
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	/**
	 * Overrides: getLeftChild in class BinaryTree<HuffmanTreeNodeValues>.
	 * @return the left child; null if no such child
	 */
	public final HuffmanTree getLeftChild() {
		HuffmanTree result;
		
		result = leftChild;
		
		return result;
	}
	
	/**
	 * Overrides: getRightChild in class BinaryTree<HuffmanTreeNodeValues>.
	 * @return the right child; null if no such child
	 */
	public final HuffmanTree getRightChild() {
		HuffmanTree result;
		
		result = rightChild;
		
		return result;
	}
	
	/**
	 * Retrieve the symbol stored in this root.
	 * @return the symbol stored in this root
	 */
	public final Character getSymbol() {
		Character result;
		result = nodeValue.getSymbol();
		
		return result;
	}
	
	/**
	 * Retrieve the code stored in this root.
	 * @return the code stored in this root
	 */
	public final StringOfBits getCode() {
		StringOfBits result;
		
		result = nodeValue.getCode();
		
		return result;
	}
	
	/**
	 * Retrieve the frequency stored in this root.
	 * @return the frequency stored in this root
	 */
	public final Double getFrequency() {
		Double result;
		
		result = nodeValue.getFrequency();
		
		return result;
	}
	
	/**
	 * Store the given parameter as the symbol of this tree root.
	 * @param symbol - the new symbol for this root
	 */
	public final void setSymbol(final Character symbol){
		this.nodeValue.setSymbol(symbol);
	}
	
	/**
	 * Store the given parameter as the code of this tree root.
	 * @param code - the new code for this root
	 */
	public final void setCode(final StringOfBits code){
		this.nodeValue.setCode(code);
	}
	
	/**
	 * Store the given parameter as the frequency of this tree root.
	 * @param frequency - the new frequency for this root
	 */
	public final  void setFrequency(final Double frequency){
		this.nodeValue.setFrequency(frequency);
	}
	
	/**
	 * Checks the current left and right leaf are not null.
	 * @return true if not null.
	 */
    private boolean isHtLeaf() {
        return !(getLeftChild() != null && getRightChild() != null);
    }
    
    /**
     * Makes more sence to have the tree built in the tree class.
     * Originally in code class
     * 
     * @param freqTable table to build tree from 
     * @return the compleated tree
     */
    final HuffmanTree makeTree(final HashMap<Character, Double> freqTable) {
        PriorityQueue<HuffmanTree> singleNodes  =  new PriorityQueue<HuffmanTree>();
        
        PriorityQueue<HuffmanTree> tree  =  new PriorityQueue<HuffmanTree>();
        
        StringBuffer sb  =  new StringBuffer();
        
        HuffmanTree leftLow,  rightLow,  node,  toReturn;
 
        for (Map.Entry<Character, Double> entry : freqTable.entrySet()) {

            singleNodes.add(new HuffmanTree(new HuffmanTreeNodeValues(entry.getKey(), entry.getValue(), new StringOfBits())));
        }
 
        while (!singleNodes.isEmpty() || tree.size() > 1) {
            if (tree.isEmpty()) {

                leftLow  =  singleNodes.poll();
                rightLow  =  singleNodes.poll();

                node  =  new HuffmanTree(leftLow.getFrequency() + rightLow.getFrequency(), leftLow, rightLow);
                tree.add(node);
            }
            else if (singleNodes.size() >= 2) {

                if (singleNodes.peek().getFrequency() < tree.peek().getFrequency()) {
                    leftLow  =  singleNodes.poll();
 
                    if (singleNodes.peek().getFrequency() < tree.peek().getFrequency()) {
                        rightLow  =  singleNodes.poll();
                    }
                    else {
                        rightLow  =  tree.poll();
                    }
                }
                else {
                    leftLow  =  tree.poll();
 
                    if (!tree.isEmpty()) {
                        if (singleNodes.peek().getFrequency() < tree.peek().getFrequency()) {
                            rightLow  =  singleNodes.poll();
                        }
                        else {
                            rightLow  =  tree.poll();
                        }
                    }
                    else {
                        rightLow  =  singleNodes.poll();
                    }
                }

                node  =  new HuffmanTree(leftLow.getFrequency() + rightLow.getFrequency(), leftLow, rightLow);
                tree.add(node);
            }
            else if (singleNodes.size() == 1) {

                if (singleNodes.peek().getFrequency() < tree.peek().getFrequency()) {
                    leftLow  =  singleNodes.poll();
                    rightLow  =  tree.poll();
                }
                else {
                    leftLow  =  tree.poll();
                     
                    if (singleNodes.peek().getFrequency() < tree.peek().getFrequency()) {
                        rightLow  =  singleNodes.poll();
                    }
                    else {
                        rightLow  =  tree.poll();
                    }
                }

                node  =  new HuffmanTree(leftLow.getFrequency() + rightLow.getFrequency(), leftLow, rightLow);
                tree.add(node);
            }
            
            if (singleNodes.isEmpty() && tree.size() > 1) {

                HuffmanTree temp  =  tree.poll();
                if (temp.getFrequency() < tree.peek().getFrequency()) {
                    leftLow  =  temp;
                    rightLow  =  tree.poll();
                }
                else {
                    leftLow  =  tree.poll();
                    rightLow  =  temp;
                }

                node  =  new HuffmanTree(leftLow.getFrequency() + rightLow.getFrequency(), leftLow, rightLow);
                tree.add(node);
            }
        }
         

        toReturn  =   tree.poll();

        assignCode(toReturn,  sb);
         
        return toReturn;
    }
     
     /**
      * Assigns the Huffman code to the root of the tree.
      * 
      * @param root the root getting the code
      * @param sob the String of Bits that represents the code
      */
     private void assignCode(final HuffmanTree root, final StringBuffer prefix) {
        if (root.isHtLeaf()) {
            root.setCode(new StringOfBits(prefix.toString()));
        }
        else {
                //traverse left
                prefix.append("0");
                root.getLeftChild().assignCode(root.getLeftChild(), prefix);
                prefix.deleteCharAt(prefix.length() - 1);
                
                //traverse right
                prefix.append("1");
                root.getRightChild().assignCode(root.getRightChild(), prefix);
                prefix.deleteCharAt(prefix.length() - 1);
        }
    }
     
    /**
     * gets the leaf node from the tree.
     * 
     * @return the leaf node of the tree
     */
    final List<HuffmanTree> getLeafNodes() {
       List<HuffmanTree> leafList = new ArrayList<HuffmanTree>();
 
       if (this.isHtLeaf()) {

           leafList.add(this);
 
           return leafList;
       }
 
       if (this.getLeftChild() != null) {
           leafList.addAll(this.getLeftChild().getLeafNodes());
       }
        
       if (this.getRightChild() != null) {
           leafList.addAll(this.getRightChild().getLeafNodes());
       }
         
       return leafList;
    }
     
	
	/**
	 * Overrides: equals in class BinaryTree<HuffmanTreeNodeValues>.
	 * @param o - the object to check for equality
	 * @return true if both the symbol and the frequency agree; false otherwise
	 * 
	 */
	public final boolean equals(final Object o) {
        if ((o == null) || !(o.getClass() != this.getClass())) {
            return false;
        }
        return compareTrees(this, (HuffmanTree) o);
	}
	
	/**
	 * Returns a hash code value for the object. Supported for the benefit of hash-tables.
	 * Overrides: hashCode in class BinaryTree<HuffmanTreeNodeValues>
	 * @return a hash code value for this object.
	 * 
	 */
	public final int hashCode() {
		 int mycode = 1;
	        if (null != this.nodeValue) {
	            mycode = this.nodeValue.hashCode();
	        }
	        
	        if (null == this.leftChild) {
	            mycode += 2;
	        }
	        else {
	            mycode += this.leftChild.hashCode();
	        }
	        
	        if (null == this.rightChild) {
	            mycode += 2;
	        }
	        else {
	            mycode += this.rightChild.hashCode();
	        }
	        
	        return mycode;
	}
	
	/**
	 * Compares this HuffmanTree with the parameter for order. 
	 * Returns a negative integer, zero, or a positive integer 
	 * as this object is less than, equal to, or greater than the specified object. 
	 * Comparison considers frequency only; 
	 * null is considered to be lower than any other frequency value.
	 * 
     *Ensures that sgn(x.compareTo(y)) == -sgn(y.compareTo(x)) for all x and y. 
     *(This implies that x.compareTo(y) 
     *must throw an exception if and only if y.compareTo(x) throws an exception.)
     *
     *The relation is transitive: (x.compareTo(y)>0 && y.compareTo(z)>0) implies x.compareTo(z)>0.
     *Ensures that x.compareTo(y)==0 
     *implies that sgn(x.compareTo(z)) == sgn(y.compareTo(z)), for all z.
     *
     *The natural ordering is consistent with equals, that is, (x.compareTo(y)==0) == (x.equals(y)).
     *In the foregoing description, the notation sgn(expression) 
     *
     *designates the mathematical signum function, which is defined to return one of
     * -1, 0, or 1 according to whether the value of expression is negative, zero or positive.
     * 
     * @param ht - the object to be compared
     * @return a negative integer, zero, or a positive integer as this object is less than, 
     * equal to, or greater than the specified object.
	 */
	public final int compareTo(final HuffmanTree ht) {
        if (ht.getFrequency() < this.getFrequency()) {
            return 1;
        }
        else if (this.getFrequency() == ht.getFrequency()) {
            return 0;
        }
        else {
            return -1;
        }
    }
	
	/**
	 * Compares the trees. and their parts 
	 * 
	 * @param ht1 first tree
	 * @param ht2 second tree
	 * 
	 * @return true/false return
	 */
    private boolean compareTrees(final HuffmanTree ht1,
            					 final HuffmanTree ht2) {
        if (ht1 == null || ht2 == null) {

        	return false;
        }
        
        if (Math.abs(ht1.getFrequency() - ht2.getFrequency()) > EPSILON) {

        	return false;
        }
        
        if (!ht1.getFrequency().equals(ht2.getFrequency())) {

        	return false;
        }
        
        if (ht1.getLeftChild() == null) {
            if (ht2.getLeftChild() != null) {
                
            	return false;
            }
        } else if (ht2.getLeftChild() == null) {
            
        	return false;
        }
        
        if (ht1.getLeftChild() != null
            && !compareTrees(ht1.getLeftChild(), ht2.getLeftChild())) {

        	return false;
        }
        
        if (ht1.getRightChild() == null) {
            if (ht2.getRightChild() != null) {
               
            	return false;
            }
        }
        else if (ht2.getRightChild() == null) {
            return false;
        }
        
        if (ht1.getRightChild() != null
        	&& !compareTrees(ht1.getRightChild(), ht2.getRightChild())) {
        	
        	return false;
        }
        
        return true;
    }
}
	
