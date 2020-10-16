package prj;

import java.awt.Canvas;
import java.awt.Frame;

import prj.canvas.GameCanvas;
import prj.canvas.RuleCanvas;

public class GameFrame extends Frame {
	public static GameFrame instance;
	private RuleCanvas ruleCanvas;
	private GameCanvas gameCanvas;
	
	public GameFrame() {
		instance = this;
		
		ruleCanvas = new RuleCanvas();
		gameCanvas = new GameCanvas();
		add(ruleCanvas);
		
		setSize(870, 500);
		setVisible(true);
		
	}

	public void switchCanvas(RuleCanvas oldCanvas, Class newCanvas) throws InstantiationException, IllegalAccessException {
		//시험용 메소드
		
		remove(oldCanvas);
		
		add((Canvas)newCanvas.newInstance());
		setVisible(true);
	}
}
