package game_code;

import java.util.Random;

public class RegularDie implements Die {
	static Random randomGenerator = new Random(System.nanoTime());
	int rollValue = 0;
	
	public RegularDie() {}
	
	public void rollDie() { rollValue = randomGenerator.nextInt(6) + 1;}
	
	public int getLastRollValue() {return rollValue;}
	
}
