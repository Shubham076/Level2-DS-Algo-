/*
max profit if k transactions allowed
let says we have to find  max profit we can have if 3 transactions allowed on 5th day
so competetors are:
c1 = 3 transaction 4day tak hogyi
c2 = ya phir 2 transaction first day and 3 rd between 1st and 5th 
c3 = ya phir 2 transaction second day and 3 rd between 2nd and 5th 
c4 = ya phir 2 transaction third day and 3 rd between 3rd and 5th 
c5 = ya phir 2 transaction forth day and 3 rd between 4th and 5th 
so ans = max(c1, c2, c3, c4, c5);
*/
import java.util.Scanner;
public class buyAndSellStockKTransactions {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1};
        int n = arr.length;
        int k = 2; //represents transactions
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
