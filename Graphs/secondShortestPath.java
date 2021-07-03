/*
You are given a roadmap of country consisting of N cities and M roads. Each
city has 1 traffic light. The traffic light has 2 colors red or green All
traffic lights can switch the color from green to red and vice versa after
every T seconds.You can cross a city only when traffic light in the city is
green. Initially all the traffic lights are green. At a city if traffic light
is red you have to wait for it to switch its color to green. The time taken
to travel any road in C seconds. Find the second minimum amount of time
required to move from city 1 to city N. You can go through a city once. It is
guaranteed that the given roadmap is connected. Graph wont contain multiple
edges and self loops.


Input Format: The first line of input contains 4 space separated integers N
(1 <= N <= 10^3), M(N - 1 <= M <= (N * (N - 1) / 2), T(1 <= T <= 10 ^ 3) and
C(1 <= C <= 10 ^ 3). Next M lines contains two integer each U, V each
denoting there is a bidirectional edge between U and V

Output Format: Print the second minimum amount of time in seconds required to
move from city 1 to city N. If the second minimum does not exist print -1;

Sample Test Case 0
5 4 3 3
1 1
1 2
2 4
3 5

Output: -1


*/
import java.util.*;
class secondShortestPath {
	static ArrayList<ArrayList<Integer>> list;
	static class Pair {
		int v;
		int wsf;
		ArrayList<int[]> edges;
		Pair(int v, int wsf, ArrayList<int[]> edges) {
			this.v = v;
			this.wsf = wsf;
			this.edges = edges;
		}
	}

	public static void addEdge(int[] e) {
		int s = e[0];
		int d = e[1];
		list.get(s).add(d);
		list.get(d).add(s);
	}

	public static void removeEdge(int[] edge) {
		int s = edge[0];
		int d = edge[1];
		for (int i = list.get(s).size() - 1; i >= 0; i--) {
			int el = list.get(s).get(i);
			if (el == d) {
				list.get(s).remove(i);
			}
		}
	}
	public static Pair dikstra(int s, int d, int t, int c) {
		PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.wsf - b.wsf);
		q.add(new Pair(s, 0, new ArrayList<>()));
		int[] visited = new int[list.size()];
		while (q.size() > 0) {
			Pair rm = q.remove();

			if (visited[rm.v] == 1) {
				continue;
			} else {
				visited[rm.v] = 1;
			}

			if (rm.v == d) {
				return rm;
			}
			int wt = 0;
			int x = rm.wsf / t;
			if (x % 2 == 0) {
				wt = 0;
			} else {
				int ceil = (int)Math.ceil(rm.wsf * 1.0 / t);
				if (ceil == 1) {
					wt += t;
				} else {
					wt += ceil * t - rm.wsf;
				}
			}

			for (int e : list.get(rm.v)) {
				if (visited[e] == 0) {
					ArrayList<int[]> edges = new ArrayList<>(rm.edges);
					edges.add(new int[] {rm.v, e});
					q.add(new Pair(e, rm.wsf + c + wt, edges));
				}
			}
		}
		return null;
	}
	public static void findSecondShortest(int[][] edges, int src, int n, int t, int c) {
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}

		for (int[] e : edges) {
			int s = e[0] - 1;
			int d = e[1] - 1;
			list.get(s).add(d);
			list.get(d).add(s);
		}

		int ans = Integer.MAX_VALUE;
		Pair p = dikstra(src - 1, n - 1, t, c);
		if (p == null) {
			System.out.println("Shortest Time: " + -1);
			System.out.println("Second Shortest Time: " + -1);
			return;
		} else {
			System.out.println("Shortest Path: " + p.wsf);
			for (int[] e : p.edges) {
				removeEdge(new int[] {e[0], e[1]});
				removeEdge(new int[] {e[1], e[0]});

				Pair sp = dikstra(src - 1, n - 1, t, c);
				if (sp != null) {
					ans = Math.min(ans, sp.wsf);
				}
				addEdge(e);
			}
		}

		if (ans == Integer.MAX_VALUE) {
			System.out.println("Second Shortest Path: " + -1);
		} else
			System.out.println("Second Shortest Path: " + ans);
	}
	public static void main(String[] args) {
		int[][] arr = {{1, 2},{2, 3},{2, 4},{3,5}};
		int t = 3;
		int c = 3;
		int n = 5;
		findSecondShortest(arr, 1 , n, t, c);
	}
}