package game_code;

abstract class AbstractGeneralSpace implements GeneralSpace{	
	private GeneralSpace nextSpace;

	public AbstractGeneralSpace() {}
	
	public void setNextSpace(GeneralSpace nextSpace) {
		this.nextSpace = nextSpace;
	}

	public GeneralSpace getNextSpace() {
		return nextSpace;
	}

	public void interactWithLandAction(Player player) {}

	public void interactWithPassAction(Player player) {}
	
}
