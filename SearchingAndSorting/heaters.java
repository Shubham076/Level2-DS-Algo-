//leetcode 475
import java.util.*;
class heaters{
	static class Pair{
		int js = -1;
		int jl = -1;
	}


//calculating ceil and floor value in the array
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
	public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < houses.length; i++){
        	int hn = houses[i];
        	Pair p = helper(heaters, hn);
        	int d1 = p.js == -1 ? Integer.MAX_VALUE : hn - p.js;
        	int d2 = p.jl == -1 ? Integer.MAX_VALUE : p.jl - hn;
        	ans = Math.max(ans, Math.min(d1, d2));
        }
        return ans;
    }

}