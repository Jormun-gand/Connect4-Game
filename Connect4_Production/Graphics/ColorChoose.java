package Graphics;

import java.awt.FlowLayout;
import javax.swing.*;

public class ColorChoose extends JFrame {
	private JButton redButton;
	private JButton blueButton;
	
	public ColorChoose() {
		super("Select colour");
		JLabel label = new JLabel();
		
		label.setText("			 ----Choose the colour you want----		 "); 
		redButton = new JButton("RED");
		blueButton = new JButton("BLUE");
		
		setSize(300, 200);
		setLocation(700, 300);
		setLayout(new FlowLayout());
		add(label);
		add(redButton);
		add(blueButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	public JButton getRedButton(){
		return redButton;
	}
	public JButton getBlueButton(){
		return blueButton;
	}	
}