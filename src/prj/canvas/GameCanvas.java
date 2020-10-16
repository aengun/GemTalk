package prj.canvas;

import java.awt.Canvas;

import prj.entity.GameBackground;
import prj.entity.MyCard;
import prj.entity.MyCardListener;

public class GameCanvas extends Canvas {

	public static Canvas instance;
	
	private MyCard myCard;
	
	private GameBackground gameBackground;
	
	public GameCanvas() {
		instance = this;
		
		gameBackground = new GameBackground();
		
		myCard.setMyCardListener(new MyCardListener() {
			
			@Override
			public void onWin() {
				// 게임에서 우승했을 때의 소스코드
			}
		});
	}
}
