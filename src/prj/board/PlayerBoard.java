package prj.board;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import prj.entity.Player;

public class PlayerBoard {

	private int x; // 플레이어 보드 좌표 x(직접 쓰이진 않음)
	private int y; // 플레이어 보드 좌표 y
	private int width = 500; // (직접 쓰이진 않음)
	private int height = 500;

	private Player player;

	public PlayerBoard() {
		this(0, 0, 1);
	}

	public PlayerBoard(int x, int y, int imgNum) {
		this.x = x;
		this.y = y;

		player = new Player(x, y, imgNum);
	}

	// GameCanvas의 paint 메서드로부터 g를 넘겨받음
	public void paint(Graphics g) {
		player.paint(g); // player로 그리는 행위 위임
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
