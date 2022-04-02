package finalProject1;
import java.util.ArrayList;
import java.util.List;
public class Player {
	private List<Card>hand = new ArrayList<>();
	private int points;
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public String getName() {
		return name;
	}
	public int size() {
		return hand.size();	
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n").append(name).append(" with ").append(points)
		.append(" points.").append("");
		for(Card card : hand) {
			builder.append("").append(card).append("");
		}
		return builder.toString();
	}
	public Card flip() {
		if(hand.isEmpty()) {
			throw new IllegalStateException("Cannot draw!");
		}
		return hand.remove(0);	
	}
	public void draw(Deck deck) {
		hand.add(deck.draw());
	}
	public void incrementScore() {
		points += 1;
	}
}
