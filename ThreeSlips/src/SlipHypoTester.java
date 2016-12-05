import java.util.EnumMap;
import java.util.Map;

//Three slip problem simulation to test hypotheses.

public class SlipHypoTester {

	//The standard number of slips used in the game. 
	//For the three-slip game this value is 3.
	final static int STANDARD_NUMBER_OF_SLIPS = 3;
	private int numOfSlips;
	private Slip[] slipPile;
	private int chosenValue;
	private int maxValue;
	private long counter;
	
	//Run simulation and display results.
	public static void main(java.lang.String[] args){
		Map <ThreeSlipStrategy, Long> results = new EnumMap <ThreeSlipStrategy, Long>
		(ThreeSlipStrategy.class);
		
		long numberOfRounds = 10000L;
		
		SlipHypoTester game1 = new SlipHypoTester(3);
		SlipHypoTester game2 = new SlipHypoTester();
		SlipHypoTester game3 = new SlipHypoTester();
		
		results = game1.simulatePlay(numberOfRounds);
		game1.printResults(results, numberOfRounds);
		
		results = game2.simulatePlay(numberOfRounds);
		game2.printResults(results, numberOfRounds);
		
		for(int iMax = 10; iMax > 5; iMax--) {
			for(int jMin = 0; jMin < 5; jMin++) {
				
				results = game3.simulatePlay(numberOfRounds, jMin, iMax);
				game3.printResults(results, numberOfRounds);
			
			}
		}
		
		
	}
	
	//Initialize with the standard number of slips.
	public SlipHypoTester(){
		this(STANDARD_NUMBER_OF_SLIPS);
	}
	
	
	//Initialize with a given number of slips.
	//Sets up the slips and resets the tallies.
	public SlipHypoTester(int numslips){
		this.numOfSlips = numslips;
		
		slipPile = new Slip [numOfSlips];
		//numslips the number of slips to use for this simulation
	}
	
	//Reset environment and simulate the game for a specified number of rounds.
	//maps start to # of successes for start
	java.util.Map<ThreeSlipStrategy,java.lang.Long> simulatePlay(long numberOfRounds){
        //numberOfRounds - the number of rounds to simulate
		Map <ThreeSlipStrategy, Long> longHypoMap = new EnumMap <ThreeSlipStrategy, Long>
		(ThreeSlipStrategy.class);
		
		long resultOne = 0L, resultTwo = 0L, resultThree = 0L, 
			 resultFour = 0L, resultFive = 0L, resultSix = 0L;
		
;

		for(int i = 0; i < numberOfRounds; i++){
			for (int j = 0; j < numOfSlips; j++){
				slipPile[j] = new Slip();
			}
			
			resultOne += pickFirst(slipPile);
			resultTwo += pickSecond(slipPile);
			resultThree += pickThird(slipPile);
			resultFour += informedPickStop(slipPile);
			resultFive += informedPickContinue(slipPile);
			resultSix += fullInformedStrategy(slipPile);
			
		}
			
		longHypoMap.put(ThreeSlipStrategy.KEEP_ORIGINAL, resultOne);
		
		longHypoMap.put(ThreeSlipStrategy.SWITCH_TO_REVEALED, resultTwo);
		
		longHypoMap.put(ThreeSlipStrategy.SWITCH_TO_UNKNOWN, resultThree);
		
		longHypoMap.put(ThreeSlipStrategy.STOP_IF_BETTER, resultFour);
		
		longHypoMap.put(ThreeSlipStrategy.CONTINUE_IF_WORSE, resultFive);
		
		longHypoMap.put(ThreeSlipStrategy.INFORMED_STRATEGY, resultSix);
		
		return longHypoMap;
	}
	
