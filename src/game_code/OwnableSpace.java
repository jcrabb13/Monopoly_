package game_code;

import java.util.ArrayList;

public abstract class OwnableSpace extends GeneralSpace{
	protected ArrayList<OwnableSpace> mySpaceGroup;	
	protected Player propertyOwner;
	protected int propertyCost;
	protected String propertyName;
	
	protected abstract void chargePlayerRent(Player player);
	
	private final void buyThisProperty(Player player) {
		player.changeMyMoney(-1 * propertyCost);
		propertyOwner = player;
	}
	
	public final void interactWithLandAction(Player player) {
		if (propertyOwner != null) {
			chargePlayerRent(player);
		} else {
			if(player.getMyMoney() >= propertyCost) {
				this.buyThisProperty(player);
			}
		}
	}
	
	protected final int getTotalGroupSpacesOwned() {
		int totalSpaceOwned = 0;
		for(OwnableSpace rrSpace : mySpaceGroup) {
			if (rrSpace.getOwner() == propertyOwner) totalSpaceOwned++;
		}
		
		return totalSpaceOwned;
	}

	
	public void setGroup(ArrayList<OwnableSpace> mySpaceGroup) {this.mySpaceGroup = mySpaceGroup;}
	
	public void setOwner(Player owner) {this.propertyOwner = owner;} 
	
	public Player getOwner() { return propertyOwner;}

}
