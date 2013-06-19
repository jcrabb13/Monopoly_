package game_tests;

import static org.junit.Assert.*;
import game_code.RegularDie;

import org.junit.Before;
import org.junit.Test;

public class RegularDieTest {
	RegularDie testDie;
	
	
	@Before
	public void setUp() throws Exception {
		testDie = new RegularDie();
	}

	@Test
	public void testDieRollValue() {
		int rollValue;
		testDie.rollDie();
		
		rollValue = testDie.getLastRollValue();
		
		assertTrue(0 < rollValue);
		assertTrue(7 > rollValue);
	}

}
