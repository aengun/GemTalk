package prj.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

import prj.board.PlayerBoard;
import prj.entity.GameBackground;
import prj.entity.MyCard;

public class GameCanvas extends Canvas {

	public static Canvas instance;
	
	private MyCard myCard;
	
	private GameBackground gameBackground;
	
	private PlayerBoard[] playerBoards = new PlayerBoard[4]; // 플레이어 보드 4개 생성
	
	public GameCanvas() {
		instance = this;
		gameBackground = new GameBackground();
		
		playerBoards[0] = new PlayerBoard(600, 100, 100, 100);
		playerBoards[1] = new PlayerBoard(300, 450, 300, 100);
		playerBoards[2] = new PlayerBoard(600, 500, 500, 100);
		playerBoards[3] = new PlayerBoard(900, 300, 700, 100);
		
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
}