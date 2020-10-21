package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import prj.canvas.GameCanvas;

public class MyCard {

	// private int cardWidth = 185; // 보석 뒤 배경
	// private int cardHeight = 200;

	// 화면에 출력할 보석 크기
	private int gemWidth = 25;
	private int gemHeight = 25;

	// MyCard 좌표
	private int x;
	private int y;

	private int gemX;
	private int gemY;

	// 내가 모은 보석(카드)의 개수
	// red, orange, green, blue, chance 순
	private int[] gemsCount = {0,0,0,0,0};

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

	// 보석 이미지
	private Image myCardImg;
	private Image redGemImg;
	private Image orangeGemImg;
	private Image greenGemImg;
	private Image blueGemImg;
	private Image chanceGemImg;

	private CardStatus[] cardStatus;

	// 인터페이스
	private MyCardListener myCardListener;

	public MyCard() {
		this(0, 0);
	}

	public MyCard(int x, int y) {
		this.x = x;
		this.y = y;
		
		gemX = x + 12;
		gemY = y + 60;
		
		redGemX = x + 12;
		redGemY = y + 60;
		orangeGemX = x + 12;
		orangeGemY = redGemY + 35;
		greenGemX = x + 12;
		greenGemY = orangeGemY + 35;
		blueGemX = x + 12;
		blueGemY = greenGemY + 35;
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

		// 처음엔 내가 모은 보석(카드)의 개수가 0개이므로 0으로 초기화
		int temp = gemY;
		for (int i = 0; i < 5; i++) {
			String status = "X " + Integer.toString(gemsCount[i]);
			
			if (i == 4) 
				cardStatus[i] = new CardStatus(chanceGemX + 35, chanceGemY+20, status);
			else 
				cardStatus[i] = new CardStatus(gemX + 35, temp + 20, status);

			temp += 35;
		}
	}

	public void moveToPlayer(int cardType) {
		switch (cardType) {
		case 0:
			gemsCount[0]++;
			break;

		case 1:
			gemsCount[1]++;
			break;

		case 2:
			gemsCount[2]++;
			break;

		case 3:
			gemsCount[3]++;
			break;

		case 4:
			gemsCount[4]++;
			break;
		}

	}

	public void paint(Graphics g) {

		g.drawImage(myCardImg, x, y, GameCanvas.instance);
		g.drawImage(redGemImg, redGemX, redGemY, gemWidth, gemHeight, GameCanvas.instance);
		g.drawImage(orangeGemImg, orangeGemX, orangeGemY, gemWidth, gemHeight, GameCanvas.instance);
		g.drawImage(greenGemImg, greenGemX, greenGemY, gemWidth, gemHeight, GameCanvas.instance);
		g.drawImage(blueGemImg, blueGemX, blueGemY, gemWidth, gemHeight, GameCanvas.instance);
		g.drawImage(chanceGemImg, chanceGemX, chanceGemY, gemWidth, gemHeight, GameCanvas.instance);

		for (int i = 0; i < 5; i++)
			cardStatus[i].paint(g);
	}

	// MyCard의 보석 개수를 업데이트하는 메서드가 필요할 것 같아서 추가
	public void update() {

		// 보석 개수를 업뎃하면서 미션카드와 보석 개수가 일치하면 onWin 실행하기 MissionCard에서 설정된 젬들을 불러와야함(구분은
		// cardType)
		myCardListener.onWin();// onWin은 myCard와 missionCard의 타입들을 비교해야하므로 player로 가는게 나을거 같아요
	}

	// [인터페이스] 꽂아넣기 위한 setter
	public void setMyCardListener(MyCardListener myCardListener) {
		this.myCardListener = myCardListener;
	}

}
