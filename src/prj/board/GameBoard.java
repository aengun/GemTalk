package prj.board;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import prj.canvas.GameCanvas;
import prj.entity.ActionCard;
import prj.entity.BlueCard;
import prj.entity.Card;
import prj.entity.CardDeck;
import prj.entity.ChanceCard;
import prj.entity.GreenCard;
import prj.entity.OrangeCard;
import prj.entity.RedCard;

public class GameBoard {

	private Card[] cards;
	private List<Card> cardList;
	private CardDeck cardDeck;
	private Card card1;
	private Card card2;
	private int x;
	private int y;
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
		this(0, 0);
	}

	public GameBoard(int x, int y) {

		this.x = x;
		this.y = y;

		cards = new Card[50];
		cardList = new ArrayList<>();
		rand = new Random();
		cardDeck = new CardDeck(x, y);

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

		for (int i = 0; i < 50; i++)
			cardList.add(cards[i]);

		check();
		card1 = cardList.get(0);
		cardList.remove(0);
		check();
		card2 = cardList.get(0);
		cardList.remove(0);
	}

	public void check() {
		boolean check = true;
		while (check) {
			if (cardList.get(0).getCardType() == 4 || cardList.get(0).getCardType() == 5) {
				Card temp = cardList.get(0);
				cardList.remove(0);
				cardList.add(temp);
			} else {
				check = false;
			}
		}
	}

	public void shuffle() {
		for (int i = 0; i < 1000; i++) {
			Card temp;
			int a = rand.nextInt(50);
			int b = rand.nextInt(50);
			temp = cards[a];
			cards[a] = cards[b];
			cards[b] = temp;
		}
	}

	public void paint(Graphics g) {

		g.drawImage(img, x, y, x + 530, y + 240, 0, 0, img.getWidth(null), img.getHeight(null), GameCanvas.instance);
		cardDeck.paint(g);
		card1.paint(g);
		card2.paint(g);

//		g.drawImage(img, x, 0,x+500,640,0,0,img.getWidth(null),img.getHeight(null), GameCanvas.instance);

	}

}
