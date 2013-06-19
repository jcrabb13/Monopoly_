package game_code;

public class RegularDie implements Die {
	int rollValue = 0;
	
	public RegularDie() {}
	
	public void rollDie() { rollValue = randomGenerator.nextInt(6) + 1;}
	
	public int getLastRollValue() {return rollValue;}
	
}
