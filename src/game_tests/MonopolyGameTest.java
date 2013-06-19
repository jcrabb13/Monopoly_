package game_tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import game_code.*;

import org.junit.Before;
import org.junit.Test;

public class MonopolyGameTest {
	MonopolyGame testGame;
	ArrayList<Player> listOfPlayers;
	
	@Before
	public void setUp() throws Exception {
		testGame = new MonopolyGame(2, new LoadedDie(4));
		listOfPlayers = testGame.getListOfPlayers();
	}

	@Test
	public void testTakeATurn() { 
		Space beforePosition = listOfPlayers.get(0).getCurrentPosition();
		
		listOfPlayers.get(0).takeATurn();
		Space afterPosition = listOfPlayers.get(0).getCurrentPosition();
		
		assertNotSame(afterPosition, beforePosition);
	}
	
	@Test
	public void testRunTheGame() { 
		MonopolyGame gameToTestOne = new MonopolyGame(2, new RegularDie());
		MonopolyGame gameToTestTwo = new MonopolyGame(2, new RegularDie());
		
		gameToTestOne.runTheGame(10);
		gameToTestTwo.runTheGame(10);
		
		assertTrue(gameToTestOne.getListOfPlayers().get(0).getMyMoney() != gameToTestTwo.getListOfPlayers().get(0).getMyMoney() ||
				   gameToTestOne.getListOfPlayers().get(1).getMyMoney() != gameToTestTwo.getListOfPlayers().get(1).getMyMoney());
		
	}
}
