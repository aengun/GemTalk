package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import prj.canvas.GameCanvas;

public class BlueCard extends QuestionCard {

	
	private Image img;
	public BlueCard() {
		this(0);
	}

	public BlueCard(int order) {

		setQuestionOrder(order);
		setCardType(3);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/questionCard.png");
	}

	@Override
	public void paint(Graphics g) {

		g.drawImage(img, getX(), getY(), GameCanvas.instance);
	}
}