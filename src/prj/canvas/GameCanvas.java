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
		
		// 1,2번째 인자: PlayerBoard x,y 좌표
		// 3,4번째 인자: Player x,y 좌표
		// 5,6번째 인자: MissionCard x,y 좌표
		// 7,8번째 인자: MyCard x,y 좌표
		playerBoards[0] = new PlayerBoard(250, 125, 300, 0, 200, 0, 0, 0, 1); 
		playerBoards[1] = new PlayerBoard(950, 125, 700, 0, 900, 0, 1000, 0, 2);
		playerBoards[2] = new PlayerBoard(250, 575, 300, 450, 200, 450, 0, 450, 3);
		playerBoards[3] = new PlayerBoard(950, 575, 700, 450, 900, 450, 1000, 450, 4);
		
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