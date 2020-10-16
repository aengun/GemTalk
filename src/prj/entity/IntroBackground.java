package prj.entity;

import java.awt.Graphics;
import java.awt.Image;

public class IntroBackground {

	private int width;
	private int height;
	private String imgSrc;
	private Image img;

	public IntroBackground() {
		this(100, 100, "res/introbg.jpg"); // 경로 아무렇게나 넣음
	}

	public IntroBackground(int width, int height, String imgSrc) {

		this.width = width;
		this.height = height;
		this.imgSrc = imgSrc;
	}

	public void paint(Graphics bg) {
		Image img = getImg();

	}

	public void update() {

	}

	public Image getImg() {
		return img;
	}

}
