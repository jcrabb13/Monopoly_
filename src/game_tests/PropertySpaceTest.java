package game_tests;

import static org.junit.Assert.*;
import game_code.Board;
import game_code.GeneralSpace;
import game_code.MonopolyGame;

import org.junit.Test;

public class PropertySpaceTest {

	@Test
	public void testBoardHasCorrectNumberOfPropertySpaces() {
		Board board = new Board();
		
		GeneralSpace currentSpace = board.getInitialSpace();
		
		int numberOfProperty = 0;
		
		for(int i=0; i<Board.BOARD_SIZE; i++) {
			if (currentSpace instanceof game_code.PropertySpace) numberOfProperty++;
			currentSpace = currentSpace.getNextSpace();
		}
	
		assertEquals(22, numberOfProperty);
	}

}
