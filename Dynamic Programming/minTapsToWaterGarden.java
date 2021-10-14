//leetcode 1326
import java.util.*;
public class minTapsToWaterGarden {
    //meaning of dp[i] min number of taps required to cover area of 0 -- i; 
    public static int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 2);
        dp[0] = 0;
        for(int i = 0; i <= n; i++){
            int left = Math.max(i - ranges[i], 0);
            int right = Math.min(i + ranges[i], n);

            for(int j = left; j <= right; j++){
                dp[j] = Math.min(dp[j], 1 + dp[left]);
            }
        }
        // for(int i: dp){
        //     System.out.print(i + " ");
        // }
        return dp[n] == n + 2 ? -1 : dp[n];
    }
    public static void main(String[] args){
        int n = 3;
        int[] arr = {0, 0, 0, 0};
        System.out.println(minTaps(n, arr));
    }
}
