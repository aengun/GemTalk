package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import prj.canvas.GameCanvas;

public class MyCard {

	private int x; // 나의 카드 목록 좌표 x
	private int y; // 나의 카드 목록 좌표 y
	private int width = 165;
	private int height = 200;
	
	private Image redGemImg;
	private Image orangeGemImg;
	private Image greenGemImg;
	private Image blueGemImg;
	private Image chanceGemImg;
	private Image myCardImg;
	
	private MyCardListener myCardListener;
	
	public MyCard() {
		this(0, 0);
	}
	
	public MyCard(int x, int y) {
		this.x = x;
		this.y = y;
		
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		redGemImg = tk.getImage("res/redGem.png");
		orangeGemImg = tk.getImage("res/orangeGem.png");
		greenGemImg = tk.getImage("res/greenGem.png");
		blueGemImg = tk.getImage("res/blueGem.png");
		chanceGemImg = tk.getImage("res/chanceGem.png");
		myCardImg = tk.getImage("res/myCard.png");
	}
	
	public void paint(Graphics g) {
		int gemW = redGemImg.getWidth(null);  // 어차피 gem들의 이미지크기는 같으므로 redGemImg를 대표로.
		int gemH = redGemImg.getHeight(null);
		int mCardW = myCardImg.getWidth(null);
		int mCardH = myCardImg.getHeight(null);
		int x1 = x; 
		int y1 = y;
		int x2 = x1 + width;
		int y2 = y1 + height;
		
		g.drawImage(myCardImg, 
				x1, y1, x2, y2, 
				0, 0, mCardW, mCardH, GameCanvas.instance);
		
//		g.drawImage(redGemImg, 
//				500, 500, 550, 550, 
//				0, 0, gemW, gemH, GameCanvas.instance);
//		
//		g.drawImage(orangeGemImg, 
//				550, 550, 600, 600, 
//				0, 0, gemW, gemH, GameCanvas.instance);
//		
//		g.drawImage(greenGemImg, 
//				600, 600, 650, 650, 
//				0, 0, gemW, gemH, GameCanvas.instance);
//		
//		g.drawImage(blueGemImg, 
//				650, 650, 700, 700, 
//				0, 0, gemW, gemH, GameCanvas.instance);
//		
//		g.drawImage(chanceGemImg, 
//				700, 700, 750, 750, 
//				0, 0, gemW, gemH, GameCanvas.instance);
	}
	
	// MyCard의 보석 개수를 업데이트하는 메서드가 필요할 것 같아서 추가
	public void update() {
		
		// 보석 개수를 업뎃하면서 미션카드와 보석 개수가 일치하면 onWin 실행하기
		myCardListener.onWin();
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	// [인터페이스] 꽂아넣기 위한 setter
	public void setMyCardListener(MyCardListener myCardListener) {
		this.myCardListener = myCardListener;
	}
	
}
