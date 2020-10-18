package prj.entity;

import java.awt.Graphics;
import java.awt.Image;

public class GreenCard extends QuestionCard {
	
	private static Image img;
	
	int[] greenCard = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	
	public GreenCard() {
		this(0);
	}
	
	public GreenCard(int order) {

		setOrder(order);
	}
	
	@Override
	public void paint(Graphics g) {
		
	}

}
