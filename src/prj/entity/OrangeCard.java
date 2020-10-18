package prj.entity;

import java.awt.Graphics;
import java.awt.Image;

public class OrangeCard extends QuestionCard {
	
	private static Image img;
	
	int[] orangeCard = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	
	public OrangeCard() {
		this(0);
	}
	
	public OrangeCard(int order) {

		setOrder(order);
	}
	
	@Override
	public void paint(Graphics g) {
		
	}
}
