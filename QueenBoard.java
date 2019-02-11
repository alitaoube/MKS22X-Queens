public class QueenBoard{
  public static void main(String[] args) {
    QueenBoard q = new QueenBoard(8);
    System.out.println(q.toString());
    q.addQueen(2,2);
    System.out.println(q.toString());
  }


  private int[][]board;

  public QueenBoard(int size){
    board = new int[size][size];

    for (int x = 0; x < board.length; x++){
      for (int y = 0; y < board[x].length; y++){
        board[x][y] = 0;
      }
    }
  }
  //
  private boolean addQueen(int r, int c){
    if (board[r][c] == 1){
      return false;
    }

    board[r][c] = -1;


    for (int x = 0; x < board.length; x++){
      if (board[r][x] != 0 && x != c){
        return false;
      }
      if (x != c){
        board[r][x]++;
      }
    }

    for (int i = 0; i < board[c].length; i++){
      if (board[i][c] == -1 && i != r){
        return false;
      }
      if (i != r){
        board[i][c]++;
      }
    }


    for (int x = c, y = r; x < board[x].length && y < board.length; x++, y++){
      System.out.println(board[y][x]);
      board[y][x]++;
      System.out.println(board[y][x]);
    }

    for (int x = c, y = r; x > 0 && y > 0; x--, y--){
      System.out.println(board[y][x]);
      board[y][x]++;
      System.out.println(board[y][x]);
    }

    return true;
  }

  // private boolean removeQueen(int r, int c){
  //   board[r][c] = 0;
  // }

  /**
   *@return The output string formatted as follows:
   *All numbers that represent queens are replaced with 'Q'
   *all others are displayed as underscores '_'
   *There are spaces between each symbol:
   *"""_ _ Q _
   *Q _ _ _

   *_ _ _ Q

   *_ Q _ _"""
   *(pythonic string notation for clarity,
   *excludes the character up to the *)
   */
   public String toString(){
     String output = "";
     for (int x = 0; x < board.length; x++){
       for (int y = 0; y < board[x].length; y++){
         if (board[x][y] == -1){
           output += " Q ";
         }
         else{
           output += " " + board[x][y] + " ";
         }
         // else{
         //   output += " _ ";
         // }
       }
       output += '\n';
     }
     return output;
   }



   /**
   // *@return false when the board is not solveable and leaves the board filled with zeros;
   //
   // *        true when the board is solveable, and leaves the board in a solved state
   //
   // *@throws IllegalStateException when the board starts with any non-zero value
   //
   // */
   // public boolean solve(){}
   //
   // /**
   // *@return the number of solutions found, and leaves the board filled with only 0's
   // *@throws IllegalStateException when the board starts with any non-zero value
   // */
   // public int countSolutions(){}

}
