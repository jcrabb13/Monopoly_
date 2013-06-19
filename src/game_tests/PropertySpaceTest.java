package game_tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import game_code.Board;
import game_code.LoadedDie;
import game_code.OwnableSpace;
import game_code.Space;
import game_code.Player;
import game_code.PropertySpace;

import org.junit.Test;

public class PropertySpaceTest {

	@Test
	public void testBoardHasCorrectNumberOfPropertySpaces() {
		Board board = new Board();
		
		Space currentSpace = board.getInitialSpace();
		
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
		Player player = new Player(testSpace, new LoadedDie(4));
		
		player.performLandAction();
		
		assertEquals(1400, player.getMyMoney());
	}
	
	@Test
	public void testGameRentOnSpaceWithoutWholeGroup() {
		PropertySpace testSpace = new PropertySpace("Test Ave", 100, 20);
		PropertySpace otherSpace = new PropertySpace("Test Dr", 100, 50);
		ArrayList<OwnableSpace> mySpaceGroup = new ArrayList<OwnableSpace>();
		mySpaceGroup.add(testSpace);
		mySpaceGroup.add(otherSpace);
		testSpace.setGroup(mySpaceGroup);
	
		Player owner = new Player(testSpace, new LoadedDie(4));
		Player renter = new Player(testSpace, new LoadedDie(4));
		
		owner.performLandAction();
		renter.performLandAction();
		
		assertEquals(1480, renter.getMyMoney());
		assertEquals(1420, owner.getMyMoney());
	}
	
	@Test
	public void testGameRentOnSpaceWithWholeGroup() {
		PropertySpace testSpace1 = new PropertySpace("Test Ave", 100, 20);
		PropertySpace testSpace2 = new PropertySpace("Test Dr", 100, 50);
		testSpace1.setNextSpace(testSpace2);
		ArrayList<OwnableSpace> mySpaceGroup = new ArrayList<OwnableSpace>();
		mySpaceGroup.add(testSpace1);
		mySpaceGroup.add(testSpace2);
		testSpace1.setGroup(mySpaceGroup);
	
		Player owner = new Player(testSpace1, new LoadedDie(4));
		Player renter = new Player(testSpace1, new LoadedDie(4));
		
		owner.performLandAction();
		owner.moveOnePosition();
		owner.performLandAction();
		renter.performLandAction();
		
		assertEquals(1460, renter.getMyMoney());
		assertEquals(1340, owner.getMyMoney());
	}

}
