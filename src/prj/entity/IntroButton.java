package prj.entity;

import java.awt.Color;
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

		g.setColor(Color.PINK);
		g.fillRoundRect((int) x, (int) y, (int) width, (int) height, 20, 20);
		g.setColor(Color.BLACK);
		g.drawString(text, (int) (x + 20), (int) (y + height / 2));

	}

	public boolean isSelected(int x, int y) {
		
		int w = (int) this.width;
		int h = (int) this.height;
		int x1 = (int) this.x - w / 2;
		int y1 = (int) this.y - h + 13;
		int x2 = x1 + w;
		int y2 = y1 + h;

		if ((x1 < x && x < x2) && (y1 < y && y < y2))
			return true;

		return false;
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
