/*
There are N homes in a village, we have to facilitate water supply in each of
them. We can either build a well in a home or connect it with pipe to some
different home already having water supply. More formally, we can either
build a new well in the home or connect it with a pipeline to some different
home which either has it’s own well or further gets water supply from a
different home and so on. There is some cost associated with both building a
new well and laying down a new pipeline. We have to supply water in all homes
and minimise the total cost.

Input-
First line contains an integer N, the number of homes.
The next line contains N integers, the ith integer denotes the cost of building a well in that home.
Next line contains an integer K, then K lines follows. Each of which contains 3 integers i, j and p. Which denotes the cost ‘p’ of laying down pipeline between homes i and j.

Output- Output a single integer - the minimum cost to supply water to all the
homes

create a dummy node and add a edge between all the houses wth dummy nodes with cost = cost to dig well
now apply kruskals to find the minimum spanning tree.

*/
import java.util.*;
class optimizeWaterDistribution{
	static int[] par;
	static int[] rank;
	static class Pair{
		int u;
		int v;
		int w;
		Pair(int u, int v, int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	public static int find(int x){
		if(par[x] == x){
			return x;
		}
		int temp = find(par[x]);
		par[x] = temp;
		return temp;
	}

	public static boolean union(int x, int y){
		int lx = find(x);
		int ly = find(y);

		if(lx == ly){
			return true;
		}
		else{
			if(rank[lx] > rank[ly]){
				par[ly] = lx;
			}
			else if(rank[ly] > rank[lx]){
				par[lx] = ly;
			}
			else{
				par[lx] = ly;
				rank[ly]++;
			}
			return false;
		}
	}	
	public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes){
		Pair[] edges = new Pair[pipes.length + n];
		int idx = 0;
		for(int i = 0; i < pipes.length; i++){
			int s = pipes[i][0];
			int d = pipes[i][1];
			int w = pipes[i][2];
			edges[idx++] = new Pair(s, d, w);
		}

		for(int i = 0; i < wells.length; i++){
			int u = 0; //dummy
			int v = i + 1;
			int w = wells[i];
			edges[idx++] = new Pair(u, v, w);
		}

		//sorting on the basis of cost
		Arrays.sort(edges, (a, b) -> a.w - b.w);
		par = new int[n + 1]; //1 based indexing
		rank = new int[n + 1];
		for(int i = 0; i < n + 1; i++){
			par[i] = i;
			rank[i] = 1;
		}
		int ans = 0;
		for(int i = 0; i < edges.length; i++){
			int u = edges[i].u;
			int v = edges[i].v;
			int w = edges[i].w;
			boolean flag = union(u, v);
			if(flag == false){
				ans += w;
			}
		}
		return ans;
	}
	public static void main(String[] args){
		int n = 3;
		int[] wells = {1, 2, 2};
		int[][] pipes = {{1, 2, 1}, {2, 3, 1}};
		int ans = minCostToSupplyWater(n, wells, pipes);
		System.out.println(n);
	}
}