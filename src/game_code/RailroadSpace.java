package game_code;

public class RailroadSpace extends OwnableSpace{
	
	public RailroadSpace(String propertyName) {
		this.propertyName = propertyName;
		this.propertyCost = 200;
	}
	
	protected void chargePlayerRent(Player player) {
		int totalRent = 50 * this.getTotalGroupSpacesOwned();
		player.changeMyMoney(-1*totalRent);
		propertyOwner.changeMyMoney(totalRent);
	}	
	
}
