package game_code;

public class GeneralSpace implements Space{	
	private Space nextSpace;

	public GeneralSpace() {}
	
	public void setNextSpace(Space nextSpace) {
		this.nextSpace = nextSpace;
	}

	public Space getNextSpace() {
		return nextSpace;
	}

	public void interactWithLandAction(Player player) {}

	public void interactWithPassAction(Player player) {}
	
}
