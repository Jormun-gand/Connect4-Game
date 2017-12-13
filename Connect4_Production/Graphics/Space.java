package Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


import javax.swing.JComponent;


public class Space extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7807942240204941256L;
	private int radius;
	
	
	Space(int radius){
		this.radius=radius;
		this.setLayout(null);
		setPreferredSize(new Dimension((radius+1), ((radius+1))));
		
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//draw the space (just a rectangle without the top line
		g.drawRect(0, 0, radius, radius);
		g.setColor(Color.white);
		g.drawLine(0, 0, radius, 0);		
		
	}
}
