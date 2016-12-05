import static org.junit.Assert.*;

/**
 * testing StringOfBits
 * 
 * @author Joey Brennan
 * @version 2
 *
 */

import org.junit.Test;
/**
 * testing the StringOfBits class
 * 
 * @author Joey
 *
 */
public class StringOfBitsTest {

	@Test
	public void testStringOfBits() {
		StringOfBits sob = new StringOfBits();
		
		assertEquals(true, sob.length() == 0);
	}

	@Test
	public void testStringOfBitsCharSequence() {
		CharSequence chars = "1010";
		
		StringOfBits sob = new StringOfBits(chars);
		
		assertEquals(true, sob.length() == 4);
	}

	@Test
	public void testStringOfBitsStringOfBits() {
		StringOfBits sb = new StringOfBits("1010");
		StringOfBits sob = new StringOfBits(sb);
		
		
		assertEquals(true, sob.length() == 4);
	}

	@Test
	public void testLength() {
		StringOfBits sob = new StringOfBits();
		StringOfBits sob1 = new StringOfBits("101010");
		
		assertEquals(sob1.length(), 6);
		assertEquals(true, sob.length() == 0);
	}

	@Test
	public void testAppendChar() {
		char a = '1';
		
		StringOfBits sob = new StringOfBits();
		StringOfBits sob1 = new StringOfBits();
		
		sob.append(a);
		
		sob1.append(a);
		sob1.append('0');
		sob1.append(a);
		
		assertEquals(sob.toString(), "1");
		assertEquals(sob1.toString(), "101");
	}

	@Test
	public void testAppendBoolean() {
		StringOfBits sob = new StringOfBits();
		StringOfBits sob1 = new StringOfBits();
		
		sob.append(true);
		
		sob1.append(true);
		sob1.append(false);
		sob1.append(true);
		
		assertEquals(sob.toString(), "1");
		assertEquals(sob1.toString(), "101");
		
	}

	@Test
	public void testAppendInt() {
		StringOfBits sob = new StringOfBits();
		StringOfBits sob1 = new StringOfBits();
		
		sob.append(0);
		
		sob1.append(1);
		sob1.append(0);
		sob1.append(1);
		
		assertEquals(true, sob.intAt(0) == 0);
		assertEquals(sob1.toString(), "101");
	}

	@Test
	public void testAppendCharSequence() {
		StringOfBits sob = new StringOfBits();
		StringOfBits sob1 = new StringOfBits();
		
		CharSequence str = "1";
		CharSequence str1 = "10101";
		
		sob.append(str);
		sob1.append(str1);
		
		assertEquals(true, sob.length() == 1);
		assertEquals(sob1.length(), 5);
		assertEquals(sob1.toString(), "10101");
	}

	@Test
	public void testAppendStringOfBits() {
		StringOfBits sob = new StringOfBits("101");
		StringOfBits bitstr = new StringOfBits("011");
		
		sob.append(bitstr);
		
		assertEquals(sob.toString(), "101011");
		
	}

	@Test
	public void testCharAt() {
		StringOfBits sob = new StringOfBits("10000");
		
		sob.append('1');
		
		assertEquals(true, sob.charAt(0) == '1');
		assertEquals(sob.charAt(2), '0');
	}

	@Test
	public void testIntAt() {
		StringOfBits sob = new StringOfBits("0 1 1");
		
		sob.append(0);
		
		assertEquals(true, sob.intAt(0) == 0);
		assertEquals(sob.intAt(1), 1);
	}

	@Test
	public void testBooleanAt() {
		StringOfBits sob = new StringOfBits("1010");
		
		sob.append(true);
		
		assertEquals(true, sob.booleanAt(0) == true);
	}

	@Test
	public void testSetBitAtIntChar() {
		StringOfBits sob = new StringOfBits("0000");
		
		sob.setBitAt(1, '1');
		
		assertEquals(true, sob.charAt(1) == '1');
	}

	@Test
	public void testSetBitAtIntInt() {
		StringOfBits sob = new StringOfBits();
		
		sob.setBitAt(2, 0);
		
		assertEquals(true, sob.intAt(2) == 0);
	}

	@Test
	public void testSetBitAtIntBoolean() {
		StringOfBits sob = new StringOfBits();

		sob.setBitAt(0, true);

		assertEquals(true, sob.booleanAt(0) == true);
	}

	@Test
	public void testToString() {
		StringOfBits sob = new StringOfBits("10 1010101010101");

		assertEquals(sob.toString(), "101010101010101");
	}

}
