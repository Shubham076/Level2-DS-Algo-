/*
bfs can only be used if the edge weight is same
*/
import java.util.*;
class secondShortestPathUsingBFS {
	static int min1;
	static int min2;
	static ArrayList<ArrayList<Integer>> list;
	static class Pair {
		int v;
		int wsf;
		HashSet<Integer> set;
		Pair(int v, int wsf, HashSet<Integer> set) {
			this.v = v;
			this.wsf = wsf;
			this.set = set;
		}
	}
	public static void bfs(int s, int d, int c) {
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(0, 0, new HashSet<>()));

		while (q.size() > 0) {
			Pair rm = q.remove();
			// System.out.println(rm.v);
			if (rm.v == d) {
				if (min1 == Integer.MAX_VALUE) {
					min1 = rm.wsf;
				} else if (min2 == Integer.MAX_VALUE) {
					min2 = rm.wsf;
					return;
				}
			}

			for (int e : list.get(rm.v)) {
				if (!rm.set.contains(e)) {
					HashSet<Integer> set = new HashSet<>(rm.set);
					set.add(rm.v);
					q.add(new Pair(e, rm.wsf + c, set));
				}
			}
		}
	}
	public static void solve(int[][] edges, int src, int n, int c) {
		list = new ArrayList<>();
		min1 = Integer.MAX_VALUE;
		min2 = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}

		for (int[] e : edges) {
			int s = e[0] - 1;
			int d = e[1] - 1;
			list.get(s).add(d);
			list.get(d).add(s);
		}

		System.out.println(list);

		bfs(src - 1, n - 1, c);
		System.out.println(min1);
		if (min2 == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min2);
		}
	}
	public static void main(String[] args) {
		int[][] arr = {{1, 2}, {2, 3}, {2, 4}, {1, 3}, {3, 5}};
		int c = 3;
		int n = 5;
		solve(arr, 1 , n, c);
	}
}