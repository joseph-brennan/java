import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a string of bit values (0 or 1).
 * 
 * @author Joey Brennan
 * @version 4
 *
 */
public class StringOfBits {
	/**
	 * bitString holds the current string.
	 */
	private ArrayList<String> bitString;
	
	/**
	 * allows to expand the size of bitString beyond just .add.
	 */
	private ArrayList<String> temp;
	
	/**
	Constructs the empty bit string; length() == 0.
	*/
	public StringOfBits() {
		bitString = new ArrayList<String>(0);
	}
	
	/**
	 * Constructs a bit string from a sequence of '0' and '1' characters.
	 * @param chars - the sequence to convert into bits 
	 */
	public StringOfBits(final CharSequence chars) {
		int size = chars.length();
		
		bitString = new ArrayList<String>(size);
		
		for (int i = 0; i < size; i++) {
			if (chars.charAt(i) == '1') {
				bitString.add("1");
			}
			
			if (chars.charAt(i) == '0') {
				bitString.add("0");
			}
		}
		
	}
	
	/**
	 * copy constructor.
	 * @param sb - the object to be cloned
	 */
	public StringOfBits(final StringOfBits sb) {
		String tem;
		
		tem = sb.toString();
		
		int size = tem.length();
		
		bitString = new ArrayList<String>(size);
		
		for (int i = 0; i < size; i++) {
			if (tem.charAt(i) == '1') {
				bitString.add("1");
			}
			
			if (tem.charAt(i) == '0') {
				bitString.add("0");
			}
		}
	}
	
	/**
	 * 
	 * @return the number of bits in this string
	 */
	public final int length() {
		return bitString.size();
	}
	/**
	 * appends.
	 * @param c - char input
	 * @return a reference to this bit string
	 */
	public final StringOfBits append(final char c) {
				
		if (c == '1') {
			bitString.add("1");
		}
		
		if (c == '0') {
			bitString.add("0");
		}
		
		return this;
	}
	
	/**
	 * 
	 * @param b - boolean value
	 * @return a reference to this bit string
	 */
	public final StringOfBits append(final boolean b) {
		if (b == true) {
			bitString.add("1");
		}
		
		if (b == false) {
			bitString.add("0");
		}
		
		return this;
	}
	
	/**
	 * 
	 * @param i input int
	 * @return a reference to this bit string
	 */
	public final StringOfBits append(final int i) {
		if (i == 1) {
			bitString.add("1");
		}
		
		if (i == 0) {
			bitString.add("0");
		}
		
		return this;
	}
	
	/**
	 * 
	 * @param str - input CharSequence
	 * @return a reference to this bit string
	 */
	public final StringOfBits append(final CharSequence str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				bitString.add("1");
			}
			
			if (str.charAt(i) == '0') {
				bitString.add("0");
			}
		}
		
		return this;
	}
	
	/**
	 * 
	 * @param bitstr a bit string to be appended
	 * @return a reference to this bit string
	 */
	public final StringOfBits append(final StringOfBits bitstr) {
		String tem;
		
		tem = bitstr.toString();
		
		for (int i = 0; i < tem.length(); i++) {
			if (tem.charAt(i) == '1') {
				bitString.add("1");
			}
			else {
				bitString.add("0");
			}
		}
		
		return this;
	}
	
	/**
	 * 
	 * @param index - the index of the desired bit value
	 * @throws IndexOutOfBoundsException - if index is negative or greater than or equal to length()
	 * @return the char value at the specified index
	 */
	public final char charAt(final int index) {
		String name;
		char value;
		
		if (index < 0 || index >= length()) {
			throw new IndexOutOfBoundsException();
		}
		
		name = bitString.get(index);
		value = name.charAt(0);
		
		return value;
	}
	
	/**
	 * 
	 * @param index - the index of the desired bit value
	 * @return an int value corresponding to specified index (0 == 0; 1 == 1)
	 * @throws IndexOutOfBoundsException - if index is negative or greater than or equal to length()
	 */
	public final int intAt(final int index) {
		String name;
		int value;
		
		if (index < 0 || index >= length()) {
			throw new IndexOutOfBoundsException();
		}
		
		name = bitString.get(index);
		value = Integer.parseInt(name);
		
		return value;
	}
	
	/**
	 * 
	 * @param index - the index of the desired bit value
	 * @return the boolean value at the specified index (0 == false; 1 == true)
	 * @throws IndexOutOfBoundsException - if index is negative or greater than or equal to length()
	 */
	public final boolean booleanAt(final int index) {
		String name;

		if (index < 0 | index >= length()) {
			throw new IndexOutOfBoundsException();
		}
		
		name = bitString.get(index);

		return name == "1";
	}
	
	/**
	 * 
	 * @param index - the index of the bit to modify
	 * @param c - the new value ('0' == 0; '1' == 1)
	 * 
	 */
	public final void setBitAt(final int index, final char c) {
		tempFill(index);

		if (c == '1') {
			temp.add(index, "1");
		}

		if (c == '0') {
			temp.add(index, "0");
		}

		bitString = temp;
	}
	
	/**
	 * 
	 * @param index - the index of the bit to modify
	 * @param i - the new value ('0' == 0; '1' == 1)
	 *  
	 */
	public final void setBitAt(final int index, final int i) {
		tempFill(index);

		if (i == 1) {
			temp.add(index, "1");
		}

		if (i == 0) {
			temp.add(index, "0");
		}

		bitString = temp;
	}
	
	/**
	 * 
	 * @param index - the index of the bit to modify
	 * @param b - the new value ('0' == 0; '1' == 1)
	 */
	public final void setBitAt(final int index, final boolean b) {
		tempFill(index);

		if (b == true) {
			temp.add(index, "1");
		}

		if (b == false) {
			temp.add(index, "0");
		}

		bitString = temp;
	}

	/**
	 * Overrides toString in class Object.
	 */
	public final String toString() {
		String result = "";

		for (int i = 0; i < length(); i++) {
			result += bitString.get(i);
		}

		return result;
	}

	/**
	 * Private method that initializes the temp ArrayList.
	 * @param index - value location
	 */
	private void tempFill( final int index) {
		temp = new ArrayList<String>(Collections.nCopies(index, "0"));


		if (bitString.size() != 0) {
			for (int j = 0; j > bitString.size(); j++) {
				temp.add(j, bitString.get(j));
			}
		}
	}
}
