package Control;

import Graphics.Board;
import Graphics.ButtonPanel;
import Graphics.ModeWindow;

public class ConnectFourMain {
	
	// for keeping track of Column's listeners
	static int[] signed = new int[]{0,0,0,0,0,0,0};
	
	public static void main(String[] args) {
		
		Board b = new Board();
		ModeWindow mode = new ModeWindow();
		mode.getPvcButton().addActionListener(new vsCompAction(b.getTextPanel(),mode,b.getRedPanel(),b.getBluePanel(),b));
		mode.getPvpButton().addActionListener(new vsPlayerAction(b.getTextPanel(),mode,b.getRedPanel(),b.getBluePanel(),b));
		
		ButtonPanel.getNewGame().addActionListener(new RestartAction(b.getTextPanel(),b));
		ButtonPanel.getRestoreGame().addActionListener(new LoadAction(b.getTextPanel()));
		ButtonPanel.getSaveGame().addActionListener(new SaveAction(b.getTextPanel()));
		
		
		
		
/*
		//create the game frame
		Board b=new Board();
		
		//instruct model to start the game
		int startPlayer=Model.randomStart();
		//instruct graphics to clean up the board 
		BattleField.clearBoard();
		//instruct graphics to display starting information
		b.getTextPanel().setTextStatus(startPlayer==1? TextStatus.RedFirst:TextStatus.BlueFirst);
		MouseAction.setColor(startPlayer);
		//add MouseListeners to the checker board
		for (Column c:BattleField.getCoumnList()){
			c.addMouseListener(new MouseAction(c.getColNum(),c,b.getTextPanel()));
		}
		//add actionListeners to the corresponding buttons
		ButtonPanel.getNewGame().addActionListener(new RestartAction(b.getTextPanel()));
		ButtonPanel.getRestoreGame().addActionListener(new LoadAction(b.getTextPanel()));
		ButtonPanel.getSaveGame().addActionListener(new SaveAction(b.getTextPanel()));
		
		
*/	
	}

}
