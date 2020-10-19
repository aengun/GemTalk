package prj;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

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
		setSize(1200, 700);
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

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int input = JOptionPane.showConfirmDialog(GameFrame.this, "게임을 종료하시겠습니까?", "게임 종료",
						JOptionPane.OK_CANCEL_OPTION);

				if (input == JOptionPane.OK_OPTION)
					System.exit(0);
			}

		});

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
