package game_code;

import java.util.Random;

public class Player implements GamePlayerInteraction, SpacePlayerInteraction, InternalPlayerInteraction {
	static Random randomGenerator = new Random(System.nanoTime());
	
	private GeneralSpace currentPosition;
	private int myMoney;
	
	public Player(GeneralSpace currentPosition) {
		this.currentPosition = currentPosition;
		myMoney = 1500;
	}	
		
	public void takeATurn() {
		int sumOfTwoRolls = getDiceRoll() + getDiceRoll();

		for(int i=0; i<sumOfTwoRolls; i++) {
			this.moveOnePosition();
			if (i != sumOfTwoRolls-1) this.preformPassAction();
		}	
		
		this.preformLandAction();
	}
		
	
	public void preformLandAction() {currentPosition.interactWithLandAction(this);}
	
	public void preformPassAction() {currentPosition.interactWithPassAction(this);}
	
	public void moveOnePosition() {currentPosition = currentPosition.getNextSpace();}
	
	public void changeMyMoney(int amountToChange) {myMoney += amountToChange;}
	
	public int getMyMoney() {return myMoney;}
	
	public GeneralSpace getCurrentPosition() {return currentPosition;}	
	
	public int getDiceRoll() {return (randomGenerator.nextInt(6) + 1);}
}
