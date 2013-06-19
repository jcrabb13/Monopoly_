package game_code;

public class Player {
	private Die gameDie;
	private int diceTotal;
	
	private Space currentPosition;
	private int myMoney;
	
	public Player(Space currentPosition, Die gameDie) {
		this.currentPosition = currentPosition;
		myMoney = 1500;
		this.gameDie = gameDie;
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
	
	private void rollTheDice() {
		diceTotal = 0;
		gameDie.rollDie();
		diceTotal += gameDie.getLastRollValue();
		gameDie.rollDie();
		diceTotal += gameDie.getLastRollValue();
	}
	
	private int getDiceRoll() {return diceTotal;} 
}
