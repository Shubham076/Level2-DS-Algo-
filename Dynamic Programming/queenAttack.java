/*
On a N * M chessboard, where rows are numbered from 1 to N and columns from 1 to M,
there are queens at some cells. Return a N * M  array A, where A[i][j] is number of queens
that can attack cell (i, j). While calculating answer for cell (i, j), assume there is no queen
at that cell.

Notes:
Queen is able to move any number of squares vertically, horizontally or diagonally on a chessboard.
A queen cannot jump over another queen to attack a position.You are given an array of N strings, each
of size M. Each character is either a 1 or 0 denoting if there is a queen at that position or not,
respectively.
Expected time complexity is worst case O(N*M).
*/
class queenAttack {
	public static void fill(int[][] ans, int[][] board, int i, int j) {
		int[][] dirs = {{1, 1}, {1, -1}, { -1, 1}, { -1, -1}, {0, 1}, {0, -1}, {1, 0}, { -1, 0}};
		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			while (x >= 0 && y >= 0 && x < ans.length && y < ans.length) {
				ans[x][y] += 1;
				if (board[x][y] == 1) {
					break;
				}
				x += dir[0];
				y += dir[1];
			}
		}
	}
	public static void main(String[] args) {
		int[][] arr = {{0, 1, 0}, {1, 0, 0}, {0, 0, 1}};
		int[][] ans = new int[arr.length][arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					fill(ans, arr, i, j);
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}