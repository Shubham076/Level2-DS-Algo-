/*leetcode 778
here we have to find the min of the max
dikstra gives the min
*/
import java.util.*;
class swimInRisingWater{
	static class Pair implements Comparable<Pair>{
		int x;
		int y;
		int max;
		Pair(int x, int y, int max){
			this.x = x;
			this.y = y;
			this.max = max;
		}

		public int compareTo(Pair o){
			return this.max - o.max;
		}
	}
	public static int swimInWater(int[][] grid){
		int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int n = grid.length;
		int m = grid[0].length;
		int[][] visited = new int[n][m];
		Queue<Pair> q = new PriorityQueue<>();
		q.add(new Pair(0, 0, grid[0][0]));

		while(q.size()  > 0){
			Pair rm = q.remove();
			if(visited[rm.x][rm.y] == 1){
				continue;
			}

			visited[rm.x][rm.y] = 1;

			if(rm.x == n - 1 && rm.y == m - 1){
				return rm.max;
			}

			for(int[] dir: dirs){
				int x = rm.x + dir[0];
				int y = rm.y + dir[1];

				if(x < 0 || y < 0 || x >= n || y >= m || visited[x][y] == 1){
					continue;
				}
				q.add(new Pair(x, y, Math.max(rm.max, grid[x][y])));
			}
		}
		return 0;
	}
	public static void main(String[] args){
		int[][] arr = {{0, 2}, {1, 3}};
		System.out.println(swimInWater(arr));
	}
}