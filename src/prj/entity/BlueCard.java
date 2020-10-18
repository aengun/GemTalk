package prj.entity;

import java.awt.Graphics;
import java.awt.Image;

public class BlueCard extends QuestionCard {
	
	private Image[] imgs;
//	private int order;//10개의 질문을 구분하는 변수
	//private static Image img;
	
	int[] blueCard = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	
//	int[] redCard = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };//10개 질문카드
//	int[] redCard = new int[10];

	public BlueCard() {
		this(0);
	}
	public BlueCard(int order) {

		imgs = new Image[10];
		setOrder(order);
//		img[0] = redcard1 ~ img[9] = redcard10
	}
	
	@Override
	public void paint(Graphics g) {
		
		
//		g.drawImage(imgs[order], dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
	}
}