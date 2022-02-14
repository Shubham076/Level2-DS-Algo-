/*
https://www.geeksforgeeks.org/k-th-largest-sum-contiguous-subarray/
o(n * n * logk)
*/
import java.util.*;
class kthLargestSubarraySum{
	static void testCase(int[] arr, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] p = new int[arr.length];
		p[0] = arr[0];
		for(int i = 1; i < arr.length; i++){
			p[i] = p[i - 1] + arr[i]; 
		}	
		for(int i = 0; i < arr.length; i++){
			for(int j = i; j < arr.length; j++){
				int sum = p[j] - (i >= 1 ? p[i - 1] : 0);
				pq.add(sum);
				if(pq.size() > k){
					pq.remove();
				}
			}
		}
		System.out.println(pq.peek());
	}
	public static void main(String[] args){
		int[][] tc = {{20, -5, -1}, {10, -10, 20, -40}};
		int[] k = {3, 6};
		int t = tc.length;
		int i = 0;
		while(t-- > 0){
			System.out.print("Case " + i + ": ");
			testCase(tc[i], k[i++]);
		}
	}
}