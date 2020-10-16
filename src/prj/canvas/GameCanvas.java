package prj.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class GameCanvas extends Canvas{//시험용 클래스

	private Image img;
	public GameCanvas() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/pc1.png");
	}

	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0,0, this);
	}
	
}
