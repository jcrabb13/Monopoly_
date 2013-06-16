package game_code;

import java.util.ArrayList;

public class Board {
	private Space startSpace;
	private ArrayList<RailroadSpace> railroadSpaces = new ArrayList<RailroadSpace>();
	private ArrayList<ArrayList<PropertySpace>> propertyGroups = new ArrayList<ArrayList<PropertySpace>>();
	
	public static final int BOARD_SIZE = 40;
	
	public Board() {
		initializePropertyList();
		createBoard();
		linkSpacesToGroup();
	}
	
	private void createBoard() {
		startSpace  = determineNextSpace(1);
		Space currentSpace = startSpace;
		
		for(int i=2; i<=BOARD_SIZE; i++) {
			currentSpace.setNextSpace(determineNextSpace(i));
			currentSpace = currentSpace.getNextSpace();
		}
		
		currentSpace.setNextSpace(startSpace);
	}
	
	private Space determineNextSpace(int spaceNumber) {
		if (spaceNumber == 1) return new GoSpace();
		else if (spaceNumber == 2) return createPropertySpace("Mediterranean Ave", 60, 2 ,0);
		else if (spaceNumber == 4) return createPropertySpace("Baltic Ave",60,4,0);
		else if (spaceNumber == 6) return createRailroadSpace("Shortline");
		else if (spaceNumber == 7) return createPropertySpace("Oriental Ave", 100, 6,1);
		else if (spaceNumber == 9) return createPropertySpace("Vermont Ave", 100, 6,1);
		else if (spaceNumber == 10) return createPropertySpace("Connecticut Ave", 120, 8,1);
		else if (spaceNumber == 12) return createPropertySpace("St Charles Place", 140, 10,2);
		else if (spaceNumber == 14) return createPropertySpace("States Ave", 140, 10,2);
		else if (spaceNumber == 15) return createPropertySpace("Virginia Ave", 160, 12,2);
		else if (spaceNumber == 16) return createRailroadSpace("B&O");
		else if (spaceNumber == 17) return createPropertySpace("St James Place", 180, 14,3);
		else if (spaceNumber == 19) return createPropertySpace("Tennessee Ave", 180, 14,3);
		else if (spaceNumber == 20) return createPropertySpace("New York Ave", 200, 16,3);
		else if (spaceNumber == 22) return createPropertySpace("Kentucky Ave", 220, 18,4);
		else if (spaceNumber == 24) return createPropertySpace("Indiana Ave", 220, 18,4);
		else if (spaceNumber == 25) return createPropertySpace("Illnoise Ave", 240, 20,4);
		else if (spaceNumber == 26) return createRailroadSpace("Reading");
		else if (spaceNumber == 27) return createPropertySpace("Atlantic Ave", 260, 22,5);
		else if (spaceNumber == 28) return createPropertySpace("Ventnor Ave", 260, 22,5);
		else if (spaceNumber == 29) return new IncomeTaxSpace();
		else if (spaceNumber == 30) return createPropertySpace("Marvin Gardens" , 280, 22,5);
		else if (spaceNumber == 31) return new LuxuryTaxSpace();
		else if (spaceNumber == 32) return createPropertySpace("Pacific Ave", 300, 26,6);
		else if (spaceNumber == 33) return createPropertySpace("North Carolina Ave", 300, 26,6);
		else if (spaceNumber == 35) return createPropertySpace("Pennsylvania Ave", 320, 28,6);
		else if (spaceNumber == 36) return createRailroadSpace("Pennsylvania");
		else if (spaceNumber == 38) return createPropertySpace("Park Place", 350, 35,7);
		else if (spaceNumber == 40) return createPropertySpace("Boardwalk", 400, 50,7);
		else return new GeneralSpace();
	}
	
	private Space createPropertySpace(String propertyName, int propertyCost, int rentCost, int groupNumber) {
		PropertySpace propertySpace = new PropertySpace(propertyName, propertyCost, rentCost);
		propertyGroups.get(groupNumber).add(propertySpace);
		return propertySpace;		
	}
	
	private Space createRailroadSpace(String spaceName) {
		RailroadSpace rrSpace = new RailroadSpace(spaceName);
		railroadSpaces.add(rrSpace);
		return rrSpace;
	}
	
	private void linkSpacesToGroup() {
		for(RailroadSpace space : railroadSpaces) {
			space.setGroup(railroadSpaces);
		}
		
		for(ArrayList<PropertySpace> groupList : propertyGroups) {
			for(PropertySpace space : groupList) {
				space.setGroup(groupList);
			}
		}
		
	}
	
	private void initializePropertyList() {
		for (int i=0; i<8; i++) {
			propertyGroups.add(new ArrayList<PropertySpace>());
		}
	}
	
	public Space getInitialSpace() {return startSpace;}
}
