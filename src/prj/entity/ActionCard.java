package prj.entity;

import java.awt.Graphics;
import java.awt.Image;

public class ActionCard extends Card {

	public ActionCard() {
		this(0);
	}

	public ActionCard(int order) {

		setQuestionOrder(order);
		setCardType(5);
	}

	public void give() {

	}

	public void take() {

	}

	@Override
	public void paint(Graphics g) {
	}

	
}
