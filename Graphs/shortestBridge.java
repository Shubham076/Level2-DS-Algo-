/*leetcode 934
travserse the array once
Time complexity O(n * n) + O(V + E);

in this problem we have to connect two islands with each other with min number of zero flipped
so what we do we make the entire one island to 2 and then apply bfs from the second island whose value is still one
the moment we find the 2 again in the bfs return the answer
*/
import java.util.*;
class shortestBridge {
	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public static void dfs(int[][] grid, int i ,int j, int[][] visited){
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1 || visited[i][j] == 1){
			return;
		}
		visited[i][j] = 1;
		grid[i][j] = 2;

		for(int[] dir: dirs){
			int x = i + dir[0];
			int y = j + dir[1];
			dfs(grid, x, y, visited);
		}
	}
	public static int shortestBridge(int[][] grid) {
		Queue<int[]> q = new ArrayDeque<>();
		int n = grid.length;
		boolean found = false;
		int m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1 && !found) {
					//first island (make the entire connected component 2)
					dfs(grid, i, j, new int[n][m]);
					found = true;
				} else if (grid[i][j] == 1 && found) {
					q.add(new int[] {i, j});
				}
			}
		}

		//bfs
		int level = 0;
		while (q.size() > 0) {

			int s = q.size();
			while (s-- > 0) {
				int[] rm = q.remove();
				for (int[] dir : dirs) {
					int x = rm[0] + dir[0];
					int y = rm[1] + dir[1];

					if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 1) {
						continue;
					} else if (grid[x][y] == 2) {
						return level;
					} else {
						grid[x][y] = 1;
						q.add(new int[] {x, y});
					}
				}
			}
			level++;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] arr = {{1, 1, 1, 1, 1}, 
					   {1, 0, 0, 0, 1},
					   {1, 0, 1, 0, 1},
					   {1, 0, 0, 0, 1},
					   {1, 1, 1, 1, 1}};
		System.out.println(shortestBridge(arr));
	}
}