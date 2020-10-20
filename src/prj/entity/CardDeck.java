package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import prj.canvas.GameCanvas;

public class CardDeck extends Card {

	private int x;
	private int y;
	private int width;
	private int height;
	private Image img;

	public CardDeck() {
		this(0, 0);
	}

	public CardDeck(int x, int y) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/cardDeck.png");

		this.x = x + 20;
		this.y = y + 20;
	}

	@Override
	public void paint(Graphics g) {
		width = img.getWidth(null);
		height = img.getHeight(null);

		g.drawImage(img, x, y, GameCanvas.instance);
	}

}
