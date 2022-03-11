//https://www.codingninjas.com/codestudio/problems/mixtures_975356?leftPanelTab=0
class minimizeSmoke {
	public static int minSmoke(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n][n];
		int[] pre = new int[n];
		pre[0] = arr[0];
		for (int i = 1; i < n; i++) {
			pre[i] = (pre[i - 1] + arr[i]) % 100;
		}

		for (int g = 0; g < n; g++) {
			for (int i = 0, j = g; j < n; j++, i++) {
				if (g == 0) {
					dp[i][j] = 0;
				} else if (g == 1) {
					dp[i][j] = arr[i] * arr[j];
				} else {
					int min = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int left = dp[i][k];
						int right = dp[k + 1][j];

						int lsum = pre[k] - (i >= 1 ? pre[i - 1] : 0);
						int rsum = pre[j] - pre[k];

						if (lsum < 0) lsum += 100;
						if (rsum < 0) rsum += 100;
						int v = left + right + (lsum * rsum);
						if (v < min) {
							min = v;
						}
					}
					dp[i][j] = min;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[0][n - 1];
	}
	public static void main(String[] args) {
		int[] arr = { 70, 83, 72, 100, 16, 53, 2, 18, 18, 98, 5, 15, 1, 23, 44, 56, 48, 57, 66, 24, 17, 69, 76, 16, 96, 85, 59, 83, 46, 25, 3, 94, 2, 58, 45, 71, 92, 96, 56, 75, 55, 30};
		System.out.println(minSmoke(arr));
	}
}