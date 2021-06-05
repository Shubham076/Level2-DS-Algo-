/*
articulation or critical points => if removing a node from the graph results in increasing the number of connected components then
that point is critical node or articulation point

bridge = if removing a edge from the graph results in increasing the number of connected components then
that edge is called bridge.

//back edge  = it is an edge that connects a vertex to a vertex that is discovered before it's parent.
//back edge always detects cycle in a graph

//discovery time is the at which node is doscovered in the dfs

lowest time = For every node u, the minimum discovery time that can be reached from subtree rooted with u.
*/

import java.util.*;
class articulationPoints{
	static HashSet<Integer> a_pts;
	static ArrayList<String> bridges;
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int v = scn.nextInt();
		int e = scn.nextInt();
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for(int i = 0; i < v; i++){
			g.add(i, new ArrayList<>());
		}

		for(int i = 0; i < e; i++){
			int s = scn.nextInt();
			int d = scn.nextInt();
			g.get(s).add(d);
			g.get(d).add(s);
		}

		int[] lt = new int[v];   // lowest time
		int[] dt = new int[v]; // discovery time
		int t = 0;
		a_pts = new HashSet<>();
		bridges = new ArrayList<>();
		dfs(0, -1, dt, lt, t, g);
		// System.out.println(g);

		System.out.println("Articuation points are: " + a_pts);
		System.out.println("Bridges are: " + bridges);
	}

	public static void dfs(int cur, int par, int[] dt, int[] lt, int t, ArrayList<ArrayList<Integer>> g){
		dt[cur] = lt[cur] = t++;
		int no_of_child = 0;

		for(int child : g.get(cur)){
			if(dt[child] == 0){
				dfs(child, cur, dt, lt, t, g);
				lt[cur] = Math.min(lt[cur] , lt[child]);
				no_of_child++;

				//condition for articulation points
				if(par != -1 && lt[child] >= dt[cur]){
					a_pts.add(cur);
				}

				//condition for bridges
				if(par != -1 && lt[child] > dt[cur]){
					bridges.add(cur + "-" + child);
				}
			}
			else if(child != par){
				//backedge cycle found
				lt[cur] = Math.min(lt[cur] , dt[child]);
			}
		}


		//condition for root node
		if(par == -1 && no_of_child >= 2){
			a_pts.add(cur);
		}
	}

}