package prj.entity;

import java.awt.Graphics;
import java.awt.Image;

public class ChanceCard extends Card {
	
	private Image[] imgs;
//	private int order;//10개의 질문을 구분하는 변수
	
//	int[] redCard = { 1, 2, 3, 4, 5};//10개 질문카드
//	int[] redCard = new int[10];

	public ChanceCard() {
		this(0);
	}
	public ChanceCard(int order) {

		imgs = new Image[5];
		setOrder(order);
//		img[0] = redcard1 ~ img[4] = ChanceCard5
	}
	
	@Override
	protected Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void paint(Graphics g) {
	}

}
