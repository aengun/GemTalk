package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import prj.canvas.GameCanvas;

public class MissionCard {

	private int cardWidth = 102;  	// 보석 뒤 배경
	private int cardHeight = 200;
	private int gemWidth = 25;		// 보석
	private int gemHeight = 25;
	
	private int x; // 미션 카드 좌표 x
	private int y; // 미션 카드 좌표 y
	
	private int redGemX;
	private int redGemY;
	private int orangeGemX;
	private int orangeGemY;
	private int greenGemX;
	private int greenGemY;
	private int blueGemX;
	private int blueGemY;
	
	private Image missionCardImg;
	private Image redGemImg;
	private Image orangeGemImg;
	private Image greenGemImg;
	private Image blueGemImg;
	
	private int max = 6;
	private Card[] cards = new Card[4];
	private Random rand = new Random(); 
	
	public MissionCard() {
		this(0, 0, 0, 0, 0, 0,
				0, 0, 0, 0);
	}
	
	public MissionCard(int x, int y, int redGemX, int redGemY, int orangeGemX, int orangeGemY, 
			int greenGemX, int greenGemY, int blueGemX, int blueGemY) {
		this.x = x;
		this.y = y;
		this.redGemX = redGemX;
		this.redGemY = redGemY;
		this.orangeGemX = orangeGemX;
		this.orangeGemY = orangeGemY;
		this.greenGemX = greenGemX;
		this.greenGemY = greenGemY;
		this.blueGemX = blueGemX;
		this.blueGemY = blueGemY;
		
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		this.missionCardImg = tk.getImage("res/missionCard.png");
		this.redGemImg = tk.getImage("res/redGem.png");
		this.orangeGemImg = tk.getImage("res/orangeGem.png");
		this.greenGemImg = tk.getImage("res/greenGem.png");
		this.blueGemImg = tk.getImage("res/blueGem.png");
		
		
		cards[0] = new RedCard();
		cards[1] = new OrangeCard();
		cards[2] = new GreenCard();
		cards[3] = new BlueCard();    
		
		// 카드배열 섞기
//		for (int i = 0; i < 10; i++) {
//			int index1 = rand.nextInt(4); // 0 ~ 3
//			int index2 = rand.nextInt(4); // 0 ~ 3
//			
//			Card temp = cards[index1];
//			cards[index1] = cards[index2];
//			cards[index2] = temp;
//		}
		
		// 카드별 개수 정하기
		for (int i = 0; i < 4; i++) {
			if (max != 0) {
				int tempCount = rand.nextInt(max) + 1; // 1 ~ 6
				cards[i].setCount(tempCount);
				max -= tempCount;
			} else
				cards[i].setCount(0); 
		}
	}
	
	public void paint(Graphics g) {
		int mCardW = missionCardImg.getWidth(null);
		int mCardH = missionCardImg.getHeight(null);
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
		
		g.drawImage(missionCardImg, 
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
	}
	
	public void update() {
		
	}
}
