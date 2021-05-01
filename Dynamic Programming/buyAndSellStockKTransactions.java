import java.util.Scanner;

public class buyAndSellStockKTransactions {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1};
        int n = arr.length;
        int k = 2;
        int[][] dp = new int[k + 1][arr.length];

        for(int t = 1; t <= k; t++){
            int max = Integer.MIN_VALUE;
            for(int d = 1; d < arr.length; d++){
                if(dp[t - 1][d -1] - arr[d - 1] > max){
                    max = dp[t -1][d - 1] - arr[d - 1];
                }

                if(max + arr[d] > dp[t][d - 1]){
                    dp[t][d] = max + arr[d];
                }
                else{
                    dp[t][d] = dp[t][d - 1];
                }
            }

        }
        System.out.println(dp[k][n - 1]);
    }
}
