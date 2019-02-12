package bigtwo;

import java.awt.Image;
import java.net.URL;

public class Card {
	public int value;
	public int suit;
	public Image cardImage;
	
	public Card(int value, int suit, Image cardImage) {
		this.value = value;
		this.suit = suit;
		this.cardImage = cardImage;
	}

	public int getValue() {
		return this.value;
	}

	public int getSuit() {
		return this.suit;
	}

	
}
