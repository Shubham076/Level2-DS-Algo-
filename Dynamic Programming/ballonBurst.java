/*
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted
with a number on it represented by an array nums. You are asked to burst all
the balloons. 
If you burst the ith balloon, you will get nums[i - 1] * nums
[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array,
then treat it as if there is a balloon with a 1 painted on it. Return the
maximum coins you can collect by bursting the balloons wisely.


we use that a particular ballon is last to be burst all ballons to the left and right are already burst
eg    2 1345 6
here we have to calculate the maximum val we can generate from 1345 ? 
 1: Let us assume 1 is last ballon to be burst 3, 4, 5 are already burst so cost c1 = 0 + 2 * 1 * 6 + cost(345); 
 1: Let us assume 3 is last ballon to be burst 1, 4, 5 are already burst so cost c2 = cost(1) + 2 * 3 * 6 + cost(45); 
 1: Let us assume 4 is last ballon to be burst 1, 3, 5 are already burst so cost c3 = cost(13) + 2 * 4 * 6 + cost(5); 
 1: Let us assume 5 is last ballon to be burst 1, 3, 4 are already burst so cost c4 = cost(134) + 2 * 5 * 6 + 0;

 so max val we can have from busting 1345  = max(c1, c2 ,c3, c4);

 no the generic formula
   2  1  3   4  5  6
      i         j
      k
  we have to find the max cost from i to j 
  we use third variable k that will travel from i to j
  cost of left = k == i ? 0 : [i][k - 1]
  cost of right = k == j ? 0 : [k + 1][j]
  val to be burst = [i - 1] * [k] * [j + 1]; 
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