package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Graphics.BattleField;
import Graphics.Board;
import Graphics.ModeWindow;
import Graphics.TextPanel;
import Graphics.TextStatus;
import Model.Model;

public class RestartAction implements ActionListener{
	private TextPanel textPanel;
	private Board b;
	public RestartAction(TextPanel textPanel,Board b){
		//need to have access to the textPanel 
		this.textPanel=textPanel;
		this.b=b;
	}
	@Override
	public void actionPerformed(ActionEvent restart) {
//		//instruct model to start a game
//		int startPlayer=Model.randomStart();
//		//instruct graphics to clean up the board
//		BattleField.clearBoard();
//		//display starting informations
//		textPanel.setTextStatus(startPlayer==1? TextStatus.RedFirst:TextStatus.BlueFirst);
//		MouseAction.setColor(startPlayer);
//		MouseAction.restart();
		
		
		// pick "two players" or "vs computer"
		// call method from Graphics
		//PopUP pu = new PopUP();
//		pu.getvsC().addActionListener(new vsPlayerAction(textPanel, pu));
//		pu.getvsP().addActionListener(new vsPlayerAction(textPanel, pu));
//		pu.setVisible(true);
		
		ModeWindow mode = new ModeWindow();
		mode.getPvcButton().addActionListener(new vsCompAction(b.getTextPanel(),mode,b.getRedPanel(),b.getBluePanel(),b));
		mode.getPvpButton().addActionListener(new vsPlayerAction(b.getTextPanel(),mode,b.getRedPanel(),b.getBluePanel(),b));
	}

}
