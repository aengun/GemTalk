package prj.canvas;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Graphics;

import prj.entity.IntroBackground;

public class IntroCanvas extends Canvas {

	private Button button1;
	private Button button2;
	private Button button3;
	private Button[] buttons;

	private IntroBackground background;

	public IntroCanvas() {

		button1 = new Button("Strat");
		button1 = new Button("Rule");
		button1 = new Button("Exit");

		buttons = new Button[3];
		buttons[0] = button1;
		buttons[1] = button2;
		buttons[2] = button3;

		background = new IntroBackground();

	}

	@Override
	public void paint(Graphics g) {

	}

	@Override
	public void update(Graphics g) {

		paint(g);
	}
}
