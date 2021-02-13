import java.util.*;
class noOfWaysOfTraingulation{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		n = n - 2;
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for(int i = 2; i <= n; i++){
			for(int j = 0; j < i; j++){
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		System.out.println(dp[n]);
	}
}