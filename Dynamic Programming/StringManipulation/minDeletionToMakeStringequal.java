//leetcode 583
//ans = len(s1) + len(s2) - 2 * len(lcs);
class minDeletionToMakeStringequal{
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                char c = s1.charAt(i - 1);
                char d = s2.charAt(j - 1);
                if(c == d){
                    dp[i][j] = 1 + dp[i - 1][j - 1]; 
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return n + m - 2 * dp[n][m];   
    }
}