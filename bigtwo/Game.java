package bigtwo;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class Game extends Applet implements Runnable{
	public static AI AI;
	public static Player player;
	public static Deck deck;
	private static Image background;
	public static URL base;
	
	
	@Override
	public void init() {
		setSize(1200, 800);
		setBackground(Color.BLACK);
		setFocusable(true);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Big Two");
		try {
			base = getDocumentBase();
		} catch (Exception e) {
			// TODO: handle exception
		}
		background = getImage(base, "data/background.png");
	}
	
	@Override
	public void start() {
		deck = new Deck();
		AI = new AI();
//		System.out.println(deck.draw().getValue());
//		System.out.println(deck.draw().getValue());
//		System.out.println(deck.draw().getValue());
		player = new Player();

		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, this);
	}

	@Override
	public void run() {
		while(true) {
			
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public class Deck {
		ArrayList<Card> cards = new ArrayList<Card>();
		
		public Deck() {
			for(int i = 1;i < 14;i++) {
				for(int j = 0;j < 4; j++) {
					Image cardImage = getCardImage(i,j);
					Card card = new Card(i, j, cardImage);

					cards.add(card);
				}
			}
			Collections.shuffle(cards);
		}
		
		
		private Image getCardImage(int i, int j) {
			String[] suits = {"D","C","H","S"};
			String[] value = {"","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
			String suit = suits[j];
			return getImage(base, "data/" + value + suit + ".jpg");
			
		}


		public synchronized Card draw() {
			if(cards.size() == 0) {
				return null;
			} else {
				return cards.remove(0);
			}
		}
	}
}
