/**
 * write a description of class FibStuff here.
 * @author (Joey Brennan)
 * @version 
*/
public class fibStuff {
	public static final int Max_T = 100;
	
	static long[] memo = new long[Max_T];
	/**
	 * Determines the specified number in the Fibonacci sequence
	 * @param t the index desired 
	 * @return the t-th Fibonacci number 
	 */
	
	static long fib(int t){
		if (t <= 0)
			return 0;
		
		if (t == 1)
			return 1;
		if (memo[t] == 0) {
			
			memo[t] = fib(t - 1) + fib(t - 2);
		}
		
		return memo[t];
	}
	
	public static void main (String[] args){
		for(int i = 0; i < Max_T; i++){
			System.out.println(fib(i));
		}
	}
}
