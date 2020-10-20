package prj.entity;

import java.awt.Graphics;
import java.awt.Image;

public class GreenCard extends QuestionCard {

	public GreenCard() {
		this(0);
	}

	public GreenCard(int order) {

		setQuestionOrder(order);
		setCardType(2);
	}

	@Override
	public void paint(Graphics g) {

//		g.drawImage(imgs[order], dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
	}
}