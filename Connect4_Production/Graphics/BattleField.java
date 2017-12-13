package Graphics;

import java.awt.Dimension;


import javax.swing.JPanel;


public class BattleField extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6567276953220242121L;
	private int fieldLength,fieldHeight;
	private int checkerSize;
	private static Column[] columnList=new Column[Board.COL_NUM];

	BattleField(int fieldLength,int fieldHeight,int checkerSize){
		this.fieldLength=fieldLength;
		this.fieldHeight=fieldHeight;
		this.checkerSize=checkerSize;
		this.setPreferredSize(new Dimension(fieldLength,fieldHeight));
		
		//the battle field is made up of 7*6 squares inside a circle, we can draw them using a for loop
		//need to calculate the radius of circles
			
		
		for (int j=0;j<Board.COL_NUM;j++){
			//seven columns in total
			columnList[j]=new Column(j,checkerSize);
			this.add(columnList[j]);
			
			
		}
		
		
	}
	public int getFieldLength(){
		return fieldLength;
	}
	public int getFieldHeight(){
		return fieldHeight;
	}
	public int getCheckerSize(){
		return checkerSize;
	}
	public static void clearBoard(){
		//to clear up the board, simply clear up all columns
		for (Column c:columnList){
			c.clearColumn();
		}
	}
	//new method!
	public static void setVictory(int column,int row){
		columnList[column].victoryUpdate(row,true);
	}
	public static Column[] getCoumnList(){
		return columnList;
	}
	
}
