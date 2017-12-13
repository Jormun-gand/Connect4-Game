package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graphics.BattleField;
import Graphics.Board;
import Graphics.ColorChoose;
import Graphics.Column;
import Graphics.Identity;
import Graphics.ModeWindow;
import Graphics.PlayerTextPanel;
import Graphics.TextPanel;
import Graphics.TextStatus;
import Model.Model;

public class vsCompAction implements ActionListener{
	private TextPanel textPanel;
	private ModeWindow mode;
	private PlayerTextPanel redPanel;
	private PlayerTextPanel bluePanel;
	private Board b;
	
	public vsCompAction(TextPanel textPanel, ModeWindow mode, PlayerTextPanel redPanel,PlayerTextPanel bluePanel, Board b){
		//need to have access to the textPanel 
		this.textPanel=textPanel;
		this.mode = mode;
		this.redPanel = redPanel;
		this.bluePanel= bluePanel;
		this.b = b;
	}
	@Override
	public void actionPerformed(ActionEvent vsComp) {
		
		
		ColorChoose colorChoose = new ColorChoose(); 
		colorChoose.getRedButton().addActionListener(new ChooseRedAction(b.getTextPanel(),mode,b.getRedPanel(),b.getBluePanel(),b,colorChoose));
		colorChoose.getBlueButton().addActionListener(new ChooseBlueAction(b.getTextPanel(),mode,b.getRedPanel(),b.getBluePanel(),b,colorChoose));
		
		
		}
}
