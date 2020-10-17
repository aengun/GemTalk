package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import prj.canvas.GameCanvas;
import prj.canvas.RuleCanvas;

public class GameBackground {

	private int x; 
	private int y;
	private int width;
	private int height;
	
	// 딱 한 번의 이미지를 생성하기 위함
	private static Image img; 
	
	// new와 상관없이 프로그램이 로드되면 제일 먼저 실행되는 블록인 전역변수 생성자를 사용하자.
	static {
		try {
			img = ImageIO.read(new File("res/gameBackground.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public GameBackground() {
		this(0, 0, "res/gameBackground.jpg");
	}

	public GameBackground(int x, int y, String imgSrc) {
		this.x = x;
		this.y = y;
		
		Image img = getImage(); 
		width = img.getWidth(null);
		height = img.getHeight(null);
	}
	
	public void paint(Graphics g) {
		int w = GameCanvas.instance.getWidth();
		int h = GameCanvas.instance.getHeight();
		
		g.drawImage(img, x, y, w, h, GameCanvas.instance);
	}
	
	public void update() {
		
	}
	
	public Image getImage() {
		return img;
	}
}
