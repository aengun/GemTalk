package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import prj.canvas.IntroCanvas;

public class IntroBackground {

	private double x;
	private double y;
	private int width;
	private int height;
	private String imgSrc;
	private static Image img;

	static {
		try {
			img = ImageIO.read(new File("res/introBackgroundTest.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public IntroBackground() {
		this(0, 0, "res/introBackgroundTest.png"); // 경로 아무렇게나 넣음
	}

	public IntroBackground(double x, double y, String imgSrc) {

		Image img = getImage();
		this.x = x;
		this.y = y;

	}

	public void paint(Graphics g) {

		img = getImage();
		int w = img.getWidth(IntroCanvas.instance);
		System.out.println(w);
		int h = img.getHeight(IntroCanvas.instance);
		System.out.println(h);

		g.drawImage(img, (int) 0, (int) 0, IntroCanvas.instance);

	}

	public Image getImage() {
		return img;
	}

}
