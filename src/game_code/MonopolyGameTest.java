package game_code;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MonopolyGameTest {
	MonopolyGame testGame;

	@Before
	public void setUp() throws Exception {
		testGame = new MonopolyGame(5,2);
	}

	@Test
	public void testMonopolyGamePlayerNumber() {
		assertTrue(testGame.listOfPlayers.size() == 2);
	}
	
	@Test
	public void testMonopolyGameTurnNumber() {
		assertTrue(testGame.numberOfTurns == 5);
	}
	
	@Test
	public void testMonopolyGamePlayerInitialMoney() { 
		for(int i = 0; i<testGame.listOfPlayers.size(); i++) {
			assertEquals(testGame.listOfPlayers.get(i).getMyMoney(),1500);
		}
	}
	
	@Test
	public void testMonopolyGamePlayerRemoveMoney() { 
		Player player = testGame.listOfPlayers.get(0);
		
		player.takeFromMyMoney(500);
		
		assertEquals(player.getMyMoney(), 1000);	
	}
	
	@Test
	public void testMonopolyGamePlayerAddMoney() { 
		Player player = testGame.listOfPlayers.get(0);
		
		player.giveToMyMoney(500);
		
		assertEquals(player.getMyMoney(), 2000);	
	}

	@Test
	public void testMonopolyGamePlayerStartSpace() { //Each players starts on space 0
		for(int i = 0; i<testGame.listOfPlayers.size(); i++) {
			assertTrue(testGame.listOfPlayers.get(i).currentPosition.getSpaceNumber() == 0);
		}		
	}
	
	@Test
	public void testMonopolyGameBoardSize() { 
		Space testSpace = testGame.listOfPlayers.get(0).currentPosition; 
		for(int i = 0; i<50; i++) {
			if(testSpace.getSpaceNumber() == 39) {
				assertTrue(testSpace.getNextSpace().getSpaceNumber() == 0);
				assertEquals(testGame.gameBoard.getInitialSpace(), testSpace.getNextSpace());		
			}
			testSpace = testSpace.getNextSpace();
		}
	}

	@Test
	public void testTakeATurn() { 
		int beforePosition = testGame.listOfPlayers.get(0).currentPosition.getSpaceNumber();
		
		testGame.listOfPlayers.get(0).takeATurn();
		int afterPosition = testGame.listOfPlayers.get(0).currentPosition.getSpaceNumber();
		
		assertTrue(beforePosition != afterPosition);
	}
	
	@Test
	public void testRunTheGame() { 
		MonopolyGame gameToTestOne = new MonopolyGame(10,2);
		MonopolyGame gameToTestTwo = new MonopolyGame(10,2);
		
		gameToTestOne.runTheGame();
		gameToTestTwo.runTheGame();
		
		assertTrue(gameToTestOne.listOfPlayers.get(0).currentPosition.getSpaceNumber() != gameToTestTwo.listOfPlayers.get(0).currentPosition.getSpaceNumber() ||
				   gameToTestOne.listOfPlayers.get(1).currentPosition.getSpaceNumber() != gameToTestTwo.listOfPlayers.get(1).currentPosition.getSpaceNumber());
		
	}
}
