package game_tests;

import static org.junit.Assert.assertEquals;
import game_code.Board;
import game_code.EmptySpace;
import game_code.MonopolyGame;
import game_code.Player;
import game_code.RailroadSpace;
import game_code.Space;

import org.junit.Test;

public class RailroadSpaceTest {
	
	@Test
	public void testMonopolyGameHasFourRailroads() {
		MonopolyGame game = new MonopolyGame(2);
		Space currentSpace = game.getInitialSpace();
		
		int numberOfRailroads = 0;
		
		for(int i=0; i<Board.BOARD_SIZE; i++) {
			if (currentSpace instanceof game_code.RailroadSpace) numberOfRailroads++;
			currentSpace = currentSpace.getNextSpace();
		}
	
		assertEquals(4, numberOfRailroads);
	}
	
	@Test
	public void testMonopolyGameBuyingRailroadSetsOwner() {
		RailroadSpace testSpace = new RailroadSpace("Shortline");
		Player testPlayer = new Player(new EmptySpace());
		
		testSpace.interactWithLandAction(testPlayer);
		
		assertEquals(testPlayer, testSpace.getRailroadOwner());
	}
	
	@Test
	public void testMonopolyGameBuyingRailroadNotEnoughMoney() {
		RailroadSpace testSpace = new RailroadSpace("Shortline");
		Player testPlayer = new Player(new EmptySpace());
		testPlayer.changeMyMoney(-1400);
		
		testSpace.interactWithLandAction(testPlayer);
		
		assertEquals(null, testSpace.getRailroadOwner());
	}
	
	@Test
	public void testMonopolyGameBuyingRailroadChargesMoney() {
		RailroadSpace testSpace = new RailroadSpace("Shortline");
		Player testPlayer = new Player(new EmptySpace());
		
		testSpace.interactWithLandAction(testPlayer);
		
		assertEquals(1300, testPlayer.getMyMoney());
	}
	
	@Test
	public void testMonopolyGamePayingRentRailroad() {
		RailroadSpace testSpace = new RailroadSpace("Shortline");
		Player owner = new Player(new EmptySpace());
		Player renter = new Player(new EmptySpace());
		
		testSpace.interactWithLandAction(owner);
		testSpace.interactWithLandAction(renter);
		
		assertEquals(1450, renter.getMyMoney());
	}
	
	@Test
	public void testMonopolyGameOwningMultipleRailroad() {
		RailroadSpace testRailroadOne = new RailroadSpace("Shortline");
		RailroadSpace testRailroadTwo = new RailroadSpace("B&O");
		
		Player owner = new Player(new EmptySpace());
		
		testRailroadOne.interactWithLandAction(owner);
		testRailroadTwo.interactWithLandAction(owner);
		
		assertEquals(1100, owner.getMyMoney());
	}
	
	@Test
	public void testMonopolyGamePayingRentRailrdddoad() {
		RailroadSpace testRailroadOne = new RailroadSpace("Shortline");
		RailroadSpace testRailroadTwo = new RailroadSpace("B&O");
		
		Player owner = new Player(new EmptySpace());;
		Player renter = new Player(new EmptySpace());
		
		testRailroadOne.interactWithLandAction(owner);
		testRailroadTwo.interactWithLandAction(owner);

		testRailroadTwo.interactWithLandAction(renter);
		
		
		
		assertEquals(1400, renter.getMyMoney());
		assertEquals(1200, owner.getMyMoney());
	}
}
