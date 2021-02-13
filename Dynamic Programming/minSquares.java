import java.util.*;
public class minSquares {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                int rem = i - (j * j);
                if(dp[rem] < min){
                    min = dp[rem];
                }
            }
            dp[i] = 1 + min;
        } 
        
        System.out.println(dp[n]);
    }
}
