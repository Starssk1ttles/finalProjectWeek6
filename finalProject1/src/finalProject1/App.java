package finalProject1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
public class App {
	private Player player1;
	private Player player2;
	
	List<String> players = List.of("Player1","Player2");
	public static void main(String[] args) {
		new App().run();	
	}
	private void run() {
		selectPlayers();
		System.out.println(player1);
		System.out.println(player2);
		Deck deck = new Deck();
		deck.shuffle();
		int numCards = deck.size();
		dealCards(deck);
		playerGame(numCards);
		checkTheWinner();
	    System.out.println(player1);
	    System.out.println(player2);
	}
	private void checkTheWinner() {
		if(player1.getPoints() > player2.getPoints()) {
			announceWinner(player1,player2);
		}
		else if(player2.getPoints() > player1.getPoints()) {
			announceWinner(player2,player1);
		}
		else {
			System.out.println("Draw!\n");
		}
	}
	private void announceWinner(Player winner, Player loser) {
		System.out.println(winner.getName() + " won with " + winner.getPoints() + "!");
		System.out.println(loser.getName() + " lost with " + loser.getPoints() + "!\n");	
	}
	private void playerGame(int numCards) {
		for(int i = 0; i < numCards / 2; i++) {
			Card player1Card = player1.flip();
			Card player2Card = player2.flip();
			
			if(player1Card.getValue() > player2Card.getValue()) {
				player1.incrementScore();	
			}
			else if(player2Card.getValue() > player1Card.getValue()) {
				player2.incrementScore();
			}
		}
	}
	private void dealCards(Deck deck) {
		while(!deck.isEmpty()) {
			player1.draw(deck);
			player2.draw(deck);
		}
	}
	private void selectPlayers() {
		Set<String>cpu = new TreeSet<>();
		Random random = new Random();
		while(cpu.size() < 2) {
			cpu.add(players.get(random.nextInt(players.size())));
		}
		List<String> result  = new ArrayList<>(cpu);
		player1 = new Player(result.get(0));
		player2 = new Player(result.get(1));	
	}
}