class count_Of_NDigits_Whose_SumEquals_N {
	static int cntNos(int n, int s, int[][] dp) {
		if(n == 0) {
			if(s == 0) {
				return 1;
			}
			else return 0;
		}

		if(s == 0) return 1;
		if(dp[n][s] != -1) {
			return dp[n][s];
		}
		int cnt = 0;
		for(int i = 0; i <= 9; i++) {
			if(s - i >= 0){
				cnt += cntNos(n - 1, s - i, dp);
			}
		}
		return dp[n][s] = cnt;
	}
	static int solve(int n, int sum, int[][] dp) {
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		int cnt = 0;
		for(int i = 1; i < 10; i++) {
			if(sum - i >= 0) {
				cnt += cntNos(n - 1, sum - i, dp);
			}
		}
		return cnt;
	}
	public static void main(String[] args){
		int n = 3;
		int sum = 6;
		int[][] dp = new int[11][11];
		System.out.println(solve(n, sum, dp));
	}
}