	//leetcode 542
class zeroOneMatrix {
	static int[][] dir = {{0, 1} , {1, 0} , {0 , -1} , { -1 , 0}};
	static class Pair {
		int i;
		int j;
		public Pair(int i , int  j) {
			this.i = i;
			this.j = j;
		}
	}
	public int[][] updateMatrix(int[][] arr) {
		int[][] ans = new int[arr.length][arr[0].length];
		Queue<Pair> q = new ArrayDeque<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					ans[i][j] = 0;
					q.add(new Pair(i , j));
				} else {
					ans[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		while (q.size() > 0) {
			Pair p = q.remove();
			int x = p.i;
			int y = p.j;

			for (int[] d : dir) {
				int adjx = x + d[0];
				int adjy = y + d[1];

				if (adjx < 0 || adjy < 0 || adjy >= arr[0].length || adjx >= arr.length || 1 + ans[x][y] > ans[adjx][adjy]) {
					continue;
				}

				ans[adjx][adjy] = 1 + ans[x][y];
				q.add(new Pair(adjx , adjy));
			}
		}
		return ans;
	}
}