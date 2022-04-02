package finalProject1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Deck {
private List<String> cardNumber = List.of("Ace","2","3","4","5","6","7","8","9","10","J","Q","K");
private List<String> suits = List.of("Diamonds", "Hearts", "Clubs", "Spades");
private List<Card> cards = new ArrayList<>();
public Deck() {
for (String suit : suits) {
for(int i = 0; i < cardNumber.size(); i += 1) {
Card card  = new Card(cardNumber.get(i), suit, i + 1);
System.out.println(card);
cards.add(card);
}
}	
}
public void shuffle() {
Collections.shuffle(cards);	
}
public Card draw() {
if(cards.isEmpty()) {
throw new IllegalStateException("Deck is empty");
}
return cards.remove(0);	
}
public int size() {
return cards.size();
}
@Override
public String toString() {
StringBuilder builder = new StringBuilder();
builder.append("Deck:\n");
for(Card card : cards) {
builder.append(" ").append(card).append("\n");
}
return builder.toString();
}
public List<Card> getCards() {
return cards;
}
public void setCards(List<Card> cards) {
this.cards = cards;
}
public boolean isEmpty() {
return size() == 0;
}
}
