package prj.entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class CardStatus {

	private int x;
	private int y;
	private String status; // 보석 개수 표시 
	
	public CardStatus() {
		this(0,0,"");
	}

	public CardStatus(int x, int y, String status) {
		this.x = x;
		this.y = y;
		this.status = status;
	}

	public void paint(Graphics g) {
		Font font = new Font("Consolas", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString(status, x, y);
	}
	
}


