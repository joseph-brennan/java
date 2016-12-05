
public class FizzBuzz {

	public FizzBuzz(int start, int end) {
		int i = start;
		int legnth = end;
		String[] gameResults;
		
		if(i < legnth){
			gameResults = new String[end - start];
		}
		
		for(; i < legnth; i++) {
			if (i % 3 == 0){
				gameResults[i] = "Fizz";
			}
			
			if(i % 5 == 0) {
				gameResults[i] = "Buzz";
			}
			
			if(i % 3 == 0 && i % 5 == 0) {
				gameResults[i] = "FizzBuzz";
			}
			
			else{
				gameResults[i] = "the number";
			}
		}
		
	}
}
