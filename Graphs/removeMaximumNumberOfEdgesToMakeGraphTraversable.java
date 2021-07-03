//leetcode 1579 O(elog(e)) + O(e) where e is the number of edges
import java.util.*;
class removeMaximumNumberOfEdgesToMakeGraphTraversable {
	public static int find(int x, int[] par) {
		if (par[x] == x) {
			return x;
		}
		int temp = find(par[x], par);
		par[x] = temp;
		return temp;
	}

	public static boolean union(int x, int y, int[] par, int[] rank) {
		int lx = find(x, par);
		int ly = find(y, par);
		if (lx != ly) {
			if (rank[lx] > rank[ly]) {
				par[ly] = lx;
			}
			 else if (rank[ly] > rank[lx]) {
				par[lx] = ly;
			}
			 else {
				par[lx] = ly;
				rank[ly]++;
			}
			return true;
		}
		else{
			return false;
		}
	}
	public int maxNumEdgesToRemove(int n, int[][] edges) {
		int[] par1 = new int[n];
		int[] rank1 = new int[n];
		int[] par2 = new int[n];
		int[] rank2 = new int[n];

		for (int i = 0; i < n; i++) {
			par1[i] = par2[i] = i;
			rank1[i] = rank2[i] = 1;
		}

		// as to remove maximum number number of edges so we start from the edges that can travelled by both
		//(sorting the edges in descending order of type)
		Arrays.sort(edges, (a, b) -> {
			return b[0] - a[0];
		});

		int edgecnt = 0;
		//traversing edges one by one
		for (int[] e : edges) {
			int t = e[0];
			int s = e[1] - 1; //for zero based indexing
			int d = e[2] - 1;

			if(t == 1 && union(s, d, par1, rank1)){
				edgecnt++;
			}
			else if(t == 2 && union(s, d, par2, rank2)){
				edgecnt++;
			}
			else if(t == 3 && union(s, d, par1, rank1) && union(s, d, par2, rank2)){
				edgecnt++;
			}
		}

		int cnt1 = 0;
		int cnt2 = 0;
		for(int i = 0 ; i < n; i++){
			if(par1[i] == i){
				cnt1++;
			}
			if(par2[i] == i){
				cnt2++;
			}
		}

		//if after adding all the edges the no of connected components in both is equal to 1 then its possible else not possible
		if(cnt1 == 1 && cnt2 == 1){
			return edges.length - edgecnt;
		}
		else{
			return -1;
		}
	}
}