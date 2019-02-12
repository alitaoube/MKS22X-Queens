public class QueenBoard{
  public static void main(String[] args) {
    QueenBoard q = new QueenBoard(8);
    // q.addQueen(1,1);
    // System.out.println(q.addQueen(5,7));
    // System.out.println(q.toString());
    // q.removeQueen(5,7);
    // System.out.println(q.toString());
    //
    // System.out.println(q.removeQueen(5,7));
    // System.out.println(q.toString());

    // System.out.println(q.solve());
    // System.out.println(q.toString());

    System.out.println(q.countSolutions());
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

  private boolean addQueen(int r, int c){

    if (board[r][c] == 0){
      board[r][c] = -1;
      for (int x = r; x < board.length; x++){
        for (int y = 0; y < board[x].length; y++){
          if (x == r || y == c || Math.abs(r - x) == c - y || Math.abs(r - x) == Math.abs(c - y)){
            if (board[x][y] == 0) board[x][y] = r+1;
            }
          }
        }
        return true;
      }
    return false;
  }


  private boolean removeQueen(int r, int c){
    if (board[r][c] != -1) return false;

    board[r][c] = 0;

    // Essentially parse through the same way, just remove stuff this time.
    for (int r1 = r; r1 < board.length; r1++){
      for (int c1 = 0; c1 < board[r1].length; c1++){
        if (board[r1][c1] == r+1){
          board[r1][c1] = 0;
        }
      }
    }
    return true;
  }

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
           output += " Q";
         }
         // else{
         //   output += " " + board[x][y] ;
         // }
         else{
           output += " _";
         }
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


   public boolean solve(){
     if (board[0][0] != 0) throw new IllegalStateException();
     return solver(0);
   }

   public boolean solver(int row){

      if (row >= board.length) {
        return true;
      }

      for (int c = 0; c < board.length; c++){
        System.out.println(row + ", " + c);
        if (addQueen(row, c)){
          if (solver(row+1)) return true;
          removeQueen(row, c);
        }
      }
     return false;
   }

   // /**
   // *@return the number of solutions found, and leaves the board filled with only 0's
   // *@throws IllegalStateException when the board starts with any non-zero value
   // */
   public int countSolutions(){
     return countSolve(0);
   }

   public int countSolve(int r){
     if (r >= board.length) return 1;
     int count = 0;
     for (int x = 0; x < board.length; x++){
       if (addQueen(r, x)){
         count+= countSolve(r+1);
         removeQueen(r, x);
       }
     }
     return count;
   }

}
