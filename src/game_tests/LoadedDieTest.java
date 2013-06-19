package game_tests;

import static org.junit.Assert.*;
import game_code.LoadedDie;

import org.junit.Before;
import org.junit.Test;

public class LoadedDieTest {
	LoadedDie testDie;	
	
	@Before
	public void setUp() throws Exception {
		testDie = new LoadedDie(4);
	}

	@Test
	public void testDieRollValue() {
		int rollValue;
		testDie.rollDie();
		
		rollValue = testDie.getLastRollValue();
		
		assertEquals(4, rollValue);
	}

}
