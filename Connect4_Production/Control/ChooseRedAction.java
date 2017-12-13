package Control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import Graphics.BattleField;
import Graphics.Board;
import Graphics.ColorChoose;
import Graphics.Column;
import Graphics.Identity;
import Graphics.ModeWindow;
import Graphics.PlayerTextPanel;
import Graphics.TextPanel;
import Graphics.TextStatus;
import Model.AI;
import Model.Model;

public class ChooseRedAction implements ActionListener {
	private TextPanel textPanel;
	private ModeWindow mode;
	private PlayerTextPanel redPanel;
	private PlayerTextPanel bluePanel;
	private Board b;
	private ColorChoose colorChoose;

	public ChooseRedAction(TextPanel textPanel, ModeWindow mode,
			PlayerTextPanel redPanel, PlayerTextPanel bluePanel, Board b,
			ColorChoose colorChoose) {
		this.textPanel = textPanel;
		this.mode = mode;
		this.redPanel = redPanel;
		this.bluePanel = bluePanel;
		this.b = b;
		this.colorChoose = colorChoose;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// instruct model to start a game
		int startPlayer = Model.randomStart();
		// instruct graphics to clean up the board
		BattleField.clearBoard();
		// display starting informations
		textPanel.setTextStatus(startPlayer == 1 ? TextStatus.RedFirst
				: TextStatus.BlueFirst);

		MouseAction.setColor(startPlayer);
		if (startPlayer == 1) {
			MouseAction.setIdentInt(1);
		} // -1 for AI's turn, +1 for player

		MouseAction.restart();

		redPanel.setIdentity(Identity.Player);
		bluePanel.setIdentity(Identity.AI);
		
		
		// MouseAction.setAIis(2);

		for (Column c : BattleField.getCoumnList()) {
			if (ConnectFourMain.signed[c.getColNum()] != 1) {
				c.addMouseListener(new MouseAction(c.getColNum(), c, b
						.getTextPanel()));
				ConnectFourMain.signed[c.getColNum()] = 1;
			}
		}

		// new stuff!
		AI ai = new AI(2);
		MouseAction.setModeInt(-2);
		MouseAction.setAI(ai);

		if (startPlayer == 2) {
			MouseAction.setIdentInt(-1);
			int aiMove = ai.makeMove();
			for (Column c : BattleField.getCoumnList()) {
				if (c.getColNum() == aiMove) {
					c.placeChecker(Model.Move(aiMove, 2), Color.BLUE);
				}
			}
			MouseAction.setIdentInt(1);
			MouseAction.setColor(1);
		}
		colorChoose.dispose();
		mode.dispose();

	}

}
