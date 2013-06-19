package game_code;

import java.util.Random;

public interface Die {	
	static Random randomGenerator = new Random(System.nanoTime());
	
	public void rollDie();
	
	public int getLastRollValue();

}
