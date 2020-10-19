package prj;

import java.awt.Canvas;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

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
		ruleCanvas = new RuleCanvas();
		gameCanvas = new GameCanvas();
		add(introCanvas);
		setSize(1250, 730);
		setVisible(true);

		File bgm = new File("res/bgm.wav");

		try {

			AudioInputStream stream = AudioSystem.getAudioInputStream(bgm);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void switchCanvas(RuleCanvas oldCanvas, Class newCanvas)
			throws InstantiationException, IllegalAccessException {

		remove(oldCanvas);

		add((Canvas) newCanvas.newInstance());
		revalidate();

	}

	public void switchCanvas(IntroCanvas oldCanvas, Class newCanvas)
			throws InstantiationException, IllegalAccessException {

		remove(oldCanvas);

		add((Canvas) newCanvas.newInstance());
		revalidate();
	}

}
