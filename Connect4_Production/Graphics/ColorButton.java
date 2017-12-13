package Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;



public class ColorButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7196363953902143443L;
	
	private Color c;
	private int radius;
	ColorButton(Color c,int radius){
		this.c=c;
		this.radius=radius;
		this.setPreferredSize(new Dimension(radius,radius));
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		//draw a circle to represent the button
		g.setColor(c);
		g.fillOval(0, 0, radius, radius);
		/*
		g.setColor(Color.black);
		g.fillOval(radius/4, radius/4, radius/10, radius/10);
		g.fillOval(3*radius/4-radius/10, radius/4, radius/10, radius/10);
		g.drawArc(radius/4, radius/2, radius/4, radius/2, -30, 30);
		*/
	}
	public Color getColor(){
		return c;
	}
	
}
