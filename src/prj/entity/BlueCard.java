package prj.entity;

import java.awt.Graphics;
import java.awt.Image;

public class BlueCard extends QuestionCard {

	public BlueCard() {
		this(0);
	}

	public BlueCard(int order) {

		setQuestionOrder(order);
		setCardType(3);
	}

	@Override
	public void paint(Graphics g) {

//		g.drawImage(imgs[order], dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
	}
}