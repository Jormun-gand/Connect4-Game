package Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;



public class ButtonPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8726704462364227154L;
	//contains two buttons: new game and check valid
	private static JButton newGame=new JButton("New Game");
	//removed "CheckValid" button
	//new variables!
	private static JButton saveGame=new JButton("Save Game");
	private static JButton restoreGame=new JButton("Restore Game");
	
	ButtonPanel(){
		//add the buttons to the panel		
		add(newGame);
		add(saveGame);
		add(restoreGame);
	}
	
	public static JButton getNewGame(){
		return newGame;
	}
	//removed "getCheckValid" method
	
	//new methods!
	public static JButton getSaveGame(){
		return saveGame;
	}
	public static JButton getRestoreGame(){
		return restoreGame;
	}
	
}
