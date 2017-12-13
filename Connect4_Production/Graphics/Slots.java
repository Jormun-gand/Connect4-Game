package Graphics;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.Graphics;
	
	import javax.swing.JComponent;


public class Slots extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7807942240204941256L;
	private int radius;
	private Color slotColor=Color.white;
	
	//new variables!
	private boolean winFour=false;
	//the size of the indicator
	private int indicateRadius;
	
	Slots(int radius){
		this.radius=radius;
		this.indicateRadius=radius/10;
		
		setPreferredSize(new Dimension((radius+1),(radius+1)));
		
	}
	
	//updated
	@Override
	public void paintComponent(Graphics g){
		//draw the slot(circle inside rectangle)
		super.paintComponent(g);
		g.setColor(slotColor);
		g.fillOval(0,0,radius,radius);
		//if a player wins, draw the indicator as well
		if (winFour){
			g.setColor(Color.black);
			g.fillOval((radius-indicateRadius)/2,(radius-indicateRadius)/2,indicateRadius,indicateRadius);
		}
		g.setColor(Color.black);
		g.drawOval(0, 0, radius, radius);
		g.drawRect(0, 0, radius, radius);
		
		
	}
	public void setSlotColor(Color c){
		this.slotColor=c;
	}
	//new method!
	public void setWinFour(boolean b){
		winFour=b;
	}
}
