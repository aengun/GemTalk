package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import prj.canvas.GameCanvas;

public class OrangeCard extends QuestionCard {
	private Image img;
	public OrangeCard() {
		this(0);
	}

	public OrangeCard(int order) {
		setQuestionOrder(order);
		setCardType(1);
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/questionCard.png");
	}

	@Override
	public void paint(Graphics g) {

		g.drawImage(img, getX(), getY(), GameCanvas.instance);
	}
}