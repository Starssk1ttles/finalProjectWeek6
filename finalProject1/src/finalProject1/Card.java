package finalProject1;

public class Card {
	private String person;
	private String name; 
	private int value;
	public Card( String person, String name, int value) {
		this.person = person;
		this.name = name;
		this.value = value;	
	}
	
	@Override
	public String toString() {
		return "Card: " + person + " of " + name + ": " + value ;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
