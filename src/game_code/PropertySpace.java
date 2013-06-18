package game_code;

public class PropertySpace extends OwnableSpace{
	private int rentCost;
	
	public PropertySpace(String propertyName, int propertyCost, int rentCost) {
		this.spaceName = propertyName;
		this.spaceCost = propertyCost;
		this.rentCost = rentCost;
	}
		
	protected void chargePlayerRent(Player player) {
		int totalRent = rentCost;
		if (getTotalGroupSpacesOwned() == this.mySpaceGroup.size()) totalRent = totalRent*2;
		player.changeMyMoney(-1*totalRent);
		spaceOwner.changeMyMoney(totalRent);
	}	

}
