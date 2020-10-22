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
	private int x;
	private int y;

	private Card card1;
	private Card card2;
//	private int playTurn;
//	private Game

	private Random rand;
	private static Image img;

	static {
		try {
			img = ImageIO.read(new File("res/gameBoardBackground.png"));
		} catch (IOException e) {
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
		cardDeck = new CardDeck(x + 20, y + 20); // 355,255

		// 어레이리스트에 넣기 전에 배열에 50장의 카드 먼저 넣기
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
				cards[i] = new ActionCard(i % 2);
			else
				cards[i] = new ChanceCard();
		}

		shuffle(); // 배열 섞기

		// 섞은 배열을 어레이리스트에 넣기
		for (int i = 0; i < 50; i++)
			cardList.add(cards[i]);
		
		check(cardList.get(0)); 
		card1 = cardList.get(0); // 이거때문에 고정
		cardList.remove(0);
		
		check(cardList.get(0));
		card2 = cardList.get(0);
		cardList.remove(0);
	}

	public void check(Card card) {
		boolean check = true;

		while (check) {
			if (card.getCardType() == 4 || card.getCardType() == 5) {
				cardList.remove(0);
				cardList.add(card); // temp를 안만들고 이렇게 해도 되나.
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

		card1.setX(cardDeck.getX() + cardDeck.getWidth() + 20);
		card1.setY(cardDeck.getY());
		card2.setX(card1.getX() + cardDeck.getWidth() + 20);
		card2.setY(cardDeck.getY());

		cardDeck.paint(g);
		card1.paint(g);
		card2.paint(g);
		
//		g.drawImage(img, x, 0,x+500,640,0,0,img.getWidth(null),img.getHeight(null), GameCanvas.instance);

	}

	public void update() {
//		check(cardList.get(0)); 
//		card1 = cardList.get(0); 
//		cardList.remove(0);
//		
//		check(cardList.get(0));
//		card2 = cardList.get(0);
//		cardList.remove(0);
		
		// 위의 6줄 주석을 풀면 왜 질문카드를 딱 1번 클릭하면 스레드가 멈추는거지?
	}

	public CardDeck getCardDeck() {
		return cardDeck;
	}

	public void setCardDeck(CardDeck cardDeck) {
		this.cardDeck = cardDeck;
	}

	public Card getCard1() {
		return card1;
	}

	public void setCard1(Card card1) {
		this.card1 = card1;
	}

	public Card getCard2() {
		return card2;
	}

	public void setCard2(Card card2) {
		this.card2 = card2;
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}

}
