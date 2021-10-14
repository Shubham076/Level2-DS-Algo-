// https://practice.geeksforgeeks.org/problems/euler-circuit-in-a-directed-graph/1
import java.util.*;
class eulerCircuitInUnDirectedGraph{
	public boolean isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj){
        int n = adj.size();
        int[] deg = new int[n];
        for(int i = 0; i < adj.size(); i++){
        	for(int j : adj.get(i)){
        		if(adj.get(i).get(j) == 1){
        			deg[i]++;
        		}
        	}
        }

        int cnt = 0;
        for(int i: deg){
        	if(i % 2 == 0){
        		cnt++;
        	}
        }
        return cnt == n;
    }
}