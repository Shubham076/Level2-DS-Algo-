//leetcode 827
import java.util.*;
class makingALargeisland {
	static int[] par;
	static int[] size;

	static int find(int n) {
		if (par[n] == n) {
			return n;
		}
		int temp = find(par[n]);
		return par[n] = temp;
	}

	static boolean union(int x, int y) {
		int lx = find(x);
		int ly = find(y);
		if (lx != ly) {
			if (size[lx] >= size[ly]) {
				par[ly] = lx;
				size[lx] += size[ly];
			} else if (size[ly] > size[lx]) {
				par[lx] = ly;
				size[ly] += size[lx];
			}
			return true;
		} else {
			return false;
		}
	}
	static int[][] dirs = {{ -1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public int largestIsland(int[][] arr) {
		int n = arr.length;
		size = new int[n * n];
		par = new int[n * n];
		for (int i = 0; i < size.length; i++) {
			size[i] = 1;
			par[i] = i;
		}

		boolean hasZero = false;
		for (int i = 0 ; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					hasZero = true;
					continue;
				} else {
					//grouping of all adjacent ones
					int x = i * n + j;
					for (int[] dir : dirs) {
						int nx = i + dir[0];
						int ny = j + dir[1];
						if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] == 0) {
							continue;
						}
						int y = nx * n + ny;
						union(x, y);
					}
				}
			}
		}
		int ans = 1;
		if (!hasZero) {
			return n * n;
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 0) {
						int cnt = 0;
						HashSet<Integer> uparent = new HashSet<>();
						//adding the size of all unique adjacent sparents and competing with global answer
						for (int[] dir : dirs) {
							int nx = i + dir[0];
							int ny = j + dir[1];
							if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] == 0) {
								continue;
							}
							int x = nx * n + ny;
							int p = find(x);
							if (!uparent.contains(p)) {
								cnt += size[p];
								ans = Math.max(cnt + 1, ans);  //plus because we can convert atmost 1 zero to one
								uparent.add(p);
							}
						}
					}
				}
			}
			return ans;
		}
	}
}