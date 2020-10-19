package prj.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import prj.board.GameBoard;
import prj.board.PlayerBoard;
import prj.entity.GameBackground;
import prj.entity.MyCard;

public class GameCanvas extends Canvas {

	public static Canvas instance;
	
	private GameBackground gameBackground;
	
	private MyCard myCard; // 인터페이스 때문에 정의
	private GameBoard gameBoard;
	private PlayerBoard[] playerBoards = new PlayerBoard[4]; // 플레이어 보드 4개 생성
	private Random rand;
	
	public GameCanvas() {
		instance = this;
		gameBackground = new GameBackground();
		
		playerBoards[0] = new PlayerBoard(0, 0, 1);
		playerBoards[1] = new PlayerBoard(700, 0, 2);
		playerBoards[2] = new PlayerBoard(0, 450, 3);
		playerBoards[3] = new PlayerBoard(700, 450, 4);
//		playerBoards[0] = new PlayerBoard(
//				250, 125, 	// PlayerBoard
//				350, 45,  	// Player
//				230, 20,  	// MissionCard 332 -350 18
//				20, 20,   	// MyCard  205
//				242, 80,		// redGem
//				242, 115, 		// orangeGem
//				242, 150, 		// greenGem
//				242, 185, 		// blueGem
//				0, 0, 		// chanceGem	
//				1); 		// 플레이어 순번
		rand = new Random();
		
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
		
		g.drawImage(buf, 0, 0, this);
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	
}