//leetcode 994
import java.util.*;
class rottingOranges {
	static class Pair {
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int[][] dirs = {{1, 0}, { -1, 0}, {0, 1}, {0, -1}};
	public int orangesRotting(int[][] grid) {

		// adding rotten oranges to the queue
		Queue<Pair> q = new ArrayDeque<>();

		int n = grid.length;
		int m = grid[0].length;
		int freshCnt = 0;
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2)
					q.add(new Pair(i , j));

				if (grid[i][j] == 1) {
					freshCnt++;
				}
			}
		}

		if (freshCnt == 0) return 0;
		int minutes = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair rp = q.remove();
				for (int[] dir : dirs) {
					int x = rp.i + dir[0];
					int y = rp.j + dir[1];

					if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0 || grid[x][y] == 2) continue;
					grid[x][y] = 2;  //make rotten
					freshCnt--;
					q.add(new Pair(x, y));

				}
				minutes++;
			}
		}

		return freshCnt == 0 ? minutes - 1 : -1;
	}
}