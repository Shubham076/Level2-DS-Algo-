import java.util.*;

public class branchAndBoundNQueen {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    //write your code here
    boolean[] col = new boolean[n];
    boolean[] nd = new boolean[2 * n - 1];
    boolean[] rd = new boolean[2 * n - 1];
    
    // nd= normal diagonal rd =  reverse diagonal
    
    solve(board , 0 , "" , col , nd , rd);
    
  }
  
  public static void solve(boolean[][] board, int row ,String ans , boolean[] col , boolean[] nd , boolean[] rd){
      
      if( row == board.length){
          System.out.println(ans+".");
          return;
      }
      
      for(int j = 0; j < board[0].length; j++){
          
          if(col[j] == false && nd[row + j] == false && rd[row -  j + board[0].length -1] == false){
              board[row][j] = true;
              col[j] = true;
              nd[row + j] = true;
              rd[row - j + board[0].length - 1]  = true;
              
              solve(board , row + 1 ,ans + row + "-" + j + ", " , col , nd ,rd);
              
              board[row][j] = false;
              col[j] = false;
              nd[row + j] = false;
              rd[row - j + board[0].length - 1]  = false;
              
          }
      }
  }   

}