package game_tests;

import static org.junit.Assert.*;
import java.util.Vector;
import game_code.*;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	MonopolyGame testGame;
	Vector<Player> listOfPlayers;
	@Before
	public void setUp() throws Exception {
		testGame = new MonopolyGame(2);
		listOfPlayers = testGame.getListOfPlayers();
	}
	
	@Test
	public void testMonopolyGamePlayerNumber() {
		assertEquals(2, listOfPlayers.size());
	}
	
	@Test
	public void testMonopolyGamePlayerInitialMoney() { 
		for(int i = 0; i<listOfPlayers.size(); i++) {
			assertEquals(1500, listOfPlayers.get(i).getMyMoney());
		}
	}
	
	@Test
	public void testMonopolyGamePlayerRemoveMoney() { 
		Player player = listOfPlayers.get(0);
		
		player.changeMyMoney(-500);
		
		assertEquals(1000, player.getMyMoney());	
	}
	
	@Test
	public void testMonopolyGamePlayerAddMoney() { 
		Player player = listOfPlayers.get(0);
		
		player.changeMyMoney(500);
		
		assertEquals(2000, player.getMyMoney());	
	}

	@Test
	public void testMonopolyGamePlayerStartSpace() { //Each players starts on space 0
		for(int i = 0; i<listOfPlayers.size(); i++) {
			assertEquals(listOfPlayers.get(i).getCurrentPosition(), testGame.getInitialSpace());
		}		
	}

}
