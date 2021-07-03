/*
leetcode 1293 application of topological sort
algorithm
* for placing the items in similar group we create dummy start and end nodes and connect all the nodes in between
 For examples  nodes: (0, 1, 2) belongs to (group number 0) therfore what we will do we create dummy start and dummy end node for this group
 	n = total nodes in graph , m = total number of group in graph
 	dummy start = n + group no * 2 = 3 + 0 * 2 = 3;
	dummy end = n + groupno * 2 + 1 = 3 + 0 * 2 + 1 =  4;

	so after this step graph will look like
	                 3       ..dummy start
                  /  |  \
                0    1    2
                \    |    /
                     4      ..dummy end
from above steps concepts of group is handled


* handling the concept of before
note = -1 means no group is assigned
case 1:  item == -1 && before == -1  =>  simply add directed edge from before -> item
case 2:  item == -1 and before != -1  => add edge directed from (dummy end node of  group of before) -> item
case 3:  item != -1 && before == -1  => add a directed edge from before => (dummy start node of group of item)
case 4:  item != -1 and before != -1 and group number is same  => add a directed edge from before -> item
case 5:  item != -1 and before != -1 and group number is diff  =>  add a directed edge from (dummy end of group of before) -> (dummmy start of group of item)

now graph is created just apply toplogical sort
*/
import java.util.*;
class sortItemsAccordingToDependencies {
	static HashMap<Integer, ArrayList<Integer>> graph;

	public static int[] getDummyNodes(int n, int g) {
		int[] nodes = new int[2];
		nodes[0] = n + g * 2;
		nodes[1] = n + (g * 2) + 1;
		return nodes;
	}

	static int i;
	public static void dfs(int src, int n, int[] ans, int[] indeg) {
		if (src < n) {
			ans[i++] = src;
		}

		indeg[src]--;
		for (int e : graph.get(src)) {
			indeg[e]--;

			if (indeg[e] == 0) {
				dfs(e, n, ans, indeg);
			}
		}
	}
	public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
		graph = new HashMap<>();

		//adding the vertices and nbrs list
		for (int i = 0; i < n + m * 2; i++) {
			graph.put(i, new ArrayList<>());
		}


		//concept of groups
		for (int i = 0; i < n; i++) {
			if (group[i] != -1) {
				int[] dn = getDummyNodes(n, group[i]);
				graph.get(dn[0]).add(i);
				graph.get(i).add(dn[1]);
			}
		}

		//connecting the edges (concept of before)
		for (int i = 0; i < n; i++) {
			int gi = group[i];
			for (int b : beforeItems.get(i)) {
				int gb = group[b];

				if (gi == -1 && gb == -1) {  //case1
					graph.get(b).add(i);
				}
				else if (gi == -1) { //case 2
					int[] dn = getDummyNodes(n, gb);   //getting dummy start and dummy end node
					graph.get(dn[1]).add(i);
				}
				else if (gb == -1) { //case 3
					int[] dn = getDummyNodes(n, gi);
					graph.get(b).add(dn[0]);
				}
				else if (gi == gb) { //case 4
					graph.get(b).add(i);
				} 
				else if (gi != gb) { //case 5
					int[] dni = getDummyNodes(n, gi);  //dummy nodes of item
					int[] dnb = getDummyNodes(n, gb);  //dummy nodes of before
					graph.get(dnb[1]).add(dni[0]);
				}
			}
		}
		i = 0;
		int[] ans = new int[n];
		int[] indeg = new int[n + m * 2];

		for (int i = 0; i < n + m * 2; i++) {
			for (int j : graph.get(i)) {
				indeg[j]++;
			}
		}

		for (int i = 0; i < indeg.length; i++) {
			if (indeg[i] == 0) {
				dfs(i, n, ans, indeg);
			}
		}

		if (i == n) {
			return ans;
		} else {
			return new int[0];
		}
	}
}