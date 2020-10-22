package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import prj.canvas.GameCanvas;

public class ActionCard extends Card {

	private Random rand;
	private int ActionCardType;
	
	private Image img;
	public ActionCard() {
		this(0);
	}

	public ActionCard(int ActionCardType) {//ActionCardType는 give또는 take구분을 위한 변수

		this.ActionCardType = ActionCardType;
		setCardType(5);
		
		rand = new Random();
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/questionCard.png");
	}

	@Override
	public void giveOrTake(int playTurn) {//int playTurn give = ActionCardType(0)
		int randomPlayer = rand.nextInt(4);
		int randomCard = rand.nextInt(5);
		
		boolean ch=true;
		while(ch) {
			if(randomPlayer == playTurn)
				randomPlayer = rand.nextInt(4);
			else
				ch = false;
		}
		if(ActionCardType == 0) {
//			getplayerBoard[playTurn].getpalyer.getmycard.getgemscount[randomCard]--;
//			getplayerBoard[randomplayer].getpalyer.getmycard.getgemscount[randomCard]++;
		
		}
		else {
			
//			getplayerBoard[randomplayer].getpalyer.getmycard.getgemscount[randomCard]--;
//			getplayerBoard[playTurn].getpalyer.getmycard.getgemscount[randomCard]++;
		}
		
	}


	@Override
	public void paint(Graphics g) {
		g.drawImage(img, getX(), getY(), GameCanvas.instance);
	}

	
}
