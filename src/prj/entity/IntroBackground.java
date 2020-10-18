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
			img = ImageIO.read(new File("res/introBackground.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

// 이부분 없어도 되지 않나?
//	public IntroBackground() {
//		this(0, 0, "res/introBackgroundTest.png"); // 경로 아무렇게나 넣음
//	}

//	public IntroBackground(double x, double y, String imgSrc) {
//
//		Image img = getImage();
//		this.x = x;
//		this.y = y;
//
//	}

	public void paint(Graphics g) {

		img = getImage();
		width = img.getWidth(IntroCanvas.instance); // 배경화면 그림 파일 사이즈
		height = img.getHeight(IntroCanvas.instance);
		int cw = IntroCanvas.instance.getWidth(); // 캔버스 사이즈
		int ch = IntroCanvas.instance.getHeight();

		g.drawImage(img, 0, 0, cw, ch, 0, 0, width, height, IntroCanvas.instance);

	}

	public Image getImage() {
		return img;
	}

}
