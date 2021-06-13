//leetcode 834 O(N)
import java.util.*;
class sumDistancesinTree2 {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] cnt;
	static int[] ans;

	//O(n)
	public static int dfs1(int src, int[] visited) {
		visited[src] = 1;
		for (int c : graph.get(src)) {
			if (visited[c] == 0) {
				cnt[src] += dfs1(c, visited);
			}
		}

		cnt[src] += 1;
		return cnt[src];
	}

	public static int bfs(int src, int[] visited) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(src);
		int level = 0;
		visited[src] = 1;
		int cnt = 0;
		while (q.size() > 0) {
			int s = q.size();

			while (s-- > 0) {
				int r = q.remove();
				cnt += level;

				for (int c : graph.get(r)) {
					if (visited[c] == 0) {
						visited[c] = 1;
						q.add(c);
					}
				}
			}
			level++;
		}
		return cnt;
	}

	public static void calcAns(int src , int[] visited, int n) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(src);
		visited[src] = 1;
		while (q.size() > 0) {
			int s = q.size();

			while (s-- > 0) {
				int r = q.remove();

				for (int c : graph.get(r)) {
					if (visited[c] == 0) {
						visited[c] = 1;
						ans[c] = ans[r] - cnt[c] + (n - cnt[c]);
						q.add(c);
					}
				}
			}			
		}
	}

	public static int[] sumOfDistancesInTree(int n, int[][] edges) {
		ans = new int[n];
		cnt = new int[n]; //storing the cnt of nodes in the ith subtree
		graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		dfs1(0, new int[n]); // filling the cnt array;
		ans[0] = bfs(0, new int[n]); //getting the answer for node 0;
		calcAns(0, new int[n], n); // calculating answer using the answer calculated in arr[0] for all the nodes
		return ans;
	}
	public static void main(String[] args) {
		int[][] arr = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
		int n = 6;
		int[] ans = sumOfDistancesInTree(n, arr);
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}
}