	//Reset environment and simulate the game for a specified number of rounds 
	//and specified range of values.
	java.util.Map<ThreeSlipStrategy,java.lang.Long> 
	simulatePlay(long numberOfRounds, int minimum, int maximum){
//	    numberOfRounds - the number of rounds to simulate
//	    minimum - the smallest of the range of slip values
//	    maximum - the largest of the range of slip values
		Map <ThreeSlipStrategy, Long> integerHypoMap = new EnumMap 
				<ThreeSlipStrategy, Long> (ThreeSlipStrategy.class);
		
		long resultOne = 0L, resultTwo = 0L, resultThree = 0L, 
			 resultFour = 0L, resultFive = 0L, resultSix = 0L;
		
		for(int i=0; i < numberOfRounds; i++){
			for (int j = 0; j < numOfSlips; j++){
			
				slipPile[j] = new Slip(minimum, maximum);
			}
			
			resultOne += pickFirst(slipPile);
			resultTwo += pickSecond(slipPile);
			resultThree += pickThird(slipPile);
			resultFour += informedPickStop(slipPile);
			resultFive += informedPickContinue(slipPile);
			resultSix += fullInformedStrategy(slipPile);
		}
		
		integerHypoMap.put(ThreeSlipStrategy.KEEP_ORIGINAL, resultOne);
		
		integerHypoMap.put(ThreeSlipStrategy.SWITCH_TO_REVEALED, resultTwo);
		
		integerHypoMap.put(ThreeSlipStrategy.SWITCH_TO_UNKNOWN, resultThree);
		
		integerHypoMap.put(ThreeSlipStrategy.STOP_IF_BETTER, resultFour);
		
		integerHypoMap.put(ThreeSlipStrategy.CONTINUE_IF_WORSE, resultFive);
		
		integerHypoMap.put(ThreeSlipStrategy.INFORMED_STRATEGY, resultSix);
		

		
		return integerHypoMap;
		
	}
	
	private long pickFirst(Slip [] slipPile){
		chosenValue = slipPile[0].value();
		
		maxValue = 0;
		
		counter = 0L;
		
		for(int i = 0; i< slipPile.length; i++){
			
			if(slipPile[i].value() >= maxValue)
			
				maxValue = slipPile[i].value();
		    }
		
		if(maxValue == 0)
		
			maxValue = chosenValue;
		
		if(chosenValue == maxValue)
			
			counter = 1L;
		
		return counter;
		
	}
	
	private long pickSecond(Slip [] slipPile){
		chosenValue = slipPile[1].value();
		
		maxValue = 0;
		
		counter = 0L;
		
		for(int i = 0; i < slipPile.length; i++){
			
			if(slipPile[i].value() >= maxValue)
			
				maxValue = slipPile[i].value();
		    }
		
		if(maxValue == 0)
		
			maxValue = chosenValue;
		
		if(chosenValue == maxValue)
			
			counter = 1L;
		
		return counter;
	}
	
	private long pickThird(Slip [] slipPile) {
		
		chosenValue = slipPile[2].value();
		maxValue=0;
		counter =0L;
		
		for(int i = 0; i< slipPile.length; i++){
			
			if(slipPile[i].value() >= maxValue)
			
				maxValue = slipPile[i].value();
		    }
		
		if(maxValue == 0)
		
			maxValue = chosenValue;
		
		if(chosenValue == maxValue)
			
			counter = 1L;
		
		return counter;
	}
	
	/*
	* Make informed decision
	* by choosing a slip, discarding,
	* picking a second slip. If second
	* slip is greater than the first, stop.
	*/
	private long informedPickStop(Slip [] slipPile) {
		
		chosenValue = slipPile[0].value();
		
		int secondPickedValue = slipPile[1].value();
		
		maxValue=0;
		
		counter =0L;
		
		if (secondPickedValue > chosenValue){			
		
			chosenValue = secondPickedValue;
		
			//Only win if the 2nd value picked is larger than the 3rd
			if (chosenValue > slipPile[2].value())
			
				counter = 1L;
		}
		
		return counter;	
	}
	
	/*
	* Make informed decision to
	* choose 3rd slip if 2nd is
	* smaller than the 1st.
	*/
	private long informedPickContinue (Slip [] slipPile){
		
		chosenValue = slipPile[0].value();
		
		int secondPickedValue = slipPile[1].value();
		
		maxValue = 0;
		
		counter = 0L;
		
		//Choose the 3rd slip if 2nd < 1st
		if(secondPickedValue < chosenValue){
		
			chosenValue = slipPile[2].value();
			
			if(chosenValue > slipPile[0].value())
			
				counter = 1L;
		}
		
		return counter;
		 
	}
	
