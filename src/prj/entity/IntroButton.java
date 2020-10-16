package prj.entity;

import java.awt.Graphics;

public class IntroButton {

	private double x;
	private double y;
	private double width;
	private double height;
	private String text;

	public IntroButton() {
		this(0, 0, 0, 0, null);
	}

	public IntroButton(double x, double y, double width, double height, String text) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
		
	}

	public void paint(Graphics g) {

	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
