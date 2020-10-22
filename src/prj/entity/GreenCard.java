package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import prj.canvas.GameCanvas;

public class GreenCard extends QuestionCard {
	private Image img;
	public GreenCard() {
		this(0);
	}

	public GreenCard(int order) {

		setQuestionOrder(order);
		setCardType(2);
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/questionCard.png");
	}

	@Override
	public void paint(Graphics g) {

		g.drawImage(img, getX(), getY(), GameCanvas.instance);
	}
}