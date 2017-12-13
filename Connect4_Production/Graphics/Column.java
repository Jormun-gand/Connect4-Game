package Graphics;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;



public class Column extends JPanel{
	private int colNum;
	private static int checkerSize;
	//need a "slotList" to keep track of the slots
	private Slots[] slotList=new Slots[Board.ROW_NUM];
	//also contains an indicator on the top(kind of like an arrow pointing downward)
	private Indicator i;
	Column(int colNum,int checkerSize){
		this.colNum=colNum;
		this.checkerSize=checkerSize;
		this.setPreferredSize(new Dimension(checkerSize+1,checkerSize*9));
		//add the indicator
		i=new Indicator(checkerSize);
		
		this.add(i);
		//add the space
		Space k=new Space(checkerSize);
		this.add(k);
		
		for (int j=0;j<Board.ROW_NUM;j++){
			//six of those components (lets call them slots) in every column				
			Slots s=new Slots(checkerSize);
			slotList[j]=s;
			this.add(s);
			
			
		}
		
	}
	public void redrawIndicator(Color c){
		//change the color of the indicator
		i.setIndicateColor(c);
		//update the indicator
		i.repaint();
	}
	public void placeChecker(int slot,Color c){
		//assume the "slot" argument is from 1~6, representing which row to put the checker in
		slotList[slot].setSlotColor(c);
		slotList[slot].repaint();
	}
	//new method!
	public void victoryUpdate(int slot, boolean b){
		//update the checkers that connects to 4
		slotList[slot].setWinFour(b);
		slotList[slot].repaint();
	}
	//updated!
	public void clearColumn(){
		for(int i=0;i<Board.ROW_NUM;i++){
			//set all slots to white
			placeChecker(i,Color.white);
			//also, remove any winning indicators
			victoryUpdate(i,false);
		}
	}
	public static int getCheckerSize(){return checkerSize;}
	
	public int getColNum(){
		return colNum;
	}
	
}
