/**
 * The collected values stored at a HuffmanTree node which include: 
 * Character symbol, Double frequency, and StringOfBits code.
 * 
 * @author Joey Brennan
 * @version 3
 */
public class HuffmanTreeNodeValues {
	/**
	 * the symbol of the node.
	 */
	private Character symbol;
	
	/**
	 * its frequency.
	 */
	private Double frequency;
	
	/**
	 * the huffman code to the node.
	 */
	private StringOfBits code;
	
	/**
	 * Constructor that sets all values to null.
	 */
	public HuffmanTreeNodeValues() {
		symbol = null;
		frequency = null; 
		code = null;	
	}
	
	/**
	 * Fully parameterized constructor.
	 * @param symbol of the node
	 * @param frequency of the node
	 * @param code of the leaf node
	 */
	public HuffmanTreeNodeValues(final Character symbol, 
		   final Double frequency, final StringOfBits code) {
		this.symbol = symbol;
		this.frequency = frequency;
		this.code = code;
	}
	
	/**
	 * Accesses the symbol.
	 * @return the symbol
	 */
	public final Character getSymbol(){
		Character result = this.symbol;
		
		return result;
	}
	
	/**
	 * Accesses the code.
	 * @return the code
	 */
	public final StringOfBits getCode(){
		StringOfBits result = this.code;
		
		return result;
	}
	
	/**
	 * Accesses the frequency.
	 * @return the frequency 
	 */
	public final Double getFrequency(){
		Double result = this.frequency;
		
		return result;
	}
	
	/**
	 * Modifies the symbol.
	 * @param newsymbol - the replacement symbol
	 */
	public final void setSymbol(final Character newsymbol){
		this.symbol = newsymbol;
	}
	
	/**
	 * Modifies the code.
	 * @param newcode  - the replacement code
	 */
	public final void setCode(final StringOfBits newcode){
		this.code = newcode;
	}
	
	/**
	 * modifies the frequency 
	 * @param newfrequency - the replacement frequency
	 */
	public final void setFrequency(final Double newfrequency){
		this.frequency = newfrequency;
	}
	
	/**
	 * Overrides toString in class Object. 
	 */
	public final String toString(){
		String result;
		result = this.symbol + " " + this.frequency + " " + this.code.toString();
				
		return result;
	}
}
