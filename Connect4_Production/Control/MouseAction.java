package Control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Graphics.BattleField;
import Graphics.Column;
import Graphics.Identity;
import Graphics.TextPanel;
import Graphics.TextStatus;
import Model.AI;
import Model.Model;

public class MouseAction implements MouseListener {

	private int columnNum;
	private Column c;
	private static int color;

	// new variables!
	static String status = "";
	private TextPanel textPanel;
	private final int RED = 1;
	private final int BLUE = 2;

	private static int modeInt; // 2 for pvp; -2 for pvc
	private static AI ai;
	private static int identInt; // 1 for player -1 for AI

	// private static int AIis;

	// mouse listener for each column

	// construct a mouseAction

	// added a new parameter to constructor (TextPanel)
	public MouseAction(int column, Column c, TextPanel t) {
		this.columnNum = column;
		this.c = c;
		this.textPanel = t;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (!status.equals("RedWin") && !status.equals("BlueWin")) {
			int y = 0;
			int x = 0;

			// two players mode, set identInt=0 to jump
			if (modeInt == 2) {
				x = columnNum;
				identInt=0;
				y = Model.Move(x, color);
			}

			// players turn
			if (identInt == 1) {
				x = columnNum;

				// call from graphic to put a chess at x,y
				y = Model.Move(x, color);
				c.placeChecker(y, color == RED ? Color.red : Color.blue);
				
			}

			else if (identInt == -1) {	
				 x= ai.makeMove();
				for (Column c : BattleField.getCoumnList()) {
					if (c.getColNum() ==x) {
						// this column place a checker
						y = Model.Move(c.getColNum(), color);
						c.placeChecker(y, color == RED ? Color.red : Color.blue);
					}
				}
			}

			// call from graphic to put the chess
			if (y >= 0) {
				// assignment2 change color after putting checker
				// reset color of indicator
				// change the color
				color = (color == RED ? BLUE : RED);
				c.redrawIndicator(color == RED ? Color.red : Color.blue);
				int[][] t = Model.check4(y, x);
				if (t[0][0] >= 0) {
					// update the connected checkers
					for (int i = 0; i < t[0].length; i++) {
						BattleField.setVictory(t[0][i], t[1][i]);
					}
					// since the play order has changed, the previous player is
					// actually the winner
					if (color == RED)
						status = "BlueWin";
					else if (color == BLUE)
						status = "RedWin";
				} else if (Model.isFull() == true)
					status = "Draw";
				else{
						status = "InProgress";
				}
				identInt = (identInt == 1 ? -1 : 1);
				if (identInt == -1) {
					
					mouseClicked(e);
				}
			} 
			else
				status = "BadMove";
			// check for game current progress
			text();
		}
	}

	
	// new method!
	private void text() {
		switch (status) {
		case "Draw":
			textPanel.setTextStatus(TextStatus.Draw);
			break;
		case "RedWin":
			textPanel.setTextStatus(TextStatus.RedWin);
			break;
		case "BlueWin":
			textPanel.setTextStatus(TextStatus.BlueWin);
			break;
		case "InProgress":
			textPanel.setTextStatus(TextStatus.InProgress);
			break;
		case "BadMove":
			textPanel.setTextStatus(TextStatus.Invalid);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// call function from graphic to draw indicator if the game is still
		// going on

		if (modeInt == 2) {
			if (!status.equals("RedWin") && !status.equals("BlueWin"))
				c.redrawIndicator(color == RED ? Color.red : Color.blue);
		} else if (modeInt == -2) {
			if (identInt == -1) {
				c.redrawIndicator(Color.white);
			} else if (identInt == 1) {
				if (!status.equals("RedWin") && !status.equals("BlueWin"))
					c.redrawIndicator(color == RED ? Color.red : Color.blue);
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		// reset the indicator
		c.redrawIndicator(Color.white);
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	// setter for color
	public static void setColor(int color) {
		MouseAction.color = color;
	}

	// new method!
	public static int getColor() {
		return color;
	}

	public static void restart() {
		status = "";
	}

	public static String getStatus() {
		return status;
	}

	public static int getIdentInt() {
		return identInt;
	}

	public static void setIdentInt(int ident) {
		identInt = ident;
	}

	public static void setModeInt(int mode) {
		modeInt = mode;
	}

	public static int getModeInt() {
		return modeInt;
	}

	public static void setAI(AI a) {
		ai = a;
	}
	// public static void setAIis(int AInum){
	// AIis = AInum;
	// }
	// public static int getAIis(){
	// return AIis;
	// }
}
