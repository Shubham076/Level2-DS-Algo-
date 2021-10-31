//https://www.geeksforgeeks.org/max-sum-of-m-non-overlapping-subarrays-of-size-k/
//each el has choice to create a subarray of length k or not
public class maxSumOfMNonOverlappingSubarrays {
    public static int solution(int[] arr, int i, int k, int m, int[] ssum, int[][] dp){
        if(i >= arr.length || m == 0){
            return 0;
        }
        if(dp[i][m] != 0) return dp[i][m];
        int exc = solution(arr, i + 1, k, m, ssum, dp);
        int inc = ssum[i] + solution(arr, i + k, k, m,  ssum, dp);
        int ans = Math.max(inc, exc);
        dp[i][m] = ans;
		return ans;
	}
	
    public static void main(String[] args){
        int[] arr = {3, 2, 100, 1};
        int n = arr.length;
        int m = 2;
        int k = 2;
        int[] ssum = new int[n]; 
        //ssum[i] stores the sum of window of size k starting from ith idx

        int sum = 0;
        for(int i = n - 1; i >= n - k; i--){
            sum += arr[i];
        }
        ssum[n - k] = sum;
        for(int i = n - k - 1; i >= 0; i--){
            sum += arr[i] - arr[i + k];
            ssum[i] = sum; 
        }

        // for(int v: ssum){
        //     System.out.print(v + " ");
        // }
        int[][] dp = new int[n][m + 1];
        int ans = solution(arr, 0, k, m, ssum, dp);
        System.out.println(ans);
    }
}
