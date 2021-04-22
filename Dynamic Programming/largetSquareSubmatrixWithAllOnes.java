class largetSquareSubmatrixWithAllOnes {
	public static void main(String[] args) {
		int[][] matrix = {
		                     {0, 1, 1, 1},
		                     {1, 1, 1, 1},
		                     {0, 1, 1, 1}
		                 };
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] dp = new int[n][m];
		int ans = Integer.MIN_VALUE;
		for(int i = n - 1; i >= 0; i--){
			for(int j = m - 1; j >= 0; j--){
				if(i == (n - 1) && j == (m - 1)){
					dp[i][j] = matrix[i][j];
				}
				else if(i == (n - 1)){
					dp[i][j] = matrix[i][j];
				}
				else if(j == (m - 1)){
					dp[i][j] = matrix[i][j];
				}
				else{
					if(matrix[i][j] == 0) dp[i][j] = 0;
					else dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
				}

				if(dp[i][j] > ans) ans = dp[i][j];
			}
		}
		System.out.println(ans);
	}
}