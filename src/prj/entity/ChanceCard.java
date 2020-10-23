package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import prj.canvas.GameCanvas;

public class ChanceCard extends Card {

	private Image img;
	
	public ChanceCard() {
		this(0);
	}

	public ChanceCard(int order) {
//		setQuestionOrder(order);
		setCardType(4);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/chanceCard.jpg");
	}

	@Override
	public void paint(Graphics g) {
		int x = getX();
		int y = getY();
		int w = img.getWidth(null)/5;
		int h = img.getHeight(null);
		
		g.drawImage(img, x, y,x+154,y+218,0,0,w,h, GameCanvas.instance);
	}

	

}
