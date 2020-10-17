package prj.entity;

import java.awt.Graphics;
import java.util.Random;

public class MissionCard {

	private int width; 
	private int height;
	private int x; 		// 미션 카드 좌표 x
	private int y; 		// 미션 카드 좌표 y
	
	private int max = 6;
	private Card[] cards = new Card[4];
	private Random rand1 = new Random(); // 카드 색상을 섞어 cards 배열에 넣기 위함
	private Random rand2 = new Random(); // 카드 색상을 섞어 cards 배열에 넣기 위함
	private Random rand3 = new Random(); // 카드 장수
	
	public MissionCard() {
		this(0, 0);
	}
	
	public MissionCard(int x, int y) {
		this.x = x;
		this.y = y;
		
		cards[0] = new RedCard();
		cards[1] = new OrangeCard();
		cards[2] = new GreenCard();
		cards[3] = new BlueCard();
		
		// 카드배열 섞기
		for (int i = 0; i < 10; i++) {
			int index1 = rand1.nextInt(4); // 0 ~ 3
			int index2 = rand2.nextInt(4); // 0 ~ 3
			
			Card temp = cards[index1];
			cards[index1] = cards[index2];
			cards[index2] = temp;
		}
		
		// 카드별 개수 정하기
		for (int i = 0; i < 4; i++) {
			if (max != 0) {
				int tempCount = rand3.nextInt(max) + 1; // 1 ~ 6
				cards[i].setCount(tempCount);
				max -= tempCount;
			} else
				cards[i].setCount(0); 
		}
	}
	
	public void paint(Graphics g) {
	}
	
	public void update() {
		
	}
}
