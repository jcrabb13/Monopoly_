package game_code;

import java.util.ArrayList;

public class RailroadSpace extends GeneralSpace{	
	private ArrayList<RailroadSpace> mySpaceGroup;
	String propertyName;
	Player propertyOwner;
	
	public RailroadSpace(String propertyName) {
		this.propertyName = propertyName;
	}
		
	@Override
	public void interactWithLandAction(Player player) {
		if (propertyOwner != null) {
			chargePlayerRent(player);
		} else {
			if(player.getMyMoney() >= 200) {
				this.buyThisRailroad(player);
			}
		}
	}
		
	private void chargePlayerRent(Player player) {
		int totalRent = 50 * this.getTotalGroupSpacesOwned();
		player.changeMyMoney(-1*totalRent);
		propertyOwner.changeMyMoney(totalRent);
	}	

	private void buyThisRailroad(Player player) {
		player.changeMyMoney(-200);
		propertyOwner = player;
	}
	
	private int getTotalGroupSpacesOwned() {
		int totalSpaceOwned = 0;
		for(RailroadSpace rrSpace : mySpaceGroup) {
			if (rrSpace.getOwner() == propertyOwner) totalSpaceOwned++;
		}
		
		return totalSpaceOwned;
	}
	
	public void setGroup(ArrayList<RailroadSpace> mySpaceGroup) {this.mySpaceGroup = mySpaceGroup;}
	
	public void setOwner(Player owner) {this.propertyOwner = owner;} 
	
	public Player getOwner() { return propertyOwner;}
}
