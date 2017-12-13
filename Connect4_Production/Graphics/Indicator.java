package Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;


public class Indicator extends JComponent{
	private Color indicateColor=Color.white;
	private int checkerSize;
	
	Indicator(int checkerSize){
		this.checkerSize=checkerSize;
		setPreferredSize(new Dimension(checkerSize,checkerSize));
	}
	
	@Override
	public void paintComponent(Graphics g){
		//draw the indicator of the corresponding color
		super.paintComponent(g);
		g.setColor(indicateColor);
		g.fillOval(0, 0, checkerSize, checkerSize);	
		
	}
	public void setIndicateColor(Color c){
		//change the color of indicator
		this.indicateColor=c;
	}
}
