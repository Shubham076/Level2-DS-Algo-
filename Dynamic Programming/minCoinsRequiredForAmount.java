//o(amount * n) where n is the number of coins
class minCoinsRequired{
    public static int solve(int a, int[] coins, int[] dp){
        if(a == 0){
            return 0;
        }
        if(dp[a] != 0){
            return dp[a];
        }
        int min = Integer.MAX_VALUE;
        for(int c: coins){
            if(a >= c){
                min = Math.min(min, 1 + solve(a - c, coins, dp));
            }
        }

        dp[a] = min;
        return min;
    }
    public static void main(String[] args){
        int amount = 10;
        int[] coins = {1, 2};
        int[] dp = new int[amount + 1];
        int ans = solve(amount, coins, dp);
        if(ans == Integer.MAX_VALUE){
            ans= -1;
        }
        System.out.println(ans);
    }
}