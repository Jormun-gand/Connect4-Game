package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import Graphics.TextPanel;
import Graphics.TextStatus;
import Model.Model;

public class SaveAction implements ActionListener{
	
	private TextPanel textPanel;
	public SaveAction(TextPanel textPanel){
		//need to have access to the textPanel 
		this.textPanel=textPanel;
	}
	public void actionPerformed(ActionEvent save) {
		
		if (MouseAction.getStatus()!="RedWin" && MouseAction.getStatus()!= "BlueWin"){
		try {
			PrintStream s=new PrintStream(new File("save/Saved Game.txt"));
			//write the number representing the color of the current player
			s.println(MouseAction.getColor());
			//then, write the board informations onto the board
			int[][] b=Model.getChessBoard();
			for (int[] i:b){			
				for (int j:i){
					s.print(""+j+",");
				}
				s.println();
			}
			s.println(MouseAction.getIdentInt()); // +-1
			s.println(MouseAction.getModeInt());  // +-2
			
			textPanel.setTextStatus(TextStatus.SaveSuccess)	;
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			textPanel.setTextStatus(TextStatus.SaveFailed);
		}
		}else 
			textPanel.setTextStatus(TextStatus.SaveFailed);
		}
	

}
