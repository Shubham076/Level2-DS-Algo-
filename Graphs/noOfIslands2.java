/* lintcode 434  {dsu application}
Given a n, m which means the row and column of the 2D matrix and
an array of pair A( size k). Originally, the 2D matrix is all 0 which means
there is only sea in the matrix. The list pair has k operator and each
operator has two integer A[i].x, A[i].y means that you can change the grid
matrix[A[i].x][A[i].y] from sea to island. Return how many island are there
in the matrix after each operator.You need to return an array of size K.
O(q) where q is the number of queries
*/
import java.util.*;
class noOfIslands2 {
	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	static int[] par;
	static int[] rank;
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, { -1, 0}};
	static int cnt;
	public static int find(int x) {
		if (par[x] == x) {
			return x;
		}
		int temp = find(par[x]);
		par[x] = temp;
		return temp;
	}

	public static void union(int x, int y) {
		int lx = find(x);
		int ly = find(y);

		if (lx != ly) {
			cnt--;
			if (rank[lx] > rank[ly]) {
				par[ly] = lx;
			}
			else if (rank[ly] > rank[lx]) {
				par[lx] = ly;
			} 
			else {
				par[lx] = ly;
				rank[ly]++;
			}
		}
	}
	public static List<Integer> numIslands2(int n, int m, Point[] operators) {
		List<Integer> ans = new ArrayList<>();
		if (operators == null || operators.length == 0) {
			return ans;
		}
		rank = new int[n * m];
		par = new int[n * m];
		cnt = 0;
		Arrays.fill(par, -1);

		for (Point p : operators) {
			int r = p.x;
			int c = p.y;
			int cell = r * m + c;  //2d to 1d mapping
			if (par[cell] != -1) {
				ans.add(cnt);
				continue;
			}

			//set is defining the land
			par[cell] = cell; 
			rank[cell] = 1;
			cnt++;

			for (int[] dir : dirs) {
				int x = r + dir[0];
				int y = c + dir[1];
				int newCell = x * m + y;
				if (x < 0 || y < 0 || x >= n || y >= m || par[newCell] == -1) {
					continue;
				}
				union(cell, newCell);
			}
			ans.add(cnt);
		}
		return ans;
	}
}