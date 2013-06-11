package game_code;

public class LuxuryTaxSpace extends AbstractGeneralSpace {

	public LuxuryTaxSpace() {}
	
	@Override
	public void interactWithLandAction(Player player) {player.changeMyMoney(-75);}
}