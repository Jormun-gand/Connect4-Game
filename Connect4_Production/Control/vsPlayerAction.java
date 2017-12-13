package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graphics.BattleField;
import Graphics.Board;
import Graphics.Column;
import Graphics.Identity;
import Graphics.ModeWindow;
import Graphics.PlayerTextPanel;
import Graphics.TextPanel;
import Graphics.TextStatus;
import Model.Model;

public class vsPlayerAction implements ActionListener{
	private TextPanel textPanel;
	private ModeWindow mode;
	private PlayerTextPanel redPanel;
	private PlayerTextPanel bluePanel;
	private Board b;
	
	public vsPlayerAction(TextPanel textPanel, ModeWindow mode, PlayerTextPanel redPanel,PlayerTextPanel bluePanel, Board b){
		//need to have access to the textPanel 
		this.textPanel=textPanel;
		this.mode = mode;
		this.redPanel = redPanel;
		this.bluePanel= bluePanel;
		this.b = b;
	}
	@Override
	public void actionPerformed(ActionEvent vsPlayer) {
		
		
		//instruct model to start a game
		int startPlayer=Model.randomStart();
		//instruct graphics to clean up the board
		BattleField.clearBoard();
		//display starting informations
		textPanel.setTextStatus(startPlayer==1? TextStatus.RedFirst:TextStatus.BlueFirst);
		MouseAction.setColor(startPlayer);
		MouseAction.restart();
		
		redPanel.setIdentity(Identity.Player);
		bluePanel.setIdentity(Identity.Player);
		
		
		for (Column c:BattleField.getCoumnList()){
			if (ConnectFourMain.signed[c.getColNum()]!=1)		{
				
			c.addMouseListener(new MouseAction(c.getColNum(),c,b.getTextPanel()));
			ConnectFourMain.signed[c.getColNum()]=1;
																}
													}
		MouseAction.setModeInt(2);
		mode.dispose();
		}
}
