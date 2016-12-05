import java.util.Random;
/*Three different positive whole numbers are chosen at random; 
  a different one is written on each of three slips of paper.

The slips are then placed face down on a table.

Your objective is to choose the slip upon which is written the largest number.

Here are the rules expressed as a sequence of events:

You can turn over any one slip of paper and look at the amount written on it.
If (for any reason) you think this is the largest number of the three, you’re done; you keep that slip
and the game play is over.
Otherwise you discard it and turn over a second slip.
Again, if you think this is the one with the biggest number, you keep this one and the game play is over.
If you don’t, you discard that one too and you keep the third slip.

Once the game play is over, all three slips are turned face-up and examined to determine 
if you have chosen the slip with the largest number.
 * 
 */
public class Slip {
	private int value;


	// Constructor that sets value to a random integer 
	// in the range 0..Integer.MAX_VALUE.
	public Slip() {
		Random x;
		
		x = new Random();
		
		this.value = x.nextInt(Integer.MAX_VALUE);
		
	}

	
	//Constructor that sets value to a random integer in the specified range.
	public Slip(int minimum, int maximum) {
		Random y = new Random();
		
		int range = (maximum - minimum) + 1;
		
		this.value = y.nextInt(range) + minimum;
	}
	

	public int value() {		
		return this.value;
		
	}
}


