package game_tests;

import static org.junit.Assert.*;
import game_code.*;
import org.junit.Before;
import org.junit.Test;

public class SpaceTest {
	MonopolyGame testGame;
	
	@Before
	public void setUp() throws Exception {
		testGame = new MonopolyGame(2);
	}
	
	@Test
	public void testSpaceNextSpaceExists() {
		Space testSpace = testGame.getInitialSpace();
		
		for(int i=0; i<40; i++) {
			assertTrue(testSpace instanceof Space);
			testSpace = testSpace.getNextSpace();
		}
	}
}
