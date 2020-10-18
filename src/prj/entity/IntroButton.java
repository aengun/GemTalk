package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import prj.canvas.IntroCanvas;

public class IntroButton {

	private double x;
	private double y;
	private double width;
	private double height;
//	private String text;
	private int i;
	private Image img;

	public IntroButton() {
		this(0, 0, 0, 0, 0);
	}

	public IntroButton(double x, double y, double width, double height, int i) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
//		this.text = text;
		this.i = i;

	}

	public void paint(Graphics g) {
		// 텍스트로 넣는 방법
//		g.setColor(Color.PINK);
//		g.fillRoundRect((int) x, (int) y, (int) width, (int) height, 20, 20);
//		g.setColor(Color.BLACK);
//		g.drawString(text, (int) (x + 20), (int) (y + height / 2));

		// 그냥 그림파일 넣기
		Toolkit tk = Toolkit.getDefaultToolkit();
		if (this.i == 1) {
			img = tk.getImage("res/startButton.png");
		} else if (this.i == 2) {
			img = tk.getImage("res/ruleButton.png");
		} else if (this.i == 3) {
			img = tk.getImage("res/exitButton.png");
		}

		int x = (int) getX();
		int y = (int) getY();
		int w = (int) getWidth();
		int h = (int) getHeight();
		int iw = img.getWidth(null);
		int ih = img.getHeight(null);

		g.drawImage(img, x, y, x + w, y + h, 0, 0, iw, ih, IntroCanvas.instance);
	}

	public boolean isSelected(int x, int y) {

		int w = (int) this.width;
		int h = (int) this.height;
		int x1 = (int) this.x;
		int y1 = (int) this.y;
		int x2 = x1 + w;
		int y2 = y1 + h;

		if ((x1 <= x && x <= x2) && (y1 <= y && y <= y2))
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

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

//	public String getText() {
//		return text;
//	}
//
//	public void setText(String text) {
//		this.text = text;
//	}

}
