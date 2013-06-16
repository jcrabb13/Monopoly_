package game_tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import game_code.Board;
import game_code.GeneralSpace;
import game_code.Player;
import game_code.PropertySpace;

import org.junit.Test;

public class PropertySpaceTest {

	@Test
	public void testBoardHasCorrectNumberOfPropertySpaces() {
		Board board = new Board();
		
		GeneralSpace currentSpace = board.getInitialSpace();
		
		int numberOfProperty = 0;
		
		for(int i=0; i<Board.BOARD_SIZE; i++) {
			if (currentSpace instanceof game_code.PropertySpace) numberOfProperty++;
			currentSpace = currentSpace.getNextSpace();
		}
	
		assertEquals(22, numberOfProperty);
	}
	
	@Test
	public void testGameBuyingASpace() {
		PropertySpace testSpace = new PropertySpace("Test Ave.", 100, 20);
		Player player = new Player(testSpace);
		
		player.preformLandAction();
		
		assertEquals(1400, player.getMyMoney());
	}
	
	@Test
	public void testGameRentOnSpaceWithoutWholeGroup() {
		PropertySpace testSpace = new PropertySpace("Test Ave", 100, 20);
		PropertySpace otherSpace = new PropertySpace("Test Dr", 100, 50);
		ArrayList<PropertySpace> mySpaceGroup = new ArrayList<PropertySpace>();
		mySpaceGroup.add(testSpace);
		mySpaceGroup.add(otherSpace);
		testSpace.setGroup(mySpaceGroup);
	
		Player owner = new Player(testSpace);
		Player renter = new Player(testSpace);
		
		owner.preformLandAction();
		renter.preformLandAction();
		
		assertEquals(1480, renter.getMyMoney());
		assertEquals(1420, owner.getMyMoney());
	}
	
	@Test
	public void testGameRentOnSpaceWithWholeGroup() {
		PropertySpace testSpace1 = new PropertySpace("Test Ave", 100, 20);
		PropertySpace testSpace2 = new PropertySpace("Test Dr", 100, 50);
		testSpace1.setNextSpace(testSpace2);
		ArrayList<PropertySpace> mySpaceGroup = new ArrayList<PropertySpace>();
		mySpaceGroup.add(testSpace1);
		mySpaceGroup.add(testSpace2);
		testSpace1.setGroup(mySpaceGroup);
	
		Player owner = new Player(testSpace1);
		Player renter = new Player(testSpace1);
		
		owner.preformLandAction();
		owner.moveOnePosition();
		owner.preformLandAction();
		renter.preformLandAction();
		
		assertEquals(1460, renter.getMyMoney());
		assertEquals(1340, owner.getMyMoney());
	}

}
