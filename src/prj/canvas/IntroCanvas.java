package prj.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

import prj.entity.IntroBackground;
import prj.entity.IntroButton;

public class IntroCanvas extends Canvas {

	private IntroButton button1;
	private IntroButton button2;
	private IntroButton button3;
	private IntroButton[] buttons;

	private IntroBackground background;

	public IntroCanvas() {

		button1 = new IntroButton(50, 100, 100, 50, "Strat"); // 조정 필요
		button1 = new IntroButton(50, 200, 100, 50, "Rule"); // 조정 필요
		button1 = new IntroButton(50, 300, 100, 50, "Exit"); // 조정 필요

		buttons = new IntroButton[3];
		buttons[0] = button1;
		buttons[1] = button2;
		buttons[2] = button3;

		background = new IntroBackground();

	}

	@Override
	public void paint(Graphics g) {

		Image buf = this.createImage(this.getWidth(), getHeight());
		Graphics bg = buf.getGraphics();

		background.paint(bg);

		button1.paint(bg);
		button2.paint(bg);
		button3.paint(bg);

		g.drawImage(buf, 0, 0, this);

	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}
}
