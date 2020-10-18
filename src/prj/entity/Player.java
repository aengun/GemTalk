package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import prj.canvas.GameCanvas;

public class Player {

	private int x; // 플레이어 캐릭터 좌표 x
	private int y; // 플레이어 캐릭터 좌표 y
	private int width = 150;
	private int height = 150;
	private Image img;
	
	private MissionCard missionCard;
	private MyCard myCard;
	
	public Player() {
		this(0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 
				0, 0, 0, 0, 1);
	}
	
	public Player(int x, int y, int missionCardX, int missionCardY, int myCardX, int myCardY, 
			int redGemX, int redGemY, int orangeGemX, int orangeGemY, int greenGemX, int greenGemY, 
			int blueGemX, int blueGemY, int chanceGemX, int chanceGemY, int imgNum) {
		this.x = x;
		this.y = y;
		
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		img = tk.getImage("res/player" + imgNum + ".png");
		
		missionCard = new MissionCard(missionCardX, missionCardY, redGemX, redGemY, orangeGemX, orangeGemY,
				greenGemX, greenGemY, blueGemX, blueGemY);
		myCard = new MyCard(myCardX, myCardY, redGemX, redGemY, orangeGemX, orangeGemY,
				greenGemX, greenGemY, blueGemX, blueGemY, chanceGemX, chanceGemY, imgNum);
	}
	
	public void choice(int x, int y) {
		
	}
	
	public void answer() {
		
	}
	
	public void paint(Graphics g) {
		missionCard.paint(g);
		myCard.paint(g);
		
		int w = img.getWidth(null); 
		int h = img.getHeight(null);
		int x1 = x; 
		int y1 = y;
		int x2 = x1 + width;
		int y2 = y1 + height;
		
		g.drawImage(img, 
				x1, y1, x2, y2, 
				0, 0, w, h, GameCanvas.instance);
	}
}