package game_code;

import java.util.ArrayList;

public abstract class OwnableSpace extends GeneralSpace{
	protected ArrayList<OwnableSpace> mySpaceGroup;	
	protected Player spaceOwner;
	protected int spaceCost;
	protected String spaceName;
	
	protected abstract void chargePlayerRent(Player player);
	
	private final void buyThisProperty(Player player) {
		player.changeMyMoney(-1 * spaceCost);
		spaceOwner = player;
	}
	
	public final void interactWithLandAction(Player player) {
		if (spaceOwner != null) {
			chargePlayerRent(player);
		} else {
			if(player.getMyMoney() >= spaceCost) {
				this.buyThisProperty(player);
			}
		}
	}
	
	protected final int getTotalGroupSpacesOwned() {
		int totalSpaceOwned = 0;
		for(OwnableSpace rrSpace : mySpaceGroup) {
			if (rrSpace.getOwner() == spaceOwner) totalSpaceOwned++;
		}
		
		return totalSpaceOwned;
	}

	
	public void setGroup(ArrayList<OwnableSpace> mySpaceGroup) {this.mySpaceGroup = mySpaceGroup;}
	
	public void setOwner(Player owner) {this.spaceOwner = owner;} 
	
	public Player getOwner() { return spaceOwner;}

}
