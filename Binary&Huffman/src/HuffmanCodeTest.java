import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Tests the code.
 * 
 * @author Joey
 * @version 2
 */
public class HuffmanCodeTest {

	@Test
	public void testHuffmanCodeString() {
        HuffmanCode hc = new HuffmanCode("HELLO");
        
        
        assert(hc.getCode() != null);
	}

	@Test
	public void testHuffmanCodeHashMapOfCharacterDouble() {
        final String seed = "ROADRUNNER";
        char[]charArray = seed.toCharArray();
        HashMap<Character, Double> freqTable = new HashMap<Character, Double>();
        for (int i = 0; i < seed.length(); i++){
            if (freqTable.containsKey(charArray[i])){
                freqTable.put(charArray[i], freqTable.get(charArray[i]) + 1.0);
            }
            else{
                freqTable.put(charArray[i], 1.0);
            }
        }
 
        for (Map.Entry<Character, Double> entry : freqTable.entrySet()){
            freqTable.put(entry.getKey(), (entry.getValue() / seed.length()));
        }
         
        HuffmanCode hc = new HuffmanCode(freqTable);
        assertNotNull(hc.getCode());
	}

	@Test
	public void testHuffmanCodeMapOfCharacterStringOfBits() {
        HuffmanCode hc = new HuffmanCode(new HashMap<Character, StringOfBits>());
        
        assertNotNull(hc.getCode());
	}

	@Test
	public void testEncode() {
		 HuffmanCode hc = new HuffmanCode("ROADRUNNER");
	        StringOfBits sob = hc.encode("ROADRUNNER");
	        assertEquals("100000011111101110010111010", sob.toString());
	}

	@Test
	public void testDecode() {
        
        HuffmanCode hc1 = new HuffmanCode("ROADRUNNER");
        assertEquals("ROADRUNNER", hc1.decode(new StringOfBits("100000011111101110010111010")));
	}

	@Test
	public void testGetCode() {
		
	}

}
