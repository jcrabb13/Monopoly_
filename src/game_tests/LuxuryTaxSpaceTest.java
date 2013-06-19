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
		testGame = new MonopolyGame(2, new LoadedDie(4));
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
		Space testSpace = listOfPlayers.get(0).getCurrentPosition();
		
		for(int i=0; i<40; i++) {
			if (testSpace instanceof LuxuryTaxSpace) testSpace.interactWithLandAction(listOfPlayers.get(0));
			testSpace = testSpace.getNextSpace();
		}
		
		assertEquals(1425, listOfPlayers.get(0).getMyMoney());
	}
	
	@Test
	public void testLuxuryTaxRemoveFromPlayersMoney() { 
		GeneralSpace startSpace = new GeneralSpace();
		LuxuryTaxSpace testSpace = new LuxuryTaxSpace();
		startSpace.setNextSpace(testSpace);
		Player testPlayer = new Player(startSpace, new LoadedDie(4));
		
		testPlayer.moveOnePosition();
		testPlayer.performLandAction();
		
		assertEquals(1425, testPlayer.getMyMoney());		
	}
}
