import java.util.*;
class maxSumSubmatrixOfSizek {
	// o(n * m * k * k)
	static void find1(int[][] arr, int k) {
		int n = arr.length;
		int m = arr[0].length;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= n - k; i++) {
			for (int j = 0; j <= m - k; j++) {
				int sum = 0;
				for (int p = 0; p < k; p++) {
					for (int q = 0; q < k; q++) {
						sum += arr[p + i][q + j];
					}
				}
				max = Math.max(max, sum);
			}
		}
		System.out.println(max);
	}
	/*
	We can solve this problem in O(n2) time using a Tricky Solution. The idea is to preprocess the given
	square matrix. In the preprocessing step, calculate sum of all vertical strips of size k x 1 in a
	temporary square matrix stripSum[][]. Once we have sum of all vertical strips, we can calculate sum
	of first sub-square in a row as sum of first k strips in that row, and for remaining sub-squares,
	we can calculate sum in O(1) time
	by removing the leftmost strip of previous subsquare and adding the rightmost strip of new square.
	*/

	// o(n * n) space o(n* n)
	static void find2(int[][] arr, int k) {
		int n = arr.length;
		int m = arr[0].length;
		//pre[i][j] = stores the sum of strip of size k X 1 startin from the ith index
		int[][] pre = new int[n][m];

		for(int j = 0; j < m; j++) {
			int sum = 0;
			/// answer for the first strip of k X 1
			for(int i = 0; i < k; i++) {
				sum += arr[i][j];
			}
			pre[0][j] = sum;
			for(int i = 1; i <= n - k; i++) {
				sum += arr[i + k - 1][j] - arr[i - 1][j];
				pre[i][j] = sum;
			}
		}

		int ans = Integer.MIN_VALUE;
		for(int i = 0 ; i <= n - k; i++) {
			int sum = 0;
			//calculating the answer for first matrix
			for(int j = 0; j < k; j++){
				sum += pre[i][j];
			}

			//shifting of matrix by one cols
			for(int j = 1; j <= m - k; j++) {
				sum += pre[i][j + k - 1] - pre[i][j - 1];
				ans = Math.max(ans, sum);
			}
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 1, 1, 1 },
						{ 2, 2, 2, 2, 2 },
						{ 3, 8, 6, 7, 3 },
						{ 4, 4, 4, 4, 4 },
						{ 5, 5, 5, 5, 5 }};
		int k = 3;
		find1(arr, k);
		find2(arr, k);
	}
}