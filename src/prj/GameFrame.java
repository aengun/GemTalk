package prj;

import java.awt.Canvas;
import java.awt.Frame;

import prj.canvas.GameCanvas;
import prj.canvas.IntroCanvas;
import prj.canvas.RuleCanvas;

public class GameFrame extends Frame {
	public static GameFrame instance;
	private IntroCanvas introCanvas;
	private RuleCanvas ruleCanvas;
	private GameCanvas gameCanvas;

	public GameFrame() {
		instance = this;

		introCanvas = new IntroCanvas();
//		ruleCanvas = new RuleCanvas();
//		gameCanvas = new GameCanvas();
		add(introCanvas);
		setSize(1200, 700);
		setVisible(true);

	}

	public void switchCanvas(RuleCanvas oldCanvas, Class newCanvas)
			throws InstantiationException, IllegalAccessException {

		remove(oldCanvas);

		add((Canvas) newCanvas.newInstance());

	}

	public void switchCanvas(IntroCanvas oldCanvas, Class newCanvas)
			throws InstantiationException, IllegalAccessException {
		
		remove(oldCanvas);

		add((Canvas) newCanvas.newInstance());
//		revalidate();
	}
}
