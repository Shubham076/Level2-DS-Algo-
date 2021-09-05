/*   leetcode 264
1 is by default is the ugly number
now ugly nos are those which are multiple of 2, 3, 5
so first ugly no after one is the min(2 * i, 3 * j, 5 * k);
intially i,j,k = 0th ugly number;
now if the min is the 2 * i the then we put the ans in the arr move the i pointer to the next 
smallest ugly no
*/
public class uglyNumbers2 {
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int i = 0, j = 0, k = 0;
        int v1 = 2, v2 = 3, v3 = 5;
        dp[0] = 1;
        int c = 1;
        while(c < n){
            int min = Math.min(v1, Math.min(v2, v3));
            dp[c] = min;
            if(min == v1){
                v1 = 2 * dp[++i];
            }
            if(min == v2){
                v2 = 3 * dp[++j];
            }
            if(min == v3){
                v3 = 5 * dp[++k];
            }
            c++;
        }
        for(int v : dp){
            System.out.print(v + " ");
        }
        return dp[n - 1];
    }

    public static void main(String[] args){
        int n = 10;
        nthUglyNumber(n);
    }
}
