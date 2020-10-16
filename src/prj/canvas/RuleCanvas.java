package prj.canvas;

import java.awt.Canvas;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import prj.entity.RuleButton;
import prj.entity.RuleBackground;

public class RuleCanvas extends Canvas{
	
	public static RuleCanvas instance;
	private RuleBackground background;
	private RuleButton button;
	
	public RuleCanvas() {
		instance = this;
		background = new RuleBackground();
		button = new RuleButton();
	
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				int x =e.getX();
				int y =e.getY();
				
				if(button.click(x,y)) {
					try {
						prj.GameFrame.instance.switchCanvas(RuleCanvas.this, GameCanvas.class);
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	
//	@Override
//	public boolean mouseDown(Event evt, int x, int y) {
//		if(button.click(x,y)) {
//			try {
//				prj.GameFrame.instance.switchCanvas(RuleCanvas.this, GameCanvas.class);
//			} catch (InstantiationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return super.mouseDown(evt, x, y);
//		
//		}
//		return super.mouseDown(evt, x, y);
//	}
	
	@Override
	public void paint(Graphics g) {
		Image buf = this.createImage(this.getWidth(), getHeight());
		Graphics bg = buf.getGraphics();
					
		background.paint(bg);
		button.paint(bg);	
		
		g.drawImage(buf, 0, 0, this);//
	}
}
