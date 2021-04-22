import java.util.*;

public class solveSudoku {
  public static void display(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
}

  public static void solveSudoku(int[][] board, int row, int col) {
    if ( row == board.length) {
      display(board);
      return;
    }

    int ni = 0;
    int nj = 0;

    if (col == board[0].length - 1) {
      ni = row + 1;
      nj = 0;
    }

    else {
      ni = row;
      nj = col + 1;
    }

    if ( board[row][col] != 0) {
      solveSudoku(board , ni , nj);
    }

    else {
      for ( int num = 1; num <= 9; num++) {

        if (isValid(board , row , col , num)) {
          board[row][col] = num;
          solveSudoku(board , ni , nj);
          board[row][col] = 0;

        }
      }
    }
  }

  public static boolean isValid(int[][] board , int row , int col , int val) {

    //   checking the row
    for (int j = 0; j < board[0].length; j++) {
      if (board[row][j] == val)
        return false;
    }

    //checking column
    for (int i = 0; i < board.length; i++) {
      if (board[i][col] == val)
        return false;
    }

    int xPos = row / 3 * 3;
    int yPos = col / 3 * 3;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[xPos + i][yPos + j] == val)
          return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    solveSudoku(arr, 0, 0);
  }
}
