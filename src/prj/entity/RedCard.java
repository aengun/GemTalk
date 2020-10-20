package prj.entity;

import java.awt.Graphics;

public class RedCard extends QuestionCard {

	public RedCard() {
		this(0);
	}

	public RedCard(int order) {

		setQuestionOrder(order);
		setCardType(0);
	}

	@Override
	public void paint(Graphics g) {

//		g.drawImage(imgs, dx1, dy1, dx2, dy2, sx1+w*order, sy1, sx2w*(oreder+1), sy2, observer)
	}
}
