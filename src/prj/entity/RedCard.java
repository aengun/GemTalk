package prj.entity;

import java.awt.Graphics;
import java.awt.Image;

public class RedCard extends QuestionCard {

//	private Image[] imgs;
//	private int order;//10개의 질문을 구분하는 변수

//	int[] redCard = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };//10개 질문카드
//	int[] redCard = new int[10];

	public RedCard() {
		this(0);
	}

	public RedCard(int order) {

//		imgs = new Image[10]; // 그럼 총 imgs 배열이 10개 생성이 되는데..
		setOrder(order);
//		img[0] = redcard1 ~ img[9] = redcard10
	}

	@Override
	public void paint(Graphics g) {

//		g.drawImage(imgs, dx1, dy1, dx2, dy2, sx1+w*order, sy1, sx2w*(oreder+1), sy2, observer)
	}
}
