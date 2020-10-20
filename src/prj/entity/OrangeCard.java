package prj.entity;

import java.awt.Graphics;
import java.awt.Image;

public class OrangeCard extends QuestionCard {

	public OrangeCard() {
		this(0);
	}

	public OrangeCard(int order) {
		setQuestionOrder(order);
		setCardType(1);
	}

	@Override
	public void paint(Graphics g) {

//		g.drawImage(imgs[order], dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
	}
}