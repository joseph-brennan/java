import static org.junit.Assert.*;

import org.junit.Test;

public class HuffmanTreeTest {
	private StringOfBits code = new StringOfBits("1");
	private HuffmanTreeNodeValues data1 = new HuffmanTreeNodeValues('a', 0.0, code);
	private HuffmanTreeNodeValues data2 = new HuffmanTreeNodeValues();
    
	private HuffmanTree generateStandardTestTree() {
        return new HuffmanTree(1.0,
                new HuffmanTree('L', 0.4, new StringOfBits("0")), new HuffmanTree(0.6,
                    new HuffmanTree('O', 0.2, new StringOfBits("10")), new HuffmanTree(0.4,
                            new HuffmanTree('H', 0.2, new StringOfBits("110")), new HuffmanTree('E', 0.2, new StringOfBits("111")))));
	}
	
	@Test
	public void testHashCode() {
		
		HuffmanTree hft1 = new HuffmanTree(data1);
		HuffmanTree hft2 = new HuffmanTree(data1);
		
		assertEquals(hft1.hashCode(), hft2.hashCode());
		
	}

	@Test
	public void testEqualsObject() {
        HuffmanTree ht1 = new HuffmanTree(data1);
        HuffmanTree ht2 = new HuffmanTree(data1);
        
         
        assertEquals(ht1.equals(ht2), ht2.equals(ht1));
	}

	@Test
	public void testHuffmanTreeHuffmanTreeNodeValues() {
		
		assertEquals(data1.equals(data1), true);
	}

	@Test
	public void testGetLeftChild() {
        HuffmanTree ht = generateStandardTestTree();
        
        assert (!ht.getLeftChild().equals(null));
        
        assert (!ht.getRightChild().equals(null));
	}

	@Test
	public void testGetRightChild() {
        HuffmanTree ht = generateStandardTestTree();
        
        assert (!ht.getLeftChild().equals(null));
        
        assert (!ht.getRightChild().equals(null));
	}

	@Test
	public void testGetSymbol() {
		HuffmanTree hft1 = new HuffmanTree(data2);
		
		hft1.setSymbol('a');
		
		assertEquals(true, hft1.getSymbol() == 'a');
	}

	@Test
	public void testGetCode() {
		HuffmanTree hft1 = new HuffmanTree(data2);
		
		hft1.setCode(code);
		
		assertEquals(true, hft1.getCode() == code);
	}

	@Test
	public void testGetFrequency() {
		HuffmanTree hft1 = new HuffmanTree(data2);
		
		hft1.setFrequency(0.0);
		
		assertEquals(true, hft1.getFrequency() == 0.0);
	}

	@Test
	public void testSetSymbol() {
		HuffmanTree hft1 = new HuffmanTree(data2);
		
		hft1.setSymbol('a');
		
		assertEquals(true, hft1.getSymbol() == 'a');
	}

	@Test
	public void testSetCode() {
		HuffmanTree hft1 = new HuffmanTree(data2);
		
		hft1.setCode(code);
		
		assertEquals(true, hft1.getCode() == code);
	}

	@Test
	public void testSetFrequency() {
		HuffmanTree hft1 = new HuffmanTree(data2);
		
		hft1.setFrequency(0.0);
		
		assertEquals(true, hft1.getFrequency() == 0.0);
	}

	@Test
	public void testCompareTo() {
		HuffmanTree hft1 = new HuffmanTree(data1);
		
		HuffmanTree hft2 = new HuffmanTree(data1);
		
		assertEquals(true, hft1.compareTo(hft2) == 0);
	}

}
