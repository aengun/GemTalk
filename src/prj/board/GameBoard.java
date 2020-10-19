package prj.board;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import prj.entity.ActionCard;
import prj.entity.BlueCard;
import prj.entity.Card;
import prj.entity.Card1;
import prj.entity.Card2;
import prj.entity.CardDeck;
import prj.entity.ChanceCard;
import prj.entity.GreenCard;
import prj.entity.OrangeCard;
import prj.entity.RedCard;

public class GameBoard {
	
	private Card[] cards;
	private CardDeck cardDeck;
	private Card1 card1;
	private Card2 card2;
//	private Game
	
	private Random rand;
	private static Image img;
	
	static {
		try {
			img = ImageIO.read(new File("res/gameBoardBackground.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public GameBoard() {
		cards = new Card[50];
		rand = new Random();

		for (int i = 0; i < 50; i++) {
			if (i < 10)
				cards[i] = new RedCard(i % 10); // 0-9
			else if (i < 20)
				cards[i] = new GreenCard(i % 10);
			else if (i < 30)
				cards[i] = new OrangeCard(i % 10);
			else if (i < 40)
				cards[i] = new BlueCard(i % 10);
			else if (i < 45)
				cards[i] = new ActionCard();
			else
				cards[i] = new ChanceCard();
		}

		shuffle();
	}

	public void shuffle() {
		for (int i = 0; i < 100; i++) {
			Card temp;
			int a = rand.nextInt(50);
			int b = rand.nextInt(50);
			temp = cards[a];
			cards[a] = cards[b];
			cards[b] = temp;
		}
	}

	public void paint(Graphics g) {
		
//		Image buf = this.createImage();
//		Graphics bg = buf.getGraphics();
		GBback.paint(g);
		cardDeck.paint(g);
		card1.paint(g);
		card2.paint(b);

		g.drawImage(buf, 0, 0, this);//
		
	}

}
