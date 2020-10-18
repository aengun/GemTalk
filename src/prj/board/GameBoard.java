package prj.board;

import java.util.Random;

import prj.entity.ActionCard;
import prj.entity.BlueCard;
import prj.entity.Card;
import prj.entity.ChanceCard;
import prj.entity.GreenCard;
import prj.entity.OrangeCard;
import prj.entity.RedCard;

public class GameBoard {

	private Card[] cardDeck;
	private Random rand;

	public GameBoard() {
		cardDeck = new Card[50];
		rand = new Random();

		for (int i = 0; i < 50; i++) {
			if (i < 10)
				cardDeck[i] = new RedCard(i % 10); // 0-9
			else if (i < 20)
				cardDeck[i] = new GreenCard(i % 10);
			else if (i < 30)
				cardDeck[i] = new OrangeCard(i % 10);
			else if (i < 40)
				cardDeck[i] = new BlueCard(i % 10);
			else if (i < 45)
				cardDeck[i] = new ActionCard();
			else
				cardDeck[i] = new ChanceCard();
		}

		shuffle();
	}

	public void shuffle() {
		for (int i = 0; i < 100; i++) {
			Card temp;
			int a = rand.nextInt(50);
			int b = rand.nextInt(50);
			temp = cardDeck[a];
			cardDeck[a] = cardDeck[b];
			cardDeck[b] = temp;
		}
	}
}
