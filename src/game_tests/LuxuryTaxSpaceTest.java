package game_tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import game_code.*;
import org.junit.Before;
import org.junit.Test;

public class LuxuryTaxSpaceTest {
	MonopolyGame testGame;
	ArrayList<Player> listOfPlayers;
	@Before
	public void setUp() throws Exception {
		testGame = new MonopolyGame(2);
		listOfPlayers = testGame.getListOfPlayers();
	}
	
	@Test
	public void testMonopolyGameLuxuryTaxSpace() { 
		LuxuryTaxSpace testSpace = new LuxuryTaxSpace(); 

		testSpace.interactWithLandAction(listOfPlayers.get(0));
		
		assertEquals(1425, listOfPlayers.get(0).getMyMoney());
	}
	
	@Test
	public void testMonopolyGameLuxuryTaxSpaceInBoard() { 
		GeneralSpace testSpace = listOfPlayers.get(0).getCurrentPosition();
		
		for(int i=0; i<40; i++) {
			if (i == 20) testSpace.interactWithLandAction(listOfPlayers.get(0));
			testSpace = testSpace.getNextSpace();
		}
		
		assertEquals(1425, listOfPlayers.get(0).getMyMoney());
	}
	
	@Test
	public void testLuxuryTaxRemoveFromPlayersMoney() { 
		EmptySpace startSpace = new EmptySpace();
		LuxuryTaxSpace testSpace = new LuxuryTaxSpace();
		startSpace.setNextSpace(testSpace);
		Player testPlayer = new Player(startSpace);
		
		testPlayer.moveOnePosition();
		testPlayer.preformLandAction();
		
		assertEquals(1425, testPlayer.getMyMoney());		
	}
}
