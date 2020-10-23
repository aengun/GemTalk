package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import prj.canvas.GameCanvas;

public class GreenCard extends Card {
	

	public GreenCard() {
		this(0);
	}

	public GreenCard(int order) {
		super(order,"res/greenCard.png");
		
		setCardType(2);

	}

	@Override
	public void paint(Graphics g) {
		Image img = getImg(); 
		int x = getX();
		int y = getY();
		int w = img.getWidth(null)/10;
		int h = img.getHeight(null);
		
		int order = getQuestionOrder();
		System.out.println("or: "+order);
		g.drawImage(img, x, y,x+154,y+218,0+w*order,0,w+w*order,h, GameCanvas.instance);
	}
}