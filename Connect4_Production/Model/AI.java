package Model;

public class AI {

	// bestMove[0] 鐢ㄤ簬瀛榗omputer 鐨勯�夋嫨
	// bestMove[1] 鐢ㄤ簬瀛樺湪miniMax涓洜涓洪渶瑕佹瘮杈冩暟鎹ぇ灏�, 鑰屽偍瀛樻暟鎹�
	public static int[] bestMove = new int[2];

	private static final int DIFFICULTY = 8;// represents the depth of recursion
											// when ai thinks, must be a
											// multiple of 2
	private static final int WIN_VALUE = 10000;
	private static final int LOSE_VALUE = -10000;
	private int[][] board = new int[Model.ROW_NUM][Model.COL_NUM];
	private int AIColor;
	private int opponentColor;

	// 鐢ㄤ簬澶嶅埗褰撳墠game state 缁檆omputer 璁＄畻

	public AI(int AIColor) {
		this.AIColor = AIColor;
		opponentColor = (AIColor == 1 ? 2 : 1);
	}

	/*-------------------------------------------------------------*/
	/*-------------------------------------------------------------*/
	/*-------------------------------------------------------------*/
	/*-------------------------------------------------------------*/
	public int makeMove() {
		for (int i = 0; i < Model.ROW_NUM; i++) {
			for (int j = 0; j < Model.COL_NUM; j++) {
				board[i][j] = Model.getChessBoard()[i][j];
			}
		}
		double maxValue = 2. * Integer.MIN_VALUE;
		int move = 0;
		for (int column = 0; column < Model.COL_NUM; column++) {
			// if the move is valid
			if (Model.getFloor(column) >= 0) {

				double value = moveValue(column);
				System.out.print(value + " ");
				if (value > maxValue) {
					maxValue = value;
					move = column;
					if (value == WIN_VALUE) {
						break;
					}
				}
			}
		}
		System.out.println();
		System.out.println(move);
		return move;
	}

	private double moveValue(int column) {
		// To determine the value of a move, first
		// make the move, estimate that state and
		// then undo the move again.
		int row = Model.getFloor(column);
		board[row][column] = AIColor;
		int val = miniMax(DIFFICULTY, Integer.MIN_VALUE, Integer.MAX_VALUE,
				false);
		board[row][column] = 0;
		return val;
	}

	private int miniMax(int depth, int alpha, int beta, boolean isMaxPlayer) {
		// count 涓哄伓鏁�, 鎵� max, 涓哄鏁� 鎵� mini
		boolean hasWinner = check4();
		if (depth == 0 || hasWinner) {
			if (hasWinner) {
				// if it is the maximum player, then the minimum player's move
				// won the game
				return (isMaxPlayer ? LOSE_VALUE : WIN_VALUE)/(DIFFICULTY-depth+1);
			} else {
				return evaluate(board);
			}
		}
		if (isMaxPlayer) {
			// try to make a move in every column
			for (int column = 0; column < Model.COL_NUM; column++) {
				// make a move
				int row = getFloor(column);
				if (row >= 0) {
					board[row][column] = AIColor;

					// the ai will predict which move the player will
					// take
					alpha = Math.max(alpha,
							miniMax(depth - 1, alpha, beta, false));
					// 'undo' the move
					board[row][column] = 0;
					if (beta <= alpha) {
						break;
					}
				}
			}
			// after we have the scores for every move, we find and return the
			// move with the maximum score
			return alpha;

		} else {
			// the minimum player benefits from negative score
			for (int column = 0; column < Model.COL_NUM; column++) {
				int row = getFloor(column);
				if (row >= 0) {
					board[row][column] = opponentColor;

					beta = Math
							.min(beta, miniMax(depth - 1, alpha, beta, true));
					// 'undo' the move
					board[row][column] = 0;
					if (beta <= alpha) {
						break;

					}

				}
			}
			return beta;
		}
	}

	/*-------------------------------------------------------------*/
	/*-------------------------------------------------------------*/
	/*-------------------------------------------------------------*/
	/*-------------------------------------------------------------*/
	
	private int getFloor(int column){
		for(int row = Model.ROW_NUM-1; row >= 0; row--) {
		      if(board[row][column] == 0)
		        return row;    // return the first empty row position from bottom to top
		    }
		    return -2;    // this column is full
	}
	// 缁欒姹傛儏鍐垫墦鍒�
	private int evaluate(int[][] board) {

		int advantage = 0;
		/*
		 * boolean isPositive; // first, check the horizontal situation to see
		 * who has more advantage for (int[] rows : board) { // check every 4
		 * adjacent spot combinations for the advantages // starting from
		 * 3(checking row[3,2,1,0]) for (int i = 3; i < Model.COL_NUM; i++) { //
		 * for every checker in the four, check its adjacent spots. // score
		 * rule: empty--1, friendly--5, out of bound or checker of // others --
		 * clear all points for (int spot = i - 3; spot <= i; spot++) { //
		 * first, identify the checker int point = 0; if (rows[spot] == AIColor)
		 * isPositive = true; else if (rows[spot] == 0) continue; else
		 * isPositive = false;
		 * 
		 * } } }
		 */
		return advantage;
	}

	// check the whole board
	private boolean check4() {

		for (int i = 0; i < Model.COL_NUM; i++) {
			for (int j = 0; j < Model.ROW_NUM; j++) {
				if (check4_2(j, i))
					return true;
				if (check4_4(j, i))
					return true;
				if (check4_6(j, i))
					return true;
				if (check4_8(j, i))
					return true;
			}
		}

		return false; // four connected
	}

	// check bottom right
	private boolean check4_2(int y, int x) {
		if ((x + 3) < 7 && (y + 3) < 6) {
			int count = 0;
			for (int i = 0; i < 3; i++) {
				if (board[y][x] != 0 && board[y][x] == board[++y][++x])
					count += 1;
			}
			if (count == 3)
				return true;
			else
				return false;
		} else
			return false;
	}

	// check bottom left
	private boolean check4_4(int y, int x) {
		if ((x - 3) >= 0 && (y + 3) < 6) {
			int count = 0;
			for (int i = 0; i < 3; i++) {
				if (board[y][x] != 0 && board[y][x] == board[++y][--x])
					count += 1;
			}
			if (count == 3)
				return true;
			else
				return false;
		} else
			return false;
	}

	// check right
	private boolean check4_6(int y, int x) {
		if ((x + 3) < 7) {
			int count = 0;
			for (int i = 0; i < 3; i++) {
				if (board[y][x] != 0 && board[y][x] == board[y][++x])
					count += 1;
			}
			if (count == 3)
				return true;
			else
				return false;
		} else
			return false;
	}

	// check bottom
	private boolean check4_8(int y, int x) {
		if ((y + 3) < 6) {
			int count = 0;
			for (int i = 0; i < 3; i++) {
				if (board[y][x] != 0 && board[y][x] == board[++y][x])
					count += 1;
			}
			if (count == 3)
				return true;
			else
				return false;
		} else
			return false;
	}

}

/*-------------------------------------------------------------*/
/*-------------------------------------------------------------*/
/*-------------------------------------------------------------*/
/*-----------------------------A2------------------------------*/
/*-------------------------------------------------------------*/
/*-------------------------------------------------------------*/

