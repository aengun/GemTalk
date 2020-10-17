package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameBackground {

	private int width;
	private int height;
	
	private static Image img; 
	
	static {
		try {
			img = ImageIO.read(new File("res/pc1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public GameBackground() {
		this(0, 0, "res/pc1.png");
	}

	public GameBackground(double x, double y, String string) {
		
	}
	
	public void paint(Graphics g) {
		//g.drawImage(img, (int)x, (int)y - offsetY, Action2Canvas.instance);
	}
	
	public void update() {
		
	}
}
