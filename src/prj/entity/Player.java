package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import prj.canvas.GameCanvas;

public class Player {

	private int x; // 플레이어 캐릭터 좌표 x
	private int y; // 플레이어 캐릭터 좌표 y
	private int width = 150;
	private int height = 150;
	
	private static Image img;
	
	private MissionCard missionCard;
	private MyCard myCard;
	
	static {
		try {
			img = ImageIO.read(new File("res/player1.png")); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Player() {
		this(100, 100);
	}
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		
		missionCard = new MissionCard();
		myCard = new MyCard();
	}
	
	public void choice(int x, int y) {
		
	}
	
	public void answer() {
		
	}
	
	public void paint(Graphics g) {
		int w = img.getWidth(null); 
		int h = img.getHeight(null);
		int x1 = x - width / 2; // 수정하자
		int y1 = y - height / 2;
		int x2 = x1 + width;
		int y2 = y1 + height;
		
		g.drawImage(img, 
				x1, y1, x2, y2, 
				0, 0, w, h, GameCanvas.instance);
	}
}