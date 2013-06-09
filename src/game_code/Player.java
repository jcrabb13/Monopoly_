package game_code;

import java.util.Random;
import java.util.Vector;

public class Player {
	static Random randomGenerator = new Random(System.nanoTime());
	
	private Space currentPosition;
	private int myMoney;
	private Vector<RailroadSpace> railroadsOwned = new Vector<RailroadSpace>();
	
	public Player(Space currentPosition) {
		this.currentPosition = currentPosition;
		myMoney = 1500;
	}	
		
	public void takeATurn() {
		int sumOfTwoRolls = rollADie() + rollADie();

		for(int i=0; i<sumOfTwoRolls; i++) {
			this.moveOnePosition();
			if (i != sumOfTwoRolls-1) this.preformPassAction();
		}	
		
		this.preformLandAction();
	}
	
	public void addARailRoad(RailroadSpace space) {railroadsOwned.add(space);}
	
	public Vector<RailroadSpace> getRailroadsOwned() {return railroadsOwned;}
	
	public void changeMyMoney(int amountToChange) {myMoney += amountToChange;}
	
	public int getMyMoney() {return myMoney;}	
	
	public void preformLandAction() {currentPosition.interactWithLandAction(this);}
	
	public void preformPassAction() {currentPosition.interactWithPassAction(this);}
	
	public void moveOnePosition() {currentPosition = currentPosition.getNextSpace();}
	
	public Space getCurrentPosition() {return currentPosition;}	
	
	public int rollADie() {return (randomGenerator.nextInt(6) + 1);}
}
