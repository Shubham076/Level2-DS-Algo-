/*
leetcode 787
application of bellaman ford
as in ith iteration bellman ford given shortest distance for ith path length
here we have to find the shortest within k stops means  s -- >  ...kstops   --> dest
simply have to find the shortest cost to dest having path length of k + 1;  //1 based indexing

why we used 2 arrays instead of one because in ith iteration bellman ford given shortest distance for atleast ith path length.
to ensure that after each iteration minimum distance for ith path length is calculated we use 2 arrays cur and prev;
initially make 2 identical;
use prev to calculate cur; 
*/
import java.util.*;
class cheapestFlightWithinKStops{
	public int findCheapestPrice(int n, int[][] flights, int src, int des, int k) {
		int[] cur = new int[n];
		int[] prev = new int[n];
		Arrays.fill(prev, Integer.MAX_VALUE);
		for(int i = 0; i < n; i++){
			cur[i] = prev[i] = Integer.MAX_VALUE;
		}
		prev[src] = cur[src] = 0;
		for(int i = 1; i <= k + 1; i++){
			for(int[] e: flights){
				int s = e[0];
				int d = e[1];
				int wt = e[2];

				if(prev[s] != Integer.MAX_VALUE && prev[s] + wt < cur[d]){
					cur[d] = prev[s] + wt;
				}
			}
			for(int j = 0; j < n; j++){
				prev[i] = cur[i];
			}
		}

		return prev[des] != Integer.MAX_VALUE ? prev[des] : -1;
    }
}