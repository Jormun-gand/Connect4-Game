package Graphics;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Board extends JFrame{
	
	//new public constants
	public static final int ROW_NUM=6;
	public static final int COL_NUM=7;
	
	private final int boardLength=1200;
	private final int boardHeight=800;
	
	private final int fieldLength=700;
	private final int fieldHeight=boardHeight;
	private final int checkerSize=87;
	
	private JPanel contentPane=new JPanel();
	private TextPanel textPanel=new TextPanel();
	
	private ColorButton redButton;
	private ColorButton blueButton;
	
	private PlayerTextPanel redPanel;
	private PlayerTextPanel bluePanel;
	
	
	public Board(){
		//set the name of the frame
		super("Connect Four");
		//set the size of the window, and set its close operation
		
		this.setBounds(200, 200, boardLength, boardHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set the color of the frame to make it looks better		
		contentPane.setBackground(Color.white);
		
		contentPane.setLayout(null);
		
		
		//now we can start to draw stuff, lets draw the "battle field" first
		BattleField battleField=new BattleField(fieldLength,fieldHeight,checkerSize);
		battleField.setBounds((boardLength-battleField.getFieldLength())/2,0,battleField.getFieldLength(),battleField.getFieldHeight());
		contentPane.add(battleField);
		//the red button
		redButton=new ColorButton(Color.red,checkerSize);
		redButton.setBounds((boardLength-battleField.getFieldLength())/4-checkerSize/2,checkerSize,checkerSize,checkerSize);
		redPanel=new PlayerTextPanel(Color.red);
		redPanel.setBounds((boardLength-battleField.getFieldLength())/4-checkerSize/2-30,checkerSize/2,150,30);
		contentPane.add(redButton);
		contentPane.add(redPanel);
		//the blue button
		blueButton=new ColorButton(Color.blue,checkerSize);
		blueButton.setBounds((boardLength-battleField.getFieldLength())/2+battleField.getFieldLength()+checkerSize/2,checkerSize,checkerSize,checkerSize);
		bluePanel=new PlayerTextPanel(Color.blue);
		bluePanel.setBounds((boardLength-battleField.getFieldLength())/2+battleField.getFieldLength()+checkerSize/2-30,checkerSize/2,150,30);
		contentPane.add(blueButton);
		contentPane.add(bluePanel);
		//also a button panel that contains "new game" and "check valid"
		ButtonPanel buttonPanel=new ButtonPanel();
		buttonPanel.setBounds(0, 600,250,100);
		contentPane.add(buttonPanel);
		//last but not least, a place that displays textual informations
		
		textPanel.setBounds(30,300,200,200);
		contentPane.add(textPanel);
		
		
		//finally, put our contentPane into the frame and make it visible
		setContentPane(contentPane);
		setVisible(true);
		
		
	}
	public TextPanel getTextPanel(){
		
		return textPanel;
	}
	
	public PlayerTextPanel getRedPanel(){
		return redPanel;
	}
	public PlayerTextPanel getBluePanel(){
		return bluePanel;
	}
	
	
}
