//The enumerated strategies for the 3-slip game.

public enum ThreeSlipStrategy {
	
	CONTINUE_IF_WORSE	 ("Discard second if smaller than first"),
	INFORMED_STRATEGY	 ("Keep second if larger than first, otherwise keep third"),
	KEEP_ORIGINAL		 ("Keep first slip chosen"),
	STOP_IF_BETTER		 ("Keep second if larger than first"),
	SWITCH_TO_REVEALED   ("Keep second slip chosen"),
	SWITCH_TO_UNKNOWN	 ("Choose last slip");
	
	//Description inside enum constants 
	private final String containesDescription;
	
	//adds string descriptor to the enum constants above 
	private ThreeSlipStrategy(String containedDescription) {
		this.containesDescription = containedDescription;
	}
	
	//Accesses this strategy descriptor
	public String description() {
		
		return this.containesDescription;
		
	}
	
}
