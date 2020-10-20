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
	private int count;

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

	public void zoom() {

	}

	public void move(int dx, int dy) { // player or trashcan

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

}
