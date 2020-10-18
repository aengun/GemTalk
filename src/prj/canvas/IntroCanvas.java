package prj.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import prj.GameFrame;
import prj.entity.IntroBackground;
import prj.entity.IntroButton;

public class IntroCanvas extends Canvas {

	public static IntroCanvas instance;
	private IntroButton button1;
	private IntroButton button2;
	private IntroButton button3;
	private IntroButton[] buttons;

	private IntroBackground background;

	public IntroCanvas() {
		instance = this;

		button1 = new IntroButton(950, 400, 150, 80, 1); // 1 : start
		button2 = new IntroButton(950, 480, 150, 80, 2); // 2 : rule
		button3 = new IntroButton(950, 560, 150, 80, 3); // 3 : exit

		buttons = new IntroButton[3];
		buttons[0] = button1;
		buttons[1] = button2;
		buttons[2] = button3;

		background = new IntroBackground();

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				if (button1.isSelected(x, y)) { // START
					try {
						System.out.println("gamecanvas");
						GameFrame.instance.switchCanvas(IntroCanvas.this, GameCanvas.class);
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (button2.isSelected(x, y)) { // HELP

					try {
						System.out.println("rulecanvas");
						GameFrame.instance.switchCanvas(IntroCanvas.this, RuleCanvas.class);
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (button3.isSelected(x, y)) { // EXIT 할 때 구현 필요

				}

			}
		});

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
