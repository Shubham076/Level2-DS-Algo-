import java.util.*;

//goal is to find the maximum amount you can earn by selling the rod
class rodCutting{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();  //length of rod
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int[] prices = new int[n + 1];
		for(int i = 1; i < arr.length; i++){
			prices[i] = arr[i - 1];
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for(int i = 2; i < dp.length; i++){
			dp[i] = prices[i];
			int li = 1;
			int ri = i - 1;
			while(li <= ri){
				if(dp[li] + dp[ri] > dp[i]){
					dp[i] = dp[li] + dp[ri];
				}
				li++;
				ri--;
			}

		}

		System.out.println(dp[n]);
	}
}