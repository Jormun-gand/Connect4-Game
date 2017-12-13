package Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


public class TextPanel extends JPanel{
	
	private TextStatus textStatus=TextStatus.Nothing;
	private final int xText=25;
	private final int yText=100;
	//Color informations used for AI mode

	TextPanel(){
		this.setPreferredSize(new Dimension(200,200));
	}			
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//draw textual information based on the current state
		g.setColor(Color.red);
		g.setFont(new Font("Serif", Font.PLAIN, 24));
		switch(textStatus){
		case RedFirst: 
			g.drawString("Red goes first!", xText, yText);
			break;
		case BlueFirst:
			g.setColor(Color.blue);
			g.drawString("Blue goes first!", xText, yText);
			break;
		case Draw:
			g.setColor(Color.green);
			g.drawString("Game Drawn!", xText, yText);
			break;
		case RedWin:
			g.drawString("Red Wins!", xText, yText);			
			break;
		case BlueWin:
			g.setColor(Color.blue);
			g.drawString("Blue Wins!", xText, yText);
			break;
		case InProgress:
			g.setColor(Color.green);
			g.drawString("Game In Progress", xText, yText);
			break;
		case Invalid:
			g.drawString("Bad move!",xText, yText);
			break;
		case LoadFail:
			g.drawString("Load failed", xText, yText);
			break;
		case LoadSuccess:
			g.setColor(Color.green);
			g.drawString("Load successful", xText, yText);
			break;
		case SaveFailed:
			g.drawString("Save failed", xText, yText);
			break;
		case SaveSuccess:
			g.setColor(Color.green);
			g.drawString("Save successful", xText, yText);
			break;
		default:
			break;
		}
	}

	public void setTextStatus(TextStatus t){
		//set the textStatus, then update it
		textStatus=t;
		repaint();
		
	}
	
}
