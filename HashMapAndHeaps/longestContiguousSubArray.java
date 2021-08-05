/*
https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
*/

import java.util.*;
class longestContiguousSubArray{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int ans = 0;
		for(int i = 0; i < n; i++){
			arr[i] = scn.nextInt();
		}
		HashSet<Integer> set;
		for(int i = 0; i < n - 1; i++){
			int max = arr[i];
			int min = arr[i];
			set = new HashSet<>();
			set.add(arr[i]);
			for(int j = i + 1; j < n; j++){
				if(set.contains(arr[j])){
					break;
				}

				set.add(arr[j]);
				min = Math.min(min , arr[j]);
				max = Math.max(max , arr[j]);
				if(max - min == j - i){
					int len = j - i + 1;
					if(len > ans){
						ans = len;
					}
				}
			}
		}

		System.out.println(ans);
	}
}