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
	
	private int gemX;
	private int gemY;
	
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
	private CardStatus[] cardStatus;
	
	private RedCard redCard;
	private OrangeCard orangeCard;
	private GreenCard greenCard;
	
	
	private MyCardListener myCardListener;
	
	public MyCard() {
		this(0, 0);
	}
	
	public MyCard(int x, int y) {
		this.x = x;
		this.y = y;
		
		gemX = x+12;
		gemY = y+60;
		
		redGemX = x+12;
		redGemY = y+60;
		orangeGemX = x+12;
		orangeGemY = redGemY+35;
		greenGemX = x+12;
		greenGemY = orangeGemY+35;
		blueGemX = x+12;
		blueGemY = greenGemY+35;
		chanceGemX = x + 95;
		chanceGemY = (orangeGemY + greenGemY) / 2;
		
		cardStatus = new CardStatus[5];
		
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		myCardImg = tk.getImage("res/myCard1.png");
		redGemImg = tk.getImage("res/redGem.png");
		orangeGemImg = tk.getImage("res/orangeGem.png");
		greenGemImg = tk.getImage("res/greenGem.png");
		blueGemImg = tk.getImage("res/blueGem.png");
		chanceGemImg = tk.getImage("res/chanceGem.png");
		
//		{red==1 color if(color == 1)
//		cardStatus[color-1]= new CardStatus(gemX+35, temp+20젬색깔에 맞는 y좌표, status);
//			int temp = gemY;
//			for (int i = 0; i < 4; i++) {
//				String status = "X " + Integer.toString();
//				cardStatus[i] = new CardStatus(gemX+35, temp+20, status);
//				temp += 35;
//		
//				if(i == 4)
//					temp = chanceCard y에 맞게 설정
//			}
//		}
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
