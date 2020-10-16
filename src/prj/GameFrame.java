package prj;

import java.awt.Frame;

import prj.canvas.GameCanvas;

public class GameFrame extends Frame {
	
	private GameCanvas canvas;
	
	public GameFrame() {
		canvas = new GameCanvas();
		
		setSize(360, 600);
		setVisible(true);
	}
}
