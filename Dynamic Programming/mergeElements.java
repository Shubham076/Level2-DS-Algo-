/*
https://www.interviewbit.com/problems/merge-elements/
*/
import java.util.*;
public class mergeElements {
    public static int solve(ArrayList<Integer> A) {
        int n = A.size();
        int[] pre = new int[n];
        pre[0] = A.get(0);

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + A.get(i);
        }
        int[][] dp = new int[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 0;
                } 
                else if (g == 1) {
                    dp[i][j] = A.get(i) + A.get(j);
                } 
                else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int lc = dp[i][k];
                        int rc = dp[k + 1][j];
                        int c = pre[j] - (i  >= 1 ? pre[i - 1] : 0);
                        int total = lc + rc + c;
                        min = Math.min(min, total);
                    }

                    dp[i][j] = min;
                }
            }
        }
        for(int i = 0 ; i < dp.length; i++){
            for(int j = 0; j < dp.length; j++){
                System.out.format(" % 3d ",dp[i][j]);
            }
            System.out.println();   
        }
        return dp[0][n - 1];
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10, 2, 3, 4, 3, 2));
        solve(arr);
    }
}
