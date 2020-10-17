package prj.entity;

import java.awt.Graphics;
import java.awt.Image;

public abstract class Card {
	
	private int x;
	private int y;
	
	// 카드 사이즈
	private int width;
	private int height;

	public Card() {
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics g) {
		
		int x;
		int y;
		int w;
		int h;
		Image img;
		
		g.drawImage(img, x, y, w, h, observer);
		
	}

	public void update() {
		
		
	}

	public int isSelected(int x, int y) {
		
		int w = this.width;
		int h = this.height;
		int x1 = this.x;
		int y1 = this.y;
		int x2 = x1;
		int y2 = y1;
		
		return 0;
		
	}

	public void zoom() {
		
		
	}

	public void move(int x, int y) {
		
		
	}
}
