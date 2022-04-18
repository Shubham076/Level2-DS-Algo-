/*

Given an array arr[] consisting of N positive integers representing the lengths of N ropes and a positive integer K,
the task is to find the maximum length of the rope that has a frequency of at least K by cutting
any ropes in any number of pieces.

algo:
Find the mid-value of the range [low, high] and store it in a variable say mid.
Traverse the array arr[] and find the count of ropes of length mid that can be obtained by cutting the ropes and 
store it in a variable say, count.
If the value of count is at least K, then update the value of mid as ans and update the value of low as (mid + 1).
Otherwise, update the value of high as (mid – 1).
*/
import java.util.*;

class MaxRopeLengthOfFrequencyK {
	public static void main(String[] args){ 
		Integer[] arr = {5, 2, 7, 4, 9};
		int k = 5;

		int lo = 1, hi = Collections.max(Arrays.asList(arr));
		int ans = 0;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;

			int cnt = 0;
			for(int i = 0; i < arr.length; i++) {
				cnt += arr[i] / mid;
			}

			if(cnt >= k) {
				ans = mid;
				lo = mid + 1;
			}
			else {
				hi = mid - 1;
			}
		}
		System.out.println(ans);
	}
}