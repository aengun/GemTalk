package prj.entity;

import java.awt.Image;

public class ActionCard extends Card {

	private Image[] imgs;
//	private int order;//10개의 질문을 구분하는 변수
	
//	int[] redCard = { 1, 2, 3, 4, 5};//10개 질문카드
//	int[] redCard = new int[10];

	public ActionCard() {
		this(0);
	}
	public ActionCard(int order) {

		imgs = new Image[5];
		setOrder(order);
//		img[0] = redcard1 ~ img[4] = ActionCard5
	}

	public void give() {

	}

	public void take() {

	}

	@Override
	protected Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}
}
