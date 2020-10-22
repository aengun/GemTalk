package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public abstract class Card {

	// move 메소드를 위한 좌표
	private int x;
	private int y;

	private int questionOrder; // 10개의 질문을 구분하는 변수
	private int cardType; // 0:red, 1:orange, 2:green, 3:blue, 4:chance, 5:action

	// 카드 사이즈
	private static int width;
	private static int height;
	private Image img;

	// 카드 갯수 카운트?
	private int missionCount;

	// 인자가 없는 생성자
	public Card() {
		this(0, 0, null);
	}

	// 인자가 있는 생성자
	public Card(int x, int y, String imgSrc) {

		this.x = x;
		this.y = y;
		width = 154; // 카드 이미지 너비 ->이거는 생성자에
		height = 218; // 카드 이미지 높이 ->이거는 생성자에

	}

	public abstract void paint(Graphics g);
	
	public boolean choiceCard(int x, int y) {
		int w = this.width;
		int h = this.height;
		int x1 = this.x;
		int y1 = this.y;
		int x2 = x1+w;
		int y2 = y1+h;
		
		if((x1  < x && x < x2)  
				&& (y1 < y && y < y2))
			return true;
		
		return false;
	}

	public void zoomIn() {

	}
	
	public void zoomOut() {

	}

	public int getMissionCount() {
		return missionCount;
	}

	public void setMissionCount(int missionCount) {
		this.missionCount = missionCount;
	}

	public int getQuestionOrder() {
		return questionOrder;
	}

	public void setQuestionOrder(int questionOrder) {
		this.questionOrder = questionOrder;
	}

	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	

}
