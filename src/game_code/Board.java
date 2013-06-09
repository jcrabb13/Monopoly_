package game_code;

public class Board {
	private Space startSpace;
	public static final int BOARD_SIZE = 40;
	
	public Board() {
		startSpace = new GoSpace();
		Space currentSpace = startSpace; 
		Space nextSpace;
		
		for(int i=1; i<BOARD_SIZE; i++) { 
			nextSpace = determineNextSpace(i);
			currentSpace.setNextSpace(nextSpace);
			currentSpace = nextSpace;
		}
		
		currentSpace.setNextSpace(startSpace);
	}
	
	private Space determineNextSpace(int spaceNumber) {
		Space nextSpace;
		
		if (spaceNumber == 5) nextSpace = new RailroadSpace("Reading");
		else if (spaceNumber == 10) nextSpace = new IncomeTaxSpace();
		else if (spaceNumber == 15) nextSpace = new RailroadSpace("Pennsylvania");
		else if (spaceNumber == 20) nextSpace = new LuxuryTaxSpace();
		else if (spaceNumber == 25) nextSpace = new RailroadSpace("B&O");
		else if (spaceNumber == 35) nextSpace = new RailroadSpace("Shortline");
		else nextSpace = new EmptySpace();
		
		return nextSpace;
	}
	
	public Space getInitialSpace() {return startSpace;}
}
