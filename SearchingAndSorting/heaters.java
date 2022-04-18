/*
leetcode 475
Winter is coming! During the contest, your first job is to design a standard heater with
a fixed warm radius to warm all the houses.
Every house can be warmed, as long as the house is within the heater's warm radius range. 
Given the positions of houses and heaters on a horizontal line, return the minimum radius 
standard of heaters so that those heaters could cover all houses.
*/
import java.util.*;
class heaters{
	static class Pair{
		int js = -1; //just small
		int jl = -1; //just large
	}
//calculating ceil and floor value  of each house in the heaters array
	public static Pair helper(int[] arr, int k){
		Pair p = new Pair();
		int lo = 0;
		int hi = arr.length - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if(arr[mid] == k){
				p.js = arr[mid];
				p.jl = arr[mid];
				return p;
			}
			else if(arr[mid] > k){
				hi = mid - 1;
				p.jl = arr[mid];
			}
			else{
				lo = mid + 1;
				p.js = arr[mid];
			}
		}
		return p;
	}

	// find the ceil and floor of house in the heaters array
	public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < houses.length; i++){
        	int hn = houses[i];  //hn
        	Pair p = helper(heaters, hn);
        	int d1 = p.js == -1 ? Integer.MAX_VALUE : hn - p.js;
        	int d2 = p.jl == -1 ? Integer.MAX_VALUE : p.jl - hn;
        	ans = Math.max(ans, Math.min(d1, d2));
        }
        return ans;
    }
}