package game_code;

public class MonopolyApp {
	
	public static void main(String[] args) {
		int numberOfPlayers = 	3;
		int numberOfRounds = 	20;		
		
		MonopolyGame gameOne = new MonopolyGame(numberOfPlayers);
		gameOne.runTheGame(numberOfRounds);
	}
}
