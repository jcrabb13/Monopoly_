package game_code;

import java.util.ArrayList;

public class Board {
	private GeneralSpace startSpace;
	private ArrayList<RailroadSpace> railroadSpaces = new ArrayList<RailroadSpace>();
	
	public static final int BOARD_SIZE = 40;
	
	public Board() {
		createBoard();
		linkSpacesToGroup(railroadSpaces);
	}
	
	private void createBoard() {
		startSpace  = determineNextSpace(0);
		GeneralSpace currentSpace = startSpace;
		
		for(int i=1; i<BOARD_SIZE; i++) {
			currentSpace.setNextSpace(determineNextSpace(i));
			currentSpace = currentSpace.getNextSpace();
		}
		
		currentSpace.setNextSpace(startSpace);
	}
	
	private GeneralSpace determineNextSpace(int spaceNumber) {
		if (spaceNumber == 0) return new GoSpace();
		else if (spaceNumber == 5) return createRailroadSpace("Reading");
		else if (spaceNumber == 10) return new IncomeTaxSpace();
		else if (spaceNumber == 15) return createRailroadSpace("Shortline");
		else if (spaceNumber == 20) return new LuxuryTaxSpace();
		else if (spaceNumber == 25) return createRailroadSpace("B&O");
		else if (spaceNumber == 35) return createRailroadSpace("Pennsylvania");
		else return new EmptySpace();
	}
	
	private GeneralSpace createRailroadSpace(String spaceName) {
		RailroadSpace space = new RailroadSpace(spaceName);
		railroadSpaces.add(space);
		return space;
	}
	
	private void linkSpacesToGroup(ArrayList<RailroadSpace> railroadSpaces) {
		for(RailroadSpace space : railroadSpaces) {
			space.setGroup(railroadSpaces);
		}
		
	}
	
	public GeneralSpace getInitialSpace() {return startSpace;}
}
