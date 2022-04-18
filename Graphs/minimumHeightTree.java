//leetcode 310
//finding the centroid of tree or a graph use topological sorting
import java.util.*;
class minimumHeightTree{
	public static  List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n <= 2){
        	List<Integer> list = new ArrayList<>();
        	for(int i = 0; i < n; i++){
        		list.add(i);
        	}
        	return list;
        }

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
        	g.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for(int[] e : edges){
        	int s = e[0];
        	int d = e[1];
        	g.get(s).add(d);
        	g.get(d).add(s);
        	indeg[s]++;
        	indeg[d]++;
        }

		//add in the queue whose indegree is 1;
		for(int i = 0; i < n; i++){

			//addding all the leaf nodes as leaf is the only vertex having degree one
			if(indeg[i] == 1){
				q.add(i);
			}
		}
		int remaining = n;
		while(remaining > 2){
			remaining -= q.size();
			int k = q.size();
			//add all the nbrs and decrease their indegree
			for(int i = 0; i < k; i++){
				int r = q.remove();
				for(int nbr : g.get(r)){
					indeg[nbr]--;

					if(indeg[nbr] == 1){
						q.add(nbr);       
					}
				}
			}
		}
		List<Integer> ans = new ArrayList<>();
		int s = q.size();
		for(int i = 0; i < s; i++){
			ans.add(q.remove());
		}

		return ans;
    }
	public static void main(String[] args){
		int n = 6;
		int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
		System.out.println(findMinHeightTrees(n, edges)); 
	}
}