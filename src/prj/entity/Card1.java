package prj.entity;

import java.awt.Graphics;
import java.awt.Image;

public class Card1 extends Card {

	private int x;
	private int y;
	private int width;
	private int height;
	private Image img;

	@Override
	protected Image getImage() {

		return img;
	}

	@Override
	protected void paint(Graphics g) {

	}

	public int isSelected(int x, int y) {

		int w = this.width;
		int h = this.height;
		int x1 = this.x;
		int y1 = this.y;
		int x2 = x1 + w;
		int y2 = y1 + h;

		if ((x1 <= x && x <= x2) && (y1 <= y && y <= y2)) {
			return 2;
		}

		return 0;

	}

}
