package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import prj.canvas.RuleCanvas;

public class RuleButton {

	private double x;
	private double y;
	private double width;
	private double height;
	private String text;
	private Image img;

	public RuleButton() {
		this(950, 560, 150, 80);
	}

	public RuleButton(double x, double y, double width, double height) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
//		this.text = text;
	}

	public void paint(Graphics g) {

//		g.setColor(Color.PINK);
//		g.fillRoundRect((int) x, (int) y, (int) width, (int) height, 20, 20);
//		g.setColor(Color.BLACK);
//		g.drawString(text, (int) (x + 20), (int) (y + height / 2));
//
//		System.out.println("wi: " + width);
//		System.out.println("hi: " + height);
//		System.out.println("x: " + x);
//		System.out.println("y: " + y);

		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/backButton.png");

		int x = (int) getX();
		int y = (int) getY();
		int w = (int) getWidth();
		int h = (int) getHeight();
		int iw = img.getWidth(null);
		int ih = img.getHeight(null);
		System.out.println(iw);

		g.drawImage(img, x, y, x + w, y + h, 0, 0, iw, ih, RuleCanvas.instance);

	}

	public boolean click(int x2, int y2) {
		System.out.println("x2: " + x2);
		System.out.println("y2: " + y2);
		if ((x <= x2 && x2 <= x + width) && (y <= y2 && y2 <= y + height))
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

	@Override
	public String toString() {
		return "Button [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", text=" + text + "]";
	}

}
