package game_tests;

import static org.junit.Assert.*;
import game_code.*;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board board;

	@Before
	public void setUp() throws Exception {
		board = new Board();
	}
	
	@Test
	public void testMonopolyGameBoardWrapAround() { 
		GeneralSpace initialSpace = board.getInitialSpace();
		GeneralSpace currentSpace = initialSpace;
		
		for(int i = 0; i<Board.BOARD_SIZE; i++) {
			currentSpace = currentSpace.getNextSpace();
			assertNotNull(currentSpace);
		}
		
		assertSame(initialSpace, currentSpace);
	}
	
	@Test
	public void testMonopolyGameBoardHasGoSpace() {		
		assertTrue(board.getInitialSpace() instanceof GoSpace);
	}

}
