package game_code;

import java.util.ArrayList;

public class RailroadSpace extends AbstractGeneralSpace{	
	private ArrayList<RailroadSpace> mySpaceGroup;
	String propertyName;
	Player propertyOwner;
	
	public RailroadSpace(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public void setGroup(ArrayList<RailroadSpace> mySpaceGroup) {this.mySpaceGroup = mySpaceGroup;}
	
	@Override
	public void interactWithLandAction(Player player) {
		if (isThisRailroadOwned()) {
			chargePlayerRent(player);
		} else {
			if(player.getMyMoney() >= 200) {
				this.buyThisRailroad(player);
			}
		}
	}
	
	private boolean isThisRailroadOwned() {
		if (propertyOwner == null) return false;
		else return true;
	}	
	
	private void chargePlayerRent(Player player) {
		int totalRent = 50 * getTotalGroupSpacesOwned();
		player.changeMyMoney(-1*totalRent);
		propertyOwner.changeMyMoney(totalRent);
	}	

	private void buyThisRailroad(Player player) {
		player.changeMyMoney(-200);
		propertyOwner = player;
	}
	
	private int getTotalGroupSpacesOwned() {
		int totalSpaceOwned = 0;
		for(int i=0; i<mySpaceGroup.size(); i++) {
			if (mySpaceGroup.get(i).getOwner() == propertyOwner) totalSpaceOwned++;
		}
		
		return totalSpaceOwned;
	}
	
	public void setOwner(Player owner) {this.propertyOwner = owner;} 
	
	public Player getOwner() { return propertyOwner;}
}