	public long fullInformedStrategy (Slip [] slipPile){
		
		chosenValue = slipPile[0].value();
		
		int secondPickedValue = slipPile[1].value();
		
		maxValue = 0;
		
		counter = 0L;
		
		if(secondPickedValue > chosenValue)
			
			chosenValue = secondPickedValue;
		
		else
			chosenValue = slipPile[2].value();
		
		for(int i = 0; i < slipPile.length; i++){
			
			if(slipPile[i].value() >= maxValue)
				maxValue = slipPile[i].value();
		    }
		
		if(maxValue == 0)
		
			maxValue = chosenValue;
		
		if(maxValue == chosenValue)
		
			counter = 1L;
		
		return counter;
	}
	
	/*
	 * Print the results of the 
	 * map to the user.
	 * 
	 */
	public void printResults(Map<ThreeSlipStrategy, Long> resultsMap, long numRounds){
		
		System.out.println("\nSimulation results for "+ numRounds +" rounds:");
		
		System.out.println("Format >  Strategy:        Correct:   % Correct:");
	    
		System.out.println("------------------------------------------------------------");
	    
		System.out.println("Uninformed Strategies:");
	    
		System.out.println("  Keep first slip chosen:    " 
					+ resultsMap.get(ThreeSlipStrategy.KEEP_ORIGINAL) +
	    "         " + (100L * (resultsMap.get(ThreeSlipStrategy.KEEP_ORIGINAL))/numRounds) + " %");
	    
	    System.out.println("  Keep second slip chosen:   " 
	    			+ resultsMap.get(ThreeSlipStrategy.SWITCH_TO_REVEALED) +
	    "         " + (100L * (resultsMap.get(ThreeSlipStrategy.SWITCH_TO_REVEALED))/numRounds) + " %");
	    
	    System.out.println("  Keep third slip chosen:    " 
	    			+ resultsMap.get(ThreeSlipStrategy.SWITCH_TO_UNKNOWN) +
	    "         " + (100L * (resultsMap.get(ThreeSlipStrategy.SWITCH_TO_UNKNOWN))/numRounds) + " %");
	    
	    System.out.println("-------------------------------------------------------------");
	    
	    System.out.println("Informed Strategy:");
	    
	    System.out.println("  Keep second if larger than first or keep third:  " +
	    		resultsMap.get(ThreeSlipStrategy.INFORMED_STRATEGY)+ ", " + 
	    		(100L * (resultsMap.get(ThreeSlipStrategy.INFORMED_STRATEGY))/numRounds) + " %");
	    
	    System.out.println("\nContributions to Informed Strategy:");
	    
	    System.out.println("  Keep second if larger than first:       " +
	    		resultsMap.get(ThreeSlipStrategy.STOP_IF_BETTER)+ "     " + 
	    		(100L * (resultsMap.get(ThreeSlipStrategy.STOP_IF_BETTER))/numRounds) + " %");
	    
	    System.out.println("  Discard second if smaller than first:   " +
	    		resultsMap.get(ThreeSlipStrategy.CONTINUE_IF_WORSE)+ "     " + 
	    		(100L * (resultsMap.get(ThreeSlipStrategy.CONTINUE_IF_WORSE))/numRounds) + " %");
	    
	    System.out.println("-------------------------------------------------------------");
	    
		System.out.println("Comparisons:");
		System.out.print("Best uninformed strategy:  ");
		
		//Save long values to find maximum
		long [] uniformedCamparison = new long [3];
				
		uniformedCamparison [0] = resultsMap.get(ThreeSlipStrategy.KEEP_ORIGINAL);
		uniformedCamparison [1] = resultsMap.get(ThreeSlipStrategy.SWITCH_TO_REVEALED);
		uniformedCamparison [2] = resultsMap.get(ThreeSlipStrategy.SWITCH_TO_UNKNOWN);
		
		long maxValue =0;
		
		//Find maximum value of the array
		for (int i=0; i< uniformedCamparison.length; i++){
			
			if(uniformedCamparison[i] > maxValue){
				maxValue = uniformedCamparison[i];		
			}
		}
		
		System.out.println(maxValue + ",   " + ((100L * maxValue)/numRounds)+
											" %");
		
		System.out.println("Informed Strategy:         " 
				+ resultsMap.get(ThreeSlipStrategy.INFORMED_STRATEGY)+ ",   " 
				+(100L * (resultsMap.get(ThreeSlipStrategy.INFORMED_STRATEGY))/numRounds) + " %");
		
		System.out.println("-------------------------------------------------------------\n");
	}
}

