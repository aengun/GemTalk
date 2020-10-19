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
		this(0, 0);
	}
	
	public MissionCard(int x, int y) {
		this.x = x;
		this.y = y;
		
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		this.missionCardImg = tk.getImage("res/missionCard1.png");
		this.redGemImg = tk.getImage("res/redGem.png");
		this.orangeGemImg = tk.getImage("res/orangeGem.png");
		this.greenGemImg = tk.getImage("res/greenGem.png");
		this.blueGemImg = tk.getImage("res/blueGem.png");
		
		this.redGemX = x+12;
		this.redGemY = y+60;
		this.orangeGemX = x+12;
		this.orangeGemY = redGemY+35;
		this.greenGemX = x+12;
		this.greenGemY = orangeGemY+35;
		this.blueGemX = x+12;
		this.blueGemY = greenGemY+35;
		
		
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
		
//		String ads = "x"+Integer.toString(cards[0].getCount());
//		System.out.println(ads);
	}

	public void paint(Graphics g) {
		
	
		g.drawImage(missionCardImg, x, y, GameCanvas.instance);
		g.drawImage(redGemImg, redGemX, redGemY, gemWidth, gemHeight, GameCanvas.instance);
		g.drawImage(orangeGemImg, orangeGemX, orangeGemY, gemWidth, gemHeight,GameCanvas.instance);
		g.drawImage(greenGemImg, greenGemX, greenGemY,gemWidth, gemHeight, GameCanvas.instance);
		g.drawImage(blueGemImg, blueGemX, blueGemY,gemWidth, gemHeight, GameCanvas.instance);
	}
	
	public void update() {
		
	}
}
