package bigtwo;

import java.util.ArrayList;

public class Player {
	ArrayList<Card> cards = new ArrayList<Card>();
	
	public Player(){
//		for(int i=0;i<53;i++) {
//			System.out.println(Game.deck.draw().getValue());
//		}
		for(int i=0;i<13;i++) {
			Card card = Game.deck.draw();
			System.out.println("Card suit is" + card.getSuit());
			System.out.println("Card value is" +card.getValue());

			cards.add(card);
		}
	}
}
