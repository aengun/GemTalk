package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import prj.canvas.GameCanvas;

public class MissionCard {

	private int width = 100;  
	private int height = 200;
	private int x; // 미션 카드 좌표 x
	private int y; // 미션 카드 좌표 y
	
	private Image redGemImg;
	private Image orangeGemImg;
	private Image greenGemImg;
	private Image blueGemImg;
	private Image missionCardImg;
	
	private int max = 6;
	private Card[] cards = new Card[4];
	private Random rand = new Random(); 
	
	public MissionCard() {
		this(0, 0);
	}
	
	public MissionCard(int x, int y) {
		this.x = x;
		this.y = y;
		
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		redGemImg = tk.getImage("res/redGem.png");
		orangeGemImg = tk.getImage("res/orangeGem.png");
		greenGemImg = tk.getImage("res/greenGem.png");
		blueGemImg = tk.getImage("res/blueGem.png");
		missionCardImg = tk.getImage("res/missionCard.png");
		
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
		int gemW = redGemImg.getWidth(null);  // 어차피 gem들의 이미지크기는 같으므로 redGemImg를 대표로.
		int gemH = redGemImg.getHeight(null);
		int mCardW = missionCardImg.getWidth(null);
		int mCardH = missionCardImg.getHeight(null);
		int x1 = x;
		int y1 = y;
		int x2 = x1 + width;
		int y2 = y1 + height;
		
		g.drawImage(missionCardImg, 
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
	}
	
	public void update() {
		
	}
}
