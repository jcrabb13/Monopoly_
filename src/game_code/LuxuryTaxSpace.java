package game_code;

public class LuxuryTaxSpace extends GeneralSpace {
	
	@Override
	public void interactWithLandAction(Player player) {player.changeMyMoney(-75);}
}