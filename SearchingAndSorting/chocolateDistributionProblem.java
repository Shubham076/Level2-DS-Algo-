/*gfg 
Given an array of n integers where each value represents the number of
 chocolates in a packet. Each packet can have a variable number of
 chocolates. There are m students, the task is to distribute chocolate
 packets such that: 

Each student gets one packet. The difference between the number of chocolates
in the packet with maximum chocolates and packet with minimum chocolates
given to the students is minimum.

intuition we can use sliding window to find min and max of each window of size m
*/
import java.util.*;
class chocolateDistributionProblem{
	public static long findMinDiff (int[] a, int n, int m){
        Arrays.sort(a);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= n - m; i++){
        	int min = a[i];
        	int max = a[i + m - 1];
        	ans = Math.min(max - min, ans);
        }
        return ans;
    }
	public static void main(String[] args){
		int[] arr = {7, 3, 2, 4, 9, 12, 56};
		int m = 3;
		System.out.println(findMinDiff(arr, arr.length, m));
	}
}