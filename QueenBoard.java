public class QueenBoard{
  public static void main(String[] args) {
    QueenBoard q = new QueenBoard(8);
    q.addQueen(1,1);
    System.out.println(q.addQueen(2,2));
    System.out.println(q.toString());

    System.out.println(q.removeQueen(1,1));
    System.out.println(q.toString());

    // System.out.println(q.solve()) ;
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
    if (board[r][c] != 0){
      return false;
    }

    board[r][c] = -1;

    // Horizontal markers
    for (int x = r; x < board.length; x++){
      if (board[r][x] != 0 && x != c){
        return false;
      }
      if (x != c){
        board[r][x]++;
      }
    }

    // Vertical Markers
    for (int i = c; i < board[c].length; i++){
      if (board[i][c] == -1 && i != r){
        return false;
      }
      if (i != r){
        board[i][c]++;
      }
    }

    // Diagonal Markers
      for (int r1 = r; r1 < board.length; r1++){
        for (int c1 = 0; c1 < board[r1].length; c1++){

          if (r1 == r || Math.abs(r - r1) == c - c1 || Math.abs(r - r1) == Math.abs(c - c1) || c1 == c){
            if (board[r1][c1] == 0) board[r1][c1]++;
          }
        }
      }
      return true;
}


  private boolean removeQueen(int r, int c){
    if (board[r][c] != -1) return false;

    board[r][c] = 0;

    // Essentially parse through the same way, just remove stuff this time.
    for (int r1 = r; r1 < board.length; r1++){
      for (int c1 = 0; c1 < board[r1].length; c1++){
        if (board[r1][c1] > 0){
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
   public boolean solve(){
     return solver(0, false);
   }

   public boolean solver(int row, boolean parsed){
     if (board.length > 0 && row == board.length) return true;

     if (parsed == false){
       try{
         for (int x = 0; x < board.length; x++){
           for (int y = 0; y < board[x].length; y++){
             if (board[x][y] != 0){
               throw new IllegalStateException(); // Per website instructions
             }
           }
         }
         parsed = true;
       }
       catch (IllegalStateException e){
         e.printStackTrace();
         return false;
       }
     }


     for (int x = 0; x < board.length; x++){ // Parse through the board
       if (addQueen(row, x)){
         if (solver(row+1, parsed)){
           return true;
         }
         removeQueen(row, x);
       }
      }

     //   if (addQueen(row, x) && solver(row+1, parsed)) return true;  // Check if adding a queen solves the board
     //   removeQueen(row, x); // If not, remove it.
     // }
     System.out.println("HERE");
     return false;

 }
   //
   // /**
   // *@return the number of solutions found, and leaves the board filled with only 0's
   // *@throws IllegalStateException when the board starts with any non-zero value
   // */
   // public int countSolutions(){}

}
