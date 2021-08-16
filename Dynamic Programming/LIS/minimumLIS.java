/*
Given an array of integers of size N, you have to divide it into the minimum number of “strictly increasing subsequences” 
For example: let the sequence be {1, 3, 2, 4}, then the answer would be 2. In this case, the first increasing sequence would be {1, 3, 4} and the second would be {2}.

min lis = length of longest decresing subsequence
why ? by finding longest decreasing subsequence we have found minimum no of groups we need
as if any of the elements of lds come in the same group means it is no longer a increasing subsequence
*/
public class minimumLIS {
    public static void main(String[] args){
        int[] arr = {1, 6, 2, 4, 3};
        int[] dp = new int[arr.length];
        int max = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            int val = arr[i];
            int lo = 0;
            int hi = max;

            while(lo < hi){
                int mid = lo + (hi - lo) / 2;
                if(dp[mid] >= val){
                    hi = mid;
                }
                else{
                    lo = mid + 1;
                }
            }

            dp[lo] = val;

            //means the current is greater than all so we can increase the current lis by 1
            if(lo == max){
                max++;
            }
        }
        System.out.println(max);
    }
}
