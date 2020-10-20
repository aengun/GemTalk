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
		this(0, 0, 1);
	}

	public Player(int pbX, int pbY, int imgNum) {
		switch (imgNum) {
		case 1:
		case 3:
			x = pbX + 350;
			y = pbY + 45;

			missionCard = new MissionCard(x - 120, y - 25);
			myCard = new MyCard(x - 340, y - 25);
			break;
		case 2:
		case 4:
			x = pbX + 20;
			y = pbY + 45;

			missionCard = new MissionCard(x + width + 30, y - 25);
			myCard = new MyCard(x + width + 162, y - 25);
			break;
		}
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/player" + imgNum + ".png");

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

		g.drawImage(img, x1, y1, x2, y2, 0, 0, w, h, GameCanvas.instance);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}