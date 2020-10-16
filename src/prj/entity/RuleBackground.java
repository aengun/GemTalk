package prj.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Toolkit;

import prj.canvas.RuleCanvas;

public class RuleBackground {
	
	private double x;
	private double y;
	private double width;
	private double height;
	private Image img;
	
	public RuleBackground() {
		this(0,0,"res/ruleback.png");
	}

	public RuleBackground(double x, double y, String imgSrc) {
	
		this.x = x;
		this.y = y;
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage(imgSrc);
		
		width = img.getWidth(null);
		height = img.getHeight(null);
		
	}

	public void paint(Graphics g) {
		int w = RuleCanvas.instance.getWidth();
		int h = RuleCanvas.instance.getHeight();
		
		g.drawImage(img, (int)x, (int)y,w,h, RuleCanvas.instance);
	}
	
	
}
