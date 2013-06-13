package game_code;

import java.util.ArrayList;

public class PropertySpace extends AbstractGeneralSpace {
	private ArrayList<PropertySpace> mySpaceGroup;
	String propertyName;
	Player propertyOwner;
	int propertyCost, rentCost;
	
	public PropertySpace(String propertyName, int propertyCost, int rentCost) {
		this.propertyName = propertyName;
		this.propertyCost = propertyCost;
		this.rentCost = rentCost;
	}
		
	@Override
	public void interactWithLandAction(Player player) {
		if (propertyOwner != null) {
			chargePlayerRent(player);
		} else {
			if(player.getMyMoney() >= propertyCost) {
				this.buyThisPropery(player);
			}
		}
	}
		
	private void chargePlayerRent(Player player) {
		int totalRent = rentCost;
		if (getTotalGroupSpacesOwned() == this.mySpaceGroup.size()) rentCost = rentCost*2;
		player.changeMyMoney(-1*totalRent);
		propertyOwner.changeMyMoney(totalRent);
	}	

	private void buyThisPropery(Player player) {
		player.changeMyMoney(-propertyCost);
		propertyOwner = player;
	}
	
	private int getTotalGroupSpacesOwned() {
		int totalSpaceOwned = 0;
		for(PropertySpace property : mySpaceGroup) {
			if (property.getOwner() == propertyOwner) totalSpaceOwned++;
		}
		
		return totalSpaceOwned;
	}
	
	public void setGroup(ArrayList<PropertySpace> mySpaceGroup) {this.mySpaceGroup = mySpaceGroup;}
	
	public void setOwner(Player owner) {this.propertyOwner = owner;} 
	
	public Player getOwner() { return propertyOwner;}
}
