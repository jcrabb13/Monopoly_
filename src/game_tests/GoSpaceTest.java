package game_tests;

import static org.junit.Assert.*;
import game_code.*;
import org.junit.Before;
import org.junit.Test;

public class GoSpaceTest {
	MonopolyGame testGame;
	Die testGameDie;
	@Before
	public void setUp() throws Exception {
		testGameDie = new LoadedDie(4);
		testGame = new MonopolyGame(2, testGameDie);
	}
	
	@Test
	public void testMonopolyGamePlayersStartOnGoSpace() { 
		Space testSpace = testGame.getListOfPlayers().get(0).getCurrentPosition();
		
		assertTrue(testSpace instanceof GoSpace);
	}
	
	@Test
	public void testLandOnGoSpaceGivesMoney() { 
		Board testGameBoard = new Board();
		Player testPlayer = new Player(testGameBoard.getInitialSpace(), testGameDie);
		
		for (int i=0; i<39; i++) testPlayer.moveOnePosition();

		testPlayer.moveOnePosition();
		testPlayer.performLandAction();
		
		assertEquals(1700, testPlayer.getMyMoney());		
	}
	
	@Test
	public void testPassingGoSpaceGivesMoney() { 
		Board testGameBoard = new Board();
		Player testPlayer = new Player(testGameBoard.getInitialSpace(), testGameDie);
		
		for (int i=0; i<39; i++) testPlayer.moveOnePosition();

		testPlayer.moveOnePosition();
		testPlayer.performPassAction();
		
		assertEquals(1700, testPlayer.getMyMoney());		
	}
}
