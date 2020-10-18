package prj.entity;

import java.awt.Image;

public class BlueCard extends QuestionCard {
	
	//private static Image img;
	
	int[] blueCard = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	
	public BlueCard() {
		this(0);
	}
	
	public BlueCard(int order) {

		setOrder(order);
	}
}
