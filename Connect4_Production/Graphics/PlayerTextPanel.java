package Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


public class PlayerTextPanel extends JPanel{
	
	private Identity identity=Identity.Nothing;
	private Color color;
	private final int xText=0;
	private final int yText=20;
	
	PlayerTextPanel(Color color){
		this.color=color;
		this.setPreferredSize(new Dimension(150,30));
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//draw textual information based on the current state
		g.setColor(color);
		g.setFont(new Font("Serif", Font.PLAIN, 20));
		g.drawString(color==Color.blue? "Blue: ":"Red : ", xText, yText);
		switch(identity){		
		case Player:
			g.drawString("Player", xText+50, yText);
			break;
		case AI:
			g.drawString("Computer", xText+50, yText);
			break;
		default:
			break;
		}
	}
	
	public void setIdentity(Identity t){
		//set the textStatus, then update it
		identity=t;
		repaint();
		
	}
	
}
	