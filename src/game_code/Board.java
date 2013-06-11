package game_code;

import java.util.ArrayList;

public class Board {
	private GeneralSpace startSpace;
	private ArrayList<GeneralSpace> boardSpaces;
	private ArrayList<RailroadSpace> railroadSpaces = new ArrayList<RailroadSpace>();
	public static final int BOARD_SIZE = 40;
	
	public Board() {
		boardSpaces = createSpaces();
		linkSpacesTogether(boardSpaces);
		linkSpacesToGroup(railroadSpaces);
	}
	
	private ArrayList<GeneralSpace> createSpaces() {
		ArrayList<GeneralSpace> boardSpaces = new ArrayList<GeneralSpace>(40);
		
		GeneralSpace currentSpace;
		
		for(int i=0; i<BOARD_SIZE; i++) { 
			currentSpace = determineNextSpace(i);
			boardSpaces.add(currentSpace);
		}
		
		return boardSpaces;
	}
	
	private void linkSpacesTogether(ArrayList<GeneralSpace> boardSpaces) {
		GeneralSpace startSpace = boardSpaces.get(0);
		this.startSpace = startSpace;
		GeneralSpace currentSpace = startSpace; 
		GeneralSpace nextSpace;
		
		for(int i=1; i<BOARD_SIZE; i++) { 
			nextSpace = boardSpaces.get(i);
			currentSpace.setNextSpace(nextSpace);
			currentSpace = nextSpace;
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
