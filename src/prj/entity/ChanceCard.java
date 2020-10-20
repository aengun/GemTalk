package prj.entity;

import java.awt.Graphics;
import java.awt.Image;

public class ChanceCard extends Card {

	public ChanceCard() {
		this(0);
	}

	public ChanceCard(int order) {
//	setQuestionOrder(order);
		setCardType(4);
	}

	@Override
	public void paint(Graphics g) {
		
	}

}
