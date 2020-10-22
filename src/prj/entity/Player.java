package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import prj.canvas.GameCanvas;

public class Player {

	private int x; // 플레이어 캐릭터 좌표 x
	private int y; // 플레이어 캐릭터 좌표 y
	private int width = 150;
	private int height = 150;
	private Image img;

	private MissionCard missionCard;
	private MyCard myCard;

	public Player() {
		this(0, 0, 1);
	}

	public Player(int pbX, int pbY, int imgNum) {
		switch (imgNum) {
		case 1:
		case 3:
			x = pbX + 350;
			y = pbY + 45;

			missionCard = new MissionCard(x - 120, y - 25);
			myCard = new MyCard(x - 340, y - 25);
			break;
		case 2:
		case 4:
			x = pbX + 20;
			y = pbY + 45;

			missionCard = new MissionCard(x + width + 30, y - 25);
			myCard = new MyCard(x + width + 162, y - 25);
			break;
		}
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/player" + imgNum + ".png");

	}

	public int vote() { // "O"선택 시 input : 0, "X"선택 시 input : 1

		Object options[] = { "O", "X" };
		int input = JOptionPane.showOptionDialog(GameCanvas.instance, "찬성하면 O, 반대하면 X를 눌러주세요", "찬/반 선택", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		return input;
	}

	public void answer(int playTurn) {
//		String answer = JOptionPane.showInputDialog("대답을 입력하세요");
		String answer = JOptionPane.showInputDialog(GameCanvas.instance, "대답을 입력하세요");

		String text = "player"+Integer.toString(playTurn)+"의 대답입니다";
		
		JOptionPane.showMessageDialog(GameCanvas.instance, answer,text,JOptionPane.INFORMATION_MESSAGE);
	}

	// 윈을 체크하는 메소드
	public void onWin() {
//		myCard.getRedCount == missionCard.getCards()[0].getMissionCount();
//		
//		myCard.getOrangeCount == missionCard.getCards()[1].getMissionCount();
//		
//		myCard.getGreenCount == missionCard.getCards()[2].getMissionCount();
//		
//		myCard.getBlueCount == missionCard.getCards()[3].getMissionCount();

//		chanceCount == ?
	}

	public void paint(Graphics g) {
		missionCard.paint(g);
		myCard.paint(g);

		int w = img.getWidth(null);
		int h = img.getHeight(null);
		int x1 = x;
		int y1 = y;
		int x2 = x1 + width;
		int y2 = y1 + height;

		g.drawImage(img, x1, y1, x2, y2, 0, 0, w, h, GameCanvas.instance);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public MyCard getMyCard() {
		return myCard;
	}

	public void setMyCard(MyCard myCard) {
		this.myCard = myCard;
	}

}