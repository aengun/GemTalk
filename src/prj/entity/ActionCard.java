package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class ActionCard extends Card {

	private Random rand;
	private int ActionCardType;
	
	public ActionCard() {
		this(0);
	}

	public ActionCard(int ActionCardType) {//ActionCardType는 give또는 take구분을 위한 변수

		this.ActionCardType = ActionCardType;
		setCardType(5);
		
		rand = new Random();
	}

	public void give() {//int playTurn give = ActionCardType(0)
		int randomPlayer = rand.nextInt(4);
		int randomCard = rand.nextInt(5);
		
//		boolean ch=true;
//		while(ch) {
//			if(randomPlayer == playTurn)
//				randomPlayer = rand.nextInt(4);
//			else
//				ch = false;
//		}playturn 0 randomplayer 2
		
//		getplayerBoard[playTurn].getpalyer.getmycard.getgemscount[randomCard]--;
//		getplayerBoard[randomplayer].getpalyer.getmycard.getgemscount[randomCard]++;
		
	}

	public void take() {//take = ActionCardType(1)
		int randomPlayer = rand.nextInt(4);
		int randomCard = rand.nextInt(5);
		
//		boolean ch=true;
//		while(ch) {
//			if(randomPlayer == playTurn)
//				randomPlayer = rand.nextInt(4);
//			else
//				ch = false;
//		}
		
//		getplayerBoard[randomplayer].getpalyer.getmycard.getgemscount[randomCard]--;
//		getplayerBoard[playTurn].getpalyer.getmycard.getgemscount[randomCard]++;
	}

	@Override
	public void paint(Graphics g) {
	}

	
}
