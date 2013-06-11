package game_code;

public interface GeneralSpace {
	
	void setNextSpace(GeneralSpace nextSpace);
		
	GeneralSpace getNextSpace();
	 
	void interactWithLandAction(Player player);
	
	void interactWithPassAction(Player player);
}
