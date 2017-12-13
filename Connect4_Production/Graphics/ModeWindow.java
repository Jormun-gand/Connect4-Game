package Graphics;

import java.awt.FlowLayout;
import javax.swing.*;

public class ModeWindow extends JFrame {
	private JButton pvpButton;
	private JButton pvcButton;
	
	public ModeWindow() {
		super("Select Mode");
		JLabel label = new JLabel();		
		label.setText("	 Choose the mode of the game  "); 
		pvpButton = new JButton("Two Player");
		pvcButton = new JButton("Player vs Computer");
		
		setSize(300, 200);
		setLocation(700, 300);
		setLayout(new FlowLayout());
		add(label);
		add(pvpButton);
		add(pvcButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	public JButton getPvpButton(){
		return pvpButton;
	}
	public JButton getPvcButton(){
		return pvcButton;
	}	
}