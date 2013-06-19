package game_code;

public class LoadedDie implements Die{	
	int loadedValue;

	public LoadedDie(int loadedValue) {
		this.loadedValue = loadedValue;
	}
	
	public void rollDie() {}

	public int getLastRollValue() {return loadedValue;}

}
