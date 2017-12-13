package Control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Graphics.BattleField;
import Graphics.Column;
import Graphics.TextPanel;
import Graphics.TextStatus;
import Model.Model;

public class LoadAction implements ActionListener{
	private TextPanel textPanel;
	public LoadAction(TextPanel textPanel){
	//need to have access to the textPanel 
	this.textPanel=textPanel;}
	
	
	
	    
	public void actionPerformed(ActionEvent load) {
			try {
				Scanner input=new Scanner(new File("save/Saved Game.txt"));
				//first line represents the current player
				int color=Integer.parseInt(input.nextLine());
				MouseAction.setColor(color);
				//the next 6 lines represents the board
				int [][] board=new int[Model.ROW_NUM][Model.COL_NUM];
				for (int i=0;i<Model.ROW_NUM;i++){
					//read the line first
					String line=input.nextLine();
					//split the line
					String[] l=line.split(",");
					//convert each to integer and put it into the array
					for (int j=0;j<Model.COL_NUM;j++){
						board[i][j]=Integer.parseInt(l[j]);
					}
				}
				//now we have the array, pass to model
				Model.setChessBoard(board);
				//next, tell graphics to draw stuff
				Column[] columns=BattleField.getCoumnList();
				for (int i=0;i<Model.COL_NUM;i++){
					columns[i].clearColumn();
					for (int k=0;k<Model.ROW_NUM;k++){
						Color c;
						if (board[k][i]==0) c=Color.white;
						else if (board[k][i]==1) c=Color.red;
						else c=Color.blue;
						columns[i].placeChecker(k, c);
					}
				}
				MouseAction.setIdentInt(Integer.parseInt(input.nextLine()));
				MouseAction.setModeInt(Integer.parseInt(input.nextLine()));
				textPanel.setTextStatus(TextStatus.LoadSuccess);
				input.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				textPanel.setTextStatus(TextStatus.LoadFail);
			}
			
	}
	

}
