package game_tests;

import static org.junit.Assert.*;
import java.util.Vector;
import game_code.*;

import org.junit.Before;
import org.junit.Test;

public class MonopolyGameTest {
	MonopolyGame testGame;
	Vector<Player> listOfPlayers;
	
	@Before
	public void setUp() throws Exception {
		testGame = new MonopolyGame(2);
		listOfPlayers = testGame.getListOfPlayers();
	}

	@Test
	public void testTakeATurn() { 
		EmptySpace beforePosition = listOfPlayers.get(0).getCurrentPosition();
		
		listOfPlayers.get(0).takeATurn();
		EmptySpace afterPosition = listOfPlayers.get(0).getCurrentPosition();
		
		assertNotSame(afterPosition, beforePosition);
	}
	
	@Test
	public void testRunTheGame() { 
		MonopolyGame gameToTestOne = new MonopolyGame(2);
		MonopolyGame gameToTestTwo = new MonopolyGame(2);
		
		gameToTestOne.runTheGame(10);
		gameToTestTwo.runTheGame(10);
		
		assertTrue(gameToTestOne.getListOfPlayers().get(0).getMyMoney() != gameToTestTwo.getListOfPlayers().get(0).getMyMoney() ||
				   gameToTestOne.getListOfPlayers().get(1).getMyMoney() != gameToTestTwo.getListOfPlayers().get(1).getMyMoney());
		
	}
}
