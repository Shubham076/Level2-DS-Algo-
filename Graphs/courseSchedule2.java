import java.util.*;
class courseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int v = numCourses;
		int e = prerequisites.length;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			graph.add(i, new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			int a = prerequisites[i][0];
			int b = prerequisites[i][1];
			graph.get(b).add(a);
		}

		int[] indeg = new int[v];
		int[] ans = new int[v];
		int idx = 0;
		Queue<Integer> q = new ArrayDeque<>();

		// calculate indegree of each vertex
		for (int i = 0; i < v; i++) {
			for (int nbr : graph.get(i)) {
				indeg[nbr]++;
			}
		}

		//add in the queue whose indegree is 0;
		for (int i = 0; i < v; i++) {
			if (indeg[i] == 0) {
				q.add(i);
			}
		}


		while (q.size() > 0) {
			int r = q.remove();
			ans[idx] = r;
			idx++;

			//add all the nbrs and decrease their indegree
			for (int nbr : graph.get(r)) {
				indeg[nbr]--;

				if (indeg[nbr] == 0) {
					q.add(nbr);
				}
			}
		}
		if (idx == v) {
			return ans;
		} else {
			return new int[0];
		}
	}
}