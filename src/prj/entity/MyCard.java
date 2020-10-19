package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import prj.canvas.GameCanvas;

public class MyCard {

	private int cardWidth = 185;  // 보석 뒤 배경
	private int cardHeight = 200;
	private int gemWidth = 25;    // 보석
	private int gemHeight = 25;
	
	private int x; // 나의 카드 목록 좌표 x
	private int y; // 나의 카드 목록 좌표 y
	
	// 보석 좌표
	private int redGemX;
	private int redGemY;
	private int orangeGemX;
	private int orangeGemY;
	private int greenGemX;
	private int greenGemY;
	private int blueGemX;
	private int blueGemY;
	private int chanceGemX;
	private int chanceGemY;
	
	private Image myCardImg;
	private Image redGemImg;
	private Image orangeGemImg;
	private Image greenGemImg;
	private Image blueGemImg;
	private Image chanceGemImg;
	
	private MyCardListener myCardListener;
	
	public MyCard() {
		this(0, 0);
	}
	
	public MyCard(int x, int y) {
		this.x = x;
		this.y = y;
		
		this.redGemX = x+12;
		this.redGemY = y+60;
		this.orangeGemX = x+12;
		this.orangeGemY = redGemY+35;
		this.greenGemX = x+12;
		this.greenGemY = orangeGemY+35;
		this.blueGemX = x+12;
		this.blueGemY = greenGemY+35;
		this.chanceGemX = x + 95;
		this.chanceGemY = (orangeGemY + greenGemY) / 2;
		
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		myCardImg = tk.getImage("res/myCard1.png");
		redGemImg = tk.getImage("res/redGem.png");
		orangeGemImg = tk.getImage("res/orangeGem.png");
		greenGemImg = tk.getImage("res/greenGem.png");
		blueGemImg = tk.getImage("res/blueGem.png");
		chanceGemImg = tk.getImage("res/chanceGem.png");
	}
	
	public void paint(Graphics g) {
		int mCardW = myCardImg.getWidth(null);
		int mCardH = myCardImg.getHeight(null);
		int gemW = redGemImg.getWidth(null);  // 어차피 gem들의 이미지크기는 같으므로 redGemImg를 대표로.
		int gemH = redGemImg.getHeight(null);
		
		int x1 = x + cardWidth;
		int y1 = y + cardHeight;
		int redGemX1 = redGemX + gemWidth;
		int redGemY1 = redGemY + gemHeight;
		int orangeGemX1 = orangeGemX + gemWidth;
		int orangeGemY1 = orangeGemY + gemHeight;
		int greenGemX1 = greenGemX + gemWidth;
		int greenGemY1 = greenGemY + gemHeight;
		int blueGemX1 = blueGemX + gemWidth;
		int blueGemY1 = blueGemY + gemHeight;
		int chanceGemX1 = chanceGemX + gemWidth;
		int chanceGemY1 = chanceGemY + gemHeight;
		
		g.drawImage(myCardImg, 
				x, y, x1, y1, 
				0, 0, mCardW, mCardH, GameCanvas.instance);
		
		g.drawImage(redGemImg, 
				redGemX, redGemY, redGemX1, redGemY1, 
				0, 0, gemW, gemH, GameCanvas.instance);
		
		g.drawImage(orangeGemImg, 
				orangeGemX, orangeGemY, orangeGemX1, orangeGemY1, 
				0, 0, gemW, gemH, GameCanvas.instance);
		
		g.drawImage(greenGemImg, 
				greenGemX, greenGemY, greenGemX1, greenGemY1, 
				0, 0, gemW, gemH, GameCanvas.instance);
		
		g.drawImage(blueGemImg, 
				blueGemX, blueGemY, blueGemX1, blueGemY1, 
				0, 0, gemW, gemH, GameCanvas.instance);
		
		g.drawImage(chanceGemImg, 
				chanceGemX, chanceGemY, chanceGemX1, chanceGemY1, 
				0, 0, gemW, gemH, GameCanvas.instance);
	}
	
	// MyCard의 보석 개수를 업데이트하는 메서드가 필요할 것 같아서 추가
	public void update() {
		
		// 보석 개수를 업뎃하면서 미션카드와 보석 개수가 일치하면 onWin 실행하기
		myCardListener.onWin();
	}

	// [인터페이스] 꽂아넣기 위한 setter
	public void setMyCardListener(MyCardListener myCardListener) {
		this.myCardListener = myCardListener;
	}
	
}
