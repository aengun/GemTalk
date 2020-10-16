package prj.entity;

import java.awt.Color;
import java.awt.Graphics;

public class RuleButton {
	
	private double x;
	private double y;
	private double width;
	private double height;
	private String text;
	
	public RuleButton() {
		this(700,0,100,50, "뒤로 가기");
	}

	public RuleButton(double x, double y, double width, double height, String text) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
	}



	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.PINK);
		g.fillRoundRect((int)x, (int)y, (int)width, (int)height, 20, 20);
		g.setColor(Color.BLACK);
		g.drawString(text,(int)(x+20), (int)(y+height/2));
		
		System.out.println("wi: "+width);
		System.out.println("hi: "+height);
		System.out.println("x: "+x);
		System.out.println("y: "+y);
		
	}
	
	public boolean click(int x2, int y2) {
		System.out.println("x2: "+x2);
		System.out.println("y2: "+y2);
		if((x<=x2 && x2<=x+width) && (y<=y2 && y2<=y+height))
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
