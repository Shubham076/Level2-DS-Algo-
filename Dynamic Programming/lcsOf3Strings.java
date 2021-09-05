//https://www.geeksforgeeks.org/lcs-longest-common-subsequence-three-strings/
class lcsOf3Strings{
	public static int lcs(String s1, String s2, String s3){
		int m = s1.length();
		int n = s2.length();
		int o = s3.length();
		int[][][] dp = new int[m + 1][n + 1][o + 1];
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				for(int k = 1; k <= o; k++){
					char c1 = s1.charAt(i - 1);
					char c2 = s2.charAt(j - 1);
					char c3 = s3.charAt(k - 1);

					if(c1 == c2 && c2 == c3){
						dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
					}
					else{
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
					}
				}
			}
		}
		return dp[m][n][o];
	}
	public static void main(String[] args){
		String s1 = "geeks";
		String s2 = "geeksfor";
		String s3 = "geeksforgeeks";
		int ans = lcs(s1, s2, s3);
		System.out.println(ans);
	}
}