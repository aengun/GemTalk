package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public abstract class Card {

	// move 메소드를 위한 좌표
	private int x;
	private int y;
	private int dx;
	private int dy;
	
//	private int color;
	private int order;//10개의 질문을 구분하는 변수

	// 카드 사이즈
	public static int width;     
	public static int height;
	public static Image img;
	public static String imgSrc;

	private int count;

	public Card() {
		this(0,0);
	}

	public Card(int x, int y) {

		this.x=x;
		this.y=y;
		width = 154;
		height = 218;
				
	}
	
	/*
	order쓸 경우 생성자
	
	public Card(){
		this(0);
	}
	
	public Card(int order) {

		this.order = order;
		width = 154;
		height = 218;
				
	}
	*/
	
//	public abstract void paint(Graphics g);	
	
	public void paint(Graphics g) {

		// 그려낼 곳 좌표
		int w = 154; // 카드 이미지 너비 ->이거는 생성자에
		int h = 218; // 카드 이미지 높이 ->이거는 생성자에
		int x1 = w;
		int y1 = h;
		int x2 = x1 + w;
		int y2 = y1 + h;
		int p = 200;
		
		//아래에 부분은 각 클래스마다 페인트하면 될거같아서 abstract가 맞을거예요
		
		img = Toolkit.getDefaultToolkit().getImage("res/cardDeck.png");

//		g.drawImage(img, 100, 80, 100, 200, this);  // g.drawImage(이미지, x좌표, y좌표, 높이, 너비, this)
//		g.drawImage(img, 100, 300, 100 + 154, 518, 0, 0, w, h, this);  //g.drawImage(이미지, x1좌표, y1좌표, x2좌표, y2좌표, w, h, this)
//		g.drawImage(img, x1, y1, x2, y2, 0, 0, w, h, this);
		
		img = Toolkit.getDefaultToolkit().getImage("res/questionCard.png");
//		g.drawImage(img, 300, 80, 100, 200, this);
//		g.drawImage(img, 400, 300, 400 + 154, 518, 0, 0, w, h, this);
//		g.drawImage(img, x1+p, y1, x2+p, y2, 0, 0, w, h, this);

		img = Toolkit.getDefaultToolkit().getImage("res/questionCard.png");
//		g.drawImage(img, 500, 80, 100, 200, this);
//		g.drawImage(img, 700, 300, 700 + 154, 518, 0, 0, w, h, this);
//		g.drawImage(img, x1+p*2, y1, x2+p*2, y2, 0, 0, w, h, this);

	}

//	public void isSelected(int x, int y) {
//
//		int w = this.cardWidth;
//		int h = this.cardHeight;
//		int x1 = this.x - w / 2;
//		int y1 = this.y - h / 2;
//		int x2 = x1 + w;
//		int y2 = y1 + h;
//
//		// 카드 이미지 크기 범위 안에 있는가? -> (0,0) ~ (w,y) 안에 있어야 한다? :(x-w/2,y-h/2) ~ (x+w/2,y+h/2)에 속해야 한다(정중앙일 경우) (x,y) ~ (x+w,y+h)왼쪽 상단일경우		
//		// Boy 때와는 다르게 커서 위치는 가운데에 위치한다.
//
//		// 클릭 가능한게 1(카드덱), 2(1번카드), 3(2번카드)가 있다.
//		// 그외 나머지는 클릭이 되지 않게 한다.
//		// if 2, else if 3, else 1
//		
//		if ((x1 < x && x < x2) && (y1 < y && y < y2)) {
//			return 2;
//			System.out.println("선택됨");
//		}
//		else if(){
//			return 3;
//		}
//		else {
//			return 1;
//		}
//	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void zoom() {

	}

	public void move(int x, int y) {

		// 선택된 카드가 이동해야 한다. Player에게 또는 TrashCan으로
		// 어디서 이동하는가? -> 카드덱(1), 바닥에 깔린 1번 카드(2) 2번 카드(3) 좌표에서
		// 그러면 1, 2, 3, 의 좌표가 있고 이동 할 곳의 좌표가 있어야 한다.
		// 어디로 이동할 것인가? -> 그렇다면 dx, dy가 필요하다.
		// dx, dy 가 Player, TrashCan 각각 필요한가 ->

//		this.dx = x;
//		this.dy = y;

		// Player 에게 간다. -> 플레이어 이미지 좌표?

		// TrashCan 으로 간다. -> 보이지 않는 어딘가의 좌표

	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
