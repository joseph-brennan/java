import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of Huffman coding.
 * An instance of stores a code used for subsequent 
 * encoding and decoding of strings.
 *
 * @author Joey Brennan
 * @version 7
 */
public class HuffmanCode {
	/**
	 * the map of the encoded string.
	 */
	private Map<Character, StringOfBits> encoding;
	
	/**
	 * map of the decoded string.
	 */
	private Map<StringOfBits, Character> decoding;

	/**
	 * Creates a Huffman code for a given seed string.
	 * @param seed - the string from which the code is generated
	 */
	public HuffmanCode(final String seed) {
		HashMap<Character, Double> freqTable = getFreqTable(seed);
        
		HuffmanTree tree = new HuffmanTree(new HuffmanTreeNodeValues());
        
		tree = tree.makeTree(freqTable);

		this.encoding = createHMap(tree);
        this.decoding = createDecoding();
	}
	
	/**
	 * Creates a Huffman code for a given frequency table.
	 * @param table the symbol frequency table from which the code is generated
	 */
	public HuffmanCode(final HashMap<Character, Double> table) {
        HuffmanTree tree = new HuffmanTree(new HuffmanTreeNodeValues());
        
        tree = tree.makeTree(table);
        
        this.encoding = createHMap(tree);
        
        this.decoding = createDecoding();
	}
	
	/**
	 * Creates a Huffman code for a given mapping of symbols to codes.
	 * @param hmap - the mapping from symbols to their encodings
	 */
	public HuffmanCode(final Map<Character, StringOfBits> hmap) {
		this.encoding =  hmap;
		this.decoding = createDecoding();
	}
	
	/**
	 * Encodes a string using the Huffman code of this object.
	 * @param inputString - the string to be encoded
	 * @return the compressed encoding of the parameter
	 */
	public final StringOfBits encode(final String inputString) {
		StringOfBits sob = new StringOfBits();
        
		char[] characters = inputString.toCharArray();
        
		for (int i = 0; i < characters.length; i++) {

            sob.append(this.encoding.get(characters[i]));
        }
        return sob;
	}
	
	/**
	 * Decodes a bit string (0s and 1s) using the Huffman code of this object.
	 * @param encodedString - the string to be decoded
	 * @return the decoded version of the parameter
	 */
	public final String decode(final StringOfBits encodedString) {
		String encodedSubString  =  encodedString.toString();
		
		Map<StringOfBits, Character> tempdecodings  =  this.decoding;

    	return decode(encodedSubString, tempdecodings);
	}
	
	/**
	 * Decodes the encoded String from the String.
	 * 
	 * @param encodedSubString the String of the from this.encoded
	 * @param tempdecodings the constructed decode map
	 * @return the decoded String
	 */
	private String decode(String encodedSubString, 
				   final Map<StringOfBits, Character> tempdecodings) {
		String decoded  =  new String();
		
		if (encodedSubString.length() > 0) {
			for (Map.Entry<StringOfBits, Character> entry : tempdecodings.entrySet()) {
				
				if (encodedSubString.length() >= entry.getKey().length()) {

					if (entry.getKey().toString().equals(encodedSubString.substring(0,  entry.getKey().length()))) {
						decoded  =  entry.getValue().toString();
						
						encodedSubString  =  encodedSubString.substring(entry.getKey().length(), encodedSubString.length());
						
						return decoded + decode(encodedSubString, tempdecodings);
					}
				}
			}
        //no symbol found for  decoding insert empty space
			if (decoded.length() == 0) {
				decoded  =  " ";
				
				encodedSubString = encodedSubString.substring(1,  encodedSubString.length());
				
				return decoded + decode(encodedSubString, tempdecodings);
			}
		}
		return decoded;
	}
	
	/**
	 * Returns the mapping of symbols to codes for this object.
	 * @return this Huffman code as a map
	 */
	public final Map<Character, StringOfBits> getCode() {

		return this.encoding;
	}

	/**
	 * Creates the frequency table.
	 * @param seed string input
	 * @return the frequency of the chars
	 */
	private HashMap<Character, Double> getFreqTable(final String seed) {
		char[]charArray  =  seed.toCharArray();
	    	HashMap<Character, Double> freqTable = new HashMap<Character, Double>();
	        for (int i = 0; i < seed.length(); i++) {
	            if (freqTable.containsKey(charArray[i])) {
	                
	            	freqTable.replace(charArray[i],  
	                freqTable.get(charArray[i]) + 1.0);
	            	
	            } else {
	                freqTable.put(charArray[i],  1.0);
	            }
	        }
	 
	        for (Map.Entry<Character, Double> entry : freqTable.entrySet()) {
	            freqTable.replace(entry.getKey(), 
	                      (entry.getValue() / seed.length()));
	        }
		
		return freqTable;
	}
	
	/**
	 * Creates the hash-map for the tree.
	 * 
	 * @param htree the tree to create the map from
	 * @return - the hash map
	 */
    private Map<Character, StringOfBits> createHMap(final HuffmanTree htree) {
        Map<Character, StringOfBits> hmap = new HashMap<Character, StringOfBits>();
        for (HuffmanTree leaf : htree.getLeafNodes()){
            hmap.put(leaf.getSymbol(), leaf.getCode());
        }
         
        return hmap;
	}
	
    /**
     * Initializes the decoded tree from the code of the current tree.
     * 
     * @return the decoded tree
     */
    private Map<StringOfBits, Character> createDecoding() {
    	Map<Character, StringOfBits> encoding  =  this.getCode();
        Map<StringOfBits, Character> tempdecode  =  new HashMap<StringOfBits, Character>();
 
        for (Map.Entry<Character, StringOfBits> entry : encoding.entrySet()) {
            tempdecode.put(entry.getValue(), entry.getKey());
        }
 
        return tempdecode;
    }

}
