/*
Terms:
Residual Graph of a flow network is a graph which indicates additional possible flow. If there is a path
from source to sink in residual graph, then it is possible to add flow. Every edge of a residual graph
has a value called residual capacity which is equal to original capacity of the edge minus current flow.
Residual capacity is basically the current capacity of the edge.

Augmenting path: A path from source to sink in the residual network whose purpose is to increase the flow in 
original one. It is important to note that edges in the path can point in the wrong direction

Bottleneck value: minimum capacity in the augmenting path

Backedges main purpose is to undo the mistake done by dfs.
we can travel in the backedges in the residual network if it has capacity.


Algorithm:
1: Initialize flow in all edges to be zero.
2: while (there is augmenting path between source and sink){
	: augment the flow between source and sink along the path
    : update residual network
}
https://practice.geeksforgeeks.org/problems/find-the-maximum-flow2126/1
O(max_flow * E) is we use dfs else O(v * E * E) using BFS (edmund karp)
*/
import java.util.*;
class maxFlow_Ford_FulkerSon{
	static boolean bfs(int s, int d, int[][] graph, int[] par){
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] vis = new boolean[par.length];
		q.add(s);
		vis[s] = true;
		while(q.size() > 0){
			int rm = q.remove();

			//travelling on the neighbours
			for(int j = 0; j < graph[0].length; j++){
				if(vis[j] == false && graph[rm][j] != 0){
					q.add(j);
					vis[j] = true;
					par[j] = rm;
				}
			}
		}

		//returning that we have reached the deatination or not
		return vis[d];
	}
	static int solve(int n, int M, ArrayList<ArrayList<Integer>> Edges) { 
		int[][] graph = new int[n][n];
		int[] par = new int[n];
		for(ArrayList<Integer> e: Edges){	
			int s = e.get(0) - 1;
			int d = e.get(1) - 1;
			int wt = e.get(2);
			graph[s][d] += wt;
			graph[d][s] += wt;
		}
		int ans = 0;
		while(bfs(0, n - 1, graph, par)){
			//find the minimum edge weight in the path / bottleneck value
			int min = Integer.MAX_VALUE;
			for(int i = par.length - 1; i != 0; i = par[i]){
				int u = par[i];
				int v = i;
				min = Math.min(min, graph[u][v]);
			}
			
			ans += min;

			//augmenting the path values
			for(int i = par.length - 1; i != 0; i = par[i]){
				int u = par[i];
				int v = i;
				graph[u][v] -= min;
				graph[v][u] += min;
			}
		}
		return ans;
    }
}