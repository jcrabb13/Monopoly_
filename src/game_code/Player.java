package game_code;

import java.util.Random;

public class Player {
	static Random randomGenerator = new Random(System.nanoTime());
	private int previousDiceRoll = 0;
	
	private Space currentPosition;
	private int myMoney;
	
	public Player(Space currentPosition) {
		this.currentPosition = currentPosition;
		myMoney = 1500;
	}	
		
	public void takeATurn() {
		rollTheDice();
		int sumOfTwoRolls = getDiceRoll();

		for(int i=0; i<sumOfTwoRolls; i++) {
			this.moveOnePosition();
			if (i != sumOfTwoRolls-1) this.performPassAction();
		}	
		
		this.performLandAction();
	}
		
	
	public void performLandAction() {currentPosition.interactWithLandAction(this);}
	
	public void performPassAction() {currentPosition.interactWithPassAction(this);}
	
	public void moveOnePosition() {currentPosition = currentPosition.getNextSpace();}
	
	public void changeMyMoney(int amountToChange) {myMoney += amountToChange;}
	
	public int getMyMoney() {return myMoney;}
	
	public Space getCurrentPosition() {return currentPosition;}	
	
	private void rollTheDice() {previousDiceRoll = (randomGenerator.nextInt(6) + 1) + (randomGenerator.nextInt(6) + 1);}
	
	private int getDiceRoll() {return previousDiceRoll;} 
}
