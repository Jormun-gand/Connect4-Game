package Model;


import java.util.Random;

public class Model {

/*-------------------------------------------------------------*/
/*-------------------------------------------------------------*/
/*-------------------------------------------------------------*/
/*-----------------------------A3------------------------------*/




/*-------------------------------------------------------------*/
/*-------------------------------------------------------------*/
/*-------------------------------------------------------------*/
/*-----------------------------A2------------------------------*/


  /*
   * Game state e.g. 1 - red, 2 - blue, 0 - no disc
   */
	//new public constants!
	public static final int ROW_NUM=6;
	public static final int COL_NUM=7;
	
  private static int[][] chessBoard = new int[ROW_NUM][COL_NUM];

  private static int starter;
public static AI t;

  // to start a new game, clean up the board and re-determine the starting
  // player
  public static int randomStart() {
    // first, clean up the board
    chessBoard = initBoard();
    // then, determine who starts first
    Random player = new Random();
    starter = player.nextInt(2) + 1;
    // generated number is either 1 or 2
    
    return starter;
  }

  private static int[][] initBoard() {
    return new int[ROW_NUM][COL_NUM]; 
  }

  // check if it can add more discs or not
  public static boolean isFull() {
    // check if every slot is filled (not zero)
    for (int[] rows : chessBoard) {
      for (int slot : rows) {
        if (slot == 0)
          return false;
      }
    }
    return true;
  }

  public static int Move(int x, int color) {
    int row = getFloor(x);
    if(row >= 0) 
      chessBoard[row][x] = color;

    return row;
  }
  
  static int getFloor(int x) {
    for(int row = ROW_NUM-1; row >= 0; row--) {
      if(chessBoard[row][x] == 0)
        return row;    // return the first empty row position from bottom to top
    }
    return -2;    // this column is full
  }

  
/*  int[][] temp = check4(y, x);
  if temp[0][0] < 0, no four connected; otherwise, get the array: 
              temp[0][] | x1 | x2 | x3 | x4 |
                        - - - - - - - - - - - 
              temp[1][] | y1 | y2 | y3 | y4 |             */
  public static int[][] check4(int y, int x) {
/*    only need to check 4 directions, 2 diagonals, horizontal and vertical
    to do that, sum up the number of identical checkers in such direction and
    see if it is greater or equal to 4  */
    int tl = check4_top_left(y, x);
    int tr = check4_top_right(y, x);
    int bl = check4_bottom_left(y, x);
    int br = check4_bottom_right(y, x);
    int l = check4_left(y, x);
    int r = check4_right(y, x);
    // check top left-bottom right direction
    if (tl + br >= 3) {
      int[][] temp = new int[2][tl + br + 1];
      int column = 0;
      for (int i = 0; i < tl + br + 1; i++) {
        temp[0][column] = br + x--;
        temp[1][column] = br + y--;
        column++;
      }
      return temp;
    }
    // check top right-bottom left direction
    else if (tr + bl >= 3) {
      int[][] temp = new int[2][tr + bl + 1];
      int column = 0;
      for (int i = 0; i < tr + bl + 1; i++) {
        temp[0][column] = x - bl;
        x++;
        temp[1][column] = bl + y--;
        column++;
      }
      return temp;
    }
    // check horizontal direction
    else if (l + r >= 3) {
      int[][] temp = new int[2][l + r + 1];
      int column = 0;
      for (int i = 0; i < l + r + 1; i++) {
        temp[0][column] = r + x--;
        temp[1][column] = y;
        column++;
      }
      return temp;
    }
    // checking vertical connections
    // no need to check top(not possible at all)

    // only one way to connect 4 vertically, no need to change this method
    else if (check4_bottom(y, x)) {
      int[][] temp = new int[2][4];
      int column = 0;
      for (int i = 0; i < 4; i++) {
        temp[0][column] = x;
        temp[1][column] = y++;
        column++;
      }
      return temp;
    } else {
      int[][] temp = new int[2][4];
      temp[0][0] = -1;
      return temp;
    }
  }
  
    
    
  // modified methods
  // check bottom right
  private static int check4_bottom_right(int y, int x) {
    int count = 0;
    while ((x + 1) < COL_NUM && (y + 1) < ROW_NUM && chessBoard[y][x] != 0
        && chessBoard[y][x] == chessBoard[++y][++x]) {
      count += 1;
    }
    return count;
  }

  // check bottom left
  private static int check4_bottom_left(int y, int x) {
    int count = 0;
    while ((x - 1) >= 0 && (y + 1) < ROW_NUM && chessBoard[y][x] != 0
        && chessBoard[y][x] == chessBoard[++y][--x]) {
      count += 1;
    }
    return count;
  }

  // check right
  private static int check4_right(int y, int x) {
    int count = 0;
    while ((x + 1) < COL_NUM && chessBoard[y][x] != 0
        && chessBoard[y][x] == chessBoard[y][++x]) {
      count += 1;
    }
    return count;
  }

  // check bottom, no change to that
  private static boolean check4_bottom(int y, int x) {
    if ((y + 3) < ROW_NUM) {
      int count = 0;
      for (int i = 0; i < 3; i++) {
        if (chessBoard[y][x] != 0 && chessBoard[y][x] == chessBoard[++y][x])
          count += 1;
      }
      if (count == 3)
        return true;
      else
        return false;
    } else
      return false;
  }
  
/*====================================  new methods
====================================   */
  
  // check top left
  private static int check4_top_left(int y, int x) {
    int count = 0;
    while ((x - 1) >= 0 && (y - 1) >= 0 && chessBoard[y][x] != 0
        && chessBoard[y][x] == chessBoard[--y][--x]) {
      count += 1;
    }
    return count;
  }

  // check top right
  private static int check4_top_right(int y, int x) {
    int count = 0;
    while ((x + 1) < COL_NUM && (y - 1) >= 0 && chessBoard[y][x] != 0
        && chessBoard[y][x] == chessBoard[--y][++x]) {
      count += 1;
    }
    return count;
  }

  // check left
  private static int check4_left(int y, int x) {
    int count = 0;
    while ((x - 1) >= 0 && chessBoard[y][x] != 0
        && chessBoard[y][x] == chessBoard[y][--x]) {
      count += 1;
    }
    return count;
  }

  // new methods!
  public static int[][] getChessBoard() {
    return chessBoard;
  }

  public static void setChessBoard(int[][] b) {
    chessBoard = b;
  }
}





