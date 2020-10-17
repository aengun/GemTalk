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
		add(gameCanvas);
		
		setSize(1200, 700);
		setVisible(true);
		
	}

	public void switchCanvas(RuleCanvas oldCanvas, Class newCanvas) throws InstantiationException, IllegalAccessException {
		//����� �޼ҵ�
		
		remove(oldCanvas);
		
		add((Canvas)newCanvas.newInstance());
	}
}
