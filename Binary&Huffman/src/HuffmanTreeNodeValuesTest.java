import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test of HuffmanTreeNodeValues
 * 
 * @author Joey Brennan
 * @version 2
 */

public class HuffmanTreeNodeValuesTest {

	@Test
	public void testHuffmanTreeNodeValues() {
		HuffmanTreeNodeValues htnv = new HuffmanTreeNodeValues();
		
		assertEquals(true, htnv.getFrequency() == null);
		assertEquals(true, htnv.getCode() == null);
		assertEquals(true, htnv.getSymbol() == null);
	}

	@Test
	public void testHuffmanTreeNodeValuesCharacterDoubleStringOfBits() {
		Character symbol = 'a';
		Double frequency = 0.;
		StringOfBits code = new StringOfBits("1"); 
		
		HuffmanTreeNodeValues htnv = new HuffmanTreeNodeValues(symbol, frequency, code);
		
		assertEquals(true, htnv.getFrequency() == 0.);
		assertEquals(htnv.getCode().toString(), "1");
		assertEquals(true, htnv.getSymbol() == 'a');
	}

	@Test
	public void testGetSymbol() {
		HuffmanTreeNodeValues htnv = new HuffmanTreeNodeValues();
		htnv.setSymbol('a');
		
		assertEquals(true, htnv.getSymbol() == 'a');
	}

	@Test
	public void testGetCode() {
		HuffmanTreeNodeValues htnv = new HuffmanTreeNodeValues();
		htnv.setCode(null);
		
		assertEquals(true, htnv.getCode() == null);
	}

	@Test
	public void testGetFrequency() {
		HuffmanTreeNodeValues htnv = new HuffmanTreeNodeValues();
		htnv.setFrequency(0.);
		
		assertEquals(true, htnv.getFrequency() == 0.);
	}

	@Test
	public void testSetSymbol() {
		HuffmanTreeNodeValues htnv = new HuffmanTreeNodeValues();
		
		htnv.setSymbol('a');
		
		assertEquals(true, htnv.getSymbol() == 'a');
	}

	@Test
	public void testSetCode() {
		StringOfBits code = new StringOfBits("1010");
		
		HuffmanTreeNodeValues htnv = new HuffmanTreeNodeValues();
		
		htnv.setCode(code);
		
		assertEquals(true, htnv.getCode() == code);
	}

	@Test
	public void testSetFrequency() {
		HuffmanTreeNodeValues htnv = new HuffmanTreeNodeValues();
		
		htnv.setFrequency(0.);
		
		assertEquals(true, htnv.getFrequency() == 0.);
	}

	@Test
	public void testToString() {
		Character symbol = 'a';
		Double frequency = 0.;
		StringOfBits code = new StringOfBits("1"); 
		
		HuffmanTreeNodeValues htnv = new HuffmanTreeNodeValues(symbol, frequency, code);
		
		assertEquals(htnv.toString(), "a 0.0 1");
	}

}
