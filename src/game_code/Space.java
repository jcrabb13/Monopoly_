package game_code;

public interface Space {
	
	void setNextSpace(Space nextSpace);
		
	Space getNextSpace();
	 
	void interactWithLandAction(Player player);
	
	void interactWithPassAction(Player player);
}
