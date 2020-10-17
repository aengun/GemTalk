package prj.board;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import prj.entity.Player;

public class PlayerBoard {

	private int x; // 플레이어 	보드 좌표 x
	private int y; // 플레이어 보드 좌표 y
	private int width;
	private int height;
	
	private Player player; 

	public PlayerBoard() {
		this(100, 100, 100, 100);
	}
	
	public PlayerBoard(int x, int y, int playerX, int playerY) {
		this.x = x;
		this.y = y;
		
		player = new Player(playerX, playerY);
	}

	// GameCanvas의 paint 메서드로부터 g를 넘겨받음
	public void paint(Graphics g) {
		player.paint(g); // player로 그리는 행위 위임
	}
}
