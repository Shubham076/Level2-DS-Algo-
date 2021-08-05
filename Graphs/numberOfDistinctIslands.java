/*
Description
Given a non-empty 2D array grid of 0's and 1's, an island is a
group of 1's (representing land) connected 4-directionally (horizontal or
vertical). You may assume all four edges of the grid are surrounded by
water.

Count the number of distinct islands. An island is considered to be the same
as another if and only if one island has the same shape as another island
(and not rotated or reflected).

Input:
  [
    [1,1,0,0,1],
    [1,0,0,0,0],
    [1,1,0,0,1],
    [0,1,0,1,1]
  ]
Output: 3
Explanation:
  11   1    1
  1        11
  11
   1
*/
import java.util.*;
class numberOfDistinctIslands {
	static HashSet<String> set;
	static StringBuilder s;
	public static void dfs(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
			return;
		}

		grid[i][j] = 0;

		s.append('U');
		dfs(grid, i - 1, j);

		s.append('L');
		dfs(grid, i, j + 1);

		s.append('D');
		dfs(grid, i + 1, j);

		s.append('R');
		dfs(grid, i, j - 1);
		
	}
	public static int numberofDistinctIslands(int[][] grid) {
		set = new HashSet<>();
		int n = grid.length;
		int m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					s = new StringBuilder("");
					dfs(grid, i, j);
					set.add(s.toString());
				}
			}
		}
		return set.size();
	}
	public static void main(String[] args) {
		int[][] matrix = {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};
		System.out.println(numberofDistinctIslands(matrix));
	}
}