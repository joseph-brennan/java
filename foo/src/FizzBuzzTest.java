import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzTest {

	@Test
	public void test() {
		fail("Not yet implemented"); // TODO
	}
	
	public void gameTest() {
		FizzBuzz fb = new FizzBuzz(19, 32);
		String test[] = new String ["19", "Buzz", "Fizz", "22", "23", "Fizz", "Buzz", "26", "Fizz", "28", "29", "FizzBuzz", "31", "32"];
		assertEquals(true, fb = test);
	}
}
