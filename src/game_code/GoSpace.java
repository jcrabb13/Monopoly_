package game_code;

public class GoSpace extends GeneralSpace{	
	@Override
	public void interactWithLandAction(Player player) {player.changeMyMoney(200);}
	
	public void interactWithPassAction(Player player) {player.changeMyMoney(200);}
}
