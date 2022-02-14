/*
leetcode 685

cases3 
1 the graph only contains cycle then apply dsu to find the redundant edge
2 if one node have 2 parents means we one node have a indegree of 2
so blacklist the edge that is making the indegree 2 and check if cycle is not there means blacklisted edge is the answer

3 the graph has cycle and a node has indegree of 2
remove the blaclisted edge and check whether cycle still exist or not
if(cycle not present) blacklisted edge is the answer
otherwise the next edge of that node is the answer 

dsu application
*/

class redundantConnection2{
	static int[] par;
	static int[] rank;
	static int find(int n){
		if(par[n] == n){
			return n;
		}
		int temp = find(par[n]);
		par[n] = temp;
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

	public static int[] findRedundantDirectedConnection(int[][] edges) {
    	int n = edges.length;
    	par = new int[n + 1];  //1 based indexing
    	rank = new int[n + 1];
    	int[] indeg = new int[n + 1];  //indegree array
    	for(int i = 1; i <= n; i++){
    		par[i] = i;
    		rank[i] = 1;
    		indeg[i] = -1;
    	}
    	int bl1 = -1;  //blacklist 1  the edge that is making the indegree of node 2
    	int bl2 = -1; //blacklist 2  he edge that is making the indegree of node 1 
    	for(int i = 0; i < edges.length; i++){
    		int u = edges[i][0];
    		int v = edges[i][1];

    		if(indeg[v] == -1){
    			//means indegree = 1;
    			indeg[v] = i; //storing the index of edge that is making indegree = 1
    		}
    		else{
    			//means indegree = 2
				bl1 = i;
				bl2 = indeg[v];
    		}
    	}


    	//applying dsu
    	for(int i = 0; i < edges.length; i++){
    		if(bl1 == i){
    			//skipping the blacklist edge
                continue;
            }
            /*
				skipping the blacklist edge
				case 3 
				if after skipping the blacklist node cycle still exist means we have blacklisted the wrong edge bl2 is answer
				
				case 2 || case 3
				else (cycle is not present) means the blacklisted edge is the correct answer (bl1)

            */
    		int u = edges[i][0];
    		int v = edges[i][1];
    		boolean flag = union(u, v);

    		if(flag == true){
    			if(bl1 == -1){
    				// case1 only cycle in present no node have two parent
    				return new int[] {u, v};
    			}
    			else{
    				// case3 cycle is present and node have 2 parents
    				return edges[bl2];
    			}
    		}
    	}
    	return edges[bl1];   //handling case 2 and case3    
    }
}