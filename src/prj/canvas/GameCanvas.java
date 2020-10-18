package prj.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import prj.board.PlayerBoard;
import prj.entity.ActionCard;
import prj.entity.BlueCard;
import prj.entity.Card;
import prj.entity.ChanceCard;
import prj.entity.GameBackground;
import prj.entity.GreenCard;
import prj.entity.MyCard;
import prj.entity.OrangeCard;
import prj.entity.RedCard;

public class GameCanvas extends Canvas {

	public static Canvas instance;
	
	private MyCard myCard;
	private Card[] cardDeck;
	
	private GameBackground gameBackground;
	
	private PlayerBoard[] playerBoards = new PlayerBoard[4]; // 플레이어 보드 4개 생성
	
	private Random rand;
	
	public GameCanvas() {
		instance = this;
		gameBackground = new GameBackground();
		
		// 1,2번째 인자: PlayerBoard x,y 좌표
		// 3,4번째 인자: Player x,y 좌표
		// 5,6번째 인자: MissionCard x,y 좌표
		// 7,8번째 인자: MyCard x,y 좌표
		playerBoards[0] = new PlayerBoard(250, 125, 300, 0, 200, 0, 0, 0, 1); 
		playerBoards[1] = new PlayerBoard(950, 125, 700, 0, 900, 0, 1000, 0, 2);
		playerBoards[2] = new PlayerBoard(250, 575, 300, 450, 200, 450, 0, 450, 3);
		playerBoards[3] = new PlayerBoard(950, 575, 700, 450, 900, 450, 1000, 450, 4);
		
		rand = new Random();
		
		cardDeck = new Card[50];
		for(int i=0;i<50;i++) {
			if(i<10)
				cardDeck[i] = new RedCard(i%10);//0-9 
			else if(i<20)
				cardDeck[i] = new GreenCard(i%10);
			else if(i<30)
				cardDeck[i] = new OrangeCard(i%10);
			else if(i<40)
				cardDeck[i] = new BlueCard(i%10);
			else if(i<45)
				cardDeck[i] = new ActionCard();
			else
				cardDeck[i] = new ChanceCard();
			
		}
		
		shuffle();
		
		// 우승할 때 인터페이스 꽂는 부분
//		myCard.setMyCardListener(new MyCardListener() {
//			
//			@Override
//			public void onWin() {
//				// 게임에서 우승했을 때의 소스코드
//			}
//		});
	}
	
	@Override
	public void paint(Graphics g) {
		Image buf = this.createImage(this.getWidth(), getHeight());
		Graphics bg = buf.getGraphics();
		
		gameBackground.paint(bg);
		for (int i = 0; i < 4; i++) 
			playerBoards[i].paint(bg);
		
		//button.paint(bg);	
		
		g.drawImage(buf, 0, 0, this);
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	public void shuffle() {
		for(int i=0;i<100;i++) {
			Card temp;
			int a = rand.nextInt(50);
			int b = rand.nextInt(50);
			temp = cardDeck[a];
			cardDeck[a] = cardDeck[b];
			cardDeck[b] = temp;
		}
	}
}