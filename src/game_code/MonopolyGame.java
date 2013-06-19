package game_code;
import java.util.ArrayList;

public class MonopolyGame {	
	private ArrayList<Player> listOfPlayers;
	private Board gameBoard;
	private Die gameDie;
	
	public MonopolyGame(int numberOfPlayers, Die gameDie) {	
		gameBoard = new Board();
		this.gameDie = gameDie;
		createPlayers(numberOfPlayers);			
	}
	
	public void createPlayers(int numberOfPlayers) {
		listOfPlayers = new ArrayList<Player>(numberOfPlayers);
		
		for(int i=0; i<numberOfPlayers; i++) {
			listOfPlayers.add(i, new Player(gameBoard.getInitialSpace(), gameDie));
		}
	}
	
	public void runTheGame(int numberOfRounds) {		
		for(int i=1; i<=numberOfRounds; i++) {
			playARound();
		}	
	}
	
	private void playARound() {
		for(Player player : listOfPlayers) {
			player.takeATurn();
		}
	}
	
	public ArrayList<Player> getListOfPlayers() {return listOfPlayers;}
	
	public Space getInitialSpace() {return gameBoard.getInitialSpace();}
}
