package game_code;
import java.util.ArrayList;

public class MonopolyGame {	
	private ArrayList<Player> listOfPlayers;
	private Board gameBoard;
	
	public MonopolyGame(int numberOfPlayers) {	
		gameBoard = new Board();
		createPlayers(numberOfPlayers);			
	}
	
	public void createPlayers(int numberOfPlayers) {
		listOfPlayers = new ArrayList<Player>(numberOfPlayers);
		
		for(int i=0; i<numberOfPlayers; i++) {
			listOfPlayers.add(i, new Player(gameBoard.getInitialSpace()));
		}
	}
	
	public void runTheGame(int numberOfTurns) {		
		for(int i=1; i<=numberOfTurns; i++) {
			playARound();
		}	
	}
	
	private void playARound() {
		for(Player player : listOfPlayers) {
			player.takeATurn();
		}
	}
	
	public ArrayList<Player> getListOfPlayers() {return listOfPlayers;}
	
	public GeneralSpace getInitialSpace() {return gameBoard.getInitialSpace();}
}
