//leetcode 834
import java.util.*;
class sumDistancesInAtree {
	//bruteforce O(N^2) using level order traversal from each node or bfs in case of graph
	public static int[] sumOfDistancesInTree(int n, int[][] edges) {
		int[] ans = new int[n];
		int[] visited = new int[n];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		for (int i = 0; i < n; i++) {
			visited = new int[n];
			ans[i] = bfs(i, graph, visited);
		}

		return ans;
	}

	public static int bfs(int n, ArrayList<ArrayList<Integer>> graph, int[] visited) {
		Queue<Integer> q = new ArrayDeque<>();
		int cnt = 0;
		q.add(n);
		visited[n] = 1;
		int level = 0;
		while (q.size() > 0) {
			int s = q.size();
			while (s-- > 0) {
				int r = q.remove();
				cnt += level;
				for (int c : graph.get(r)) {
					if(visited[c] == 0){
						visited[c] = 1;
						q.add(c);
					}
				}
			}
			level++;
		}
		return cnt;
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