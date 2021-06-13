//leetcode 746
class minCostClimbingStairs{
	public static  int minCostClimbingStairs(int[] cost) {
        int ans = Integer.MAX_VALUE;
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for(int i = 2; i <= n; i++){
        	int oneStep = dp[i - 1] + cost[i - 1];
        	int twoStep = dp[i - 2] + cost[i - 2];
        	dp[i] = Math.min(oneStep, twoStep);
        }
        return dp[n];
    }
	public static void main(String[] args){
		int[] arr = {10, 15, 20};
		System.out.println(minCostClimbingStairs(arr));
	}
}