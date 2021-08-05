//leetcode 413
class arithmeticSlices{
	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4};
		int n = arr.length;
		int[] dp = new int[n];
		int ans = 0;
		for(int i = 2; i < n; i++){
			if(arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]){
				dp[i] = 1 + dp[i - 1];
				ans += dp[i];
			}	
		}
		System.out.println(ans);
	}
}