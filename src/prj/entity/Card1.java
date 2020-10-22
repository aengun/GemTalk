//package prj.entity;
//
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.Toolkit;
//
//import prj.canvas.GameCanvas;
//
//public class Card1 extends Card {
//
//	private Image img;
//	
//	public Card1() {
//		this.setX(400);
//		this.setY(400);
//		
//		Toolkit tk = Toolkit.getDefaultToolkit();
//		img = tk.getImage("res/cardDeck.png");
//	}
//	
//	@Override
//	public void paint(Graphics g) {
//		int width = img.getWidth(null);
//		int height = img.getHeight(null);
//		
//		g.drawImage(img, getX(),getY(),GameCanvas.instance);
//	}
//
//}
