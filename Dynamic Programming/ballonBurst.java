/*
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted
with a number on it represented by an array nums. You are asked to burst all
the balloons. If you burst the ith balloon, you will get nums[i - 1] * nums
[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array,
then treat it as if there is a balloon with a 1 painted on it. Return the
maximum coins you can collect by bursting the balloons wisely.
*/

import java.util.*;
class ballonBurst{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n ; i++){
			arr[i] = scn.nextInt();
		}

		int[][] dp = new int[n][n];
		for(int g = 0; g < n; g++){
			for(int i = 0, j = g; j < n; j++, i++){
				int max = Integer.MIN_VALUE;
				for(int k = i; k <= j; k++){
					int left = k == i ? 0 : dp[i][k - 1];
					int right = k == j ? 0 : dp[k + 1][j];
					int val = (i == 0 ? 1 : arr[i - 1]) * arr[k] * (j == arr.length - 1 ? 1 : arr[j + 1]);
					int total = left + right + val;
					if(total > max){
						max = total;
					}
				}
				dp[i][j] = max;
			}
		}
		System.out.println(dp[0][dp.length - 1]);
	}
}