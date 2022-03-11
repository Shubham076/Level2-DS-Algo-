/*
https://www.techiedelight.com/calculate-sum-elements-sub-matrix-constant-time/
https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-
to-threshold/discuss/451909/C%2B%2B-Two-O(MN)-Solutions.-PrefixSum-%2B-SlidingWindow-or-PrefixSum-%2B-Smart-Enumeration
leetcode 1292

*/
class MaxLenSubmatrixWithSumLessThanOrEqualToThreshold {

	static int squareSum(int x1, int y1, int x2, int y2, int[][] pre) {
		/*
		proof in the above link
		formula for finding sum between x1, y1 and x2, y2 using pre array
		pre[x2][y2] - pre[x1 - 1][y2] - pre[x2][y1 - 1] + pre[x1 - 1][y1 - 1]
		*/
		int v1 = pre[x2][y2];
		int v2 = x1 - 1 >= 0 ? pre[x1 - 1][y2] : 0;
		int v3 = y1 - 1 >= 0 ? pre[x2][y1 - 1] : 0;
		int v4 = (x1 - 1 >= 0 && y1 - 1 >= 0) ? pre[x1 - 1][y1 - 1] : 0;
		int v = v1 - v2 - v3 + v4;
		// System.out.println(v + " " +  x1 + " " + y1 + " " + x2 + " " + y2);
		return v;
	}

	/* O(n * m * min(n, m))  space => o(n * m)
	*/
	static int maxLen(int[][] arr, int maxSum) {
		int n = arr.length;
		int m = arr[0].length;
		int[][] pre = new int[n][m];  //pre[i][j] = sum of all elements from 0,0 to i,j
		pre[0][0] = arr[0][0];

		// preprocess the first row
		for (int j = 1; j < arr[0].length; j++) {
			pre[0][j] = arr[0][j] + pre[0][j - 1];
		}

		// preprocess the first column
		for (int i = 1; i < arr.length; i++) {
			pre[i][0] = arr[i][0] + pre[i - 1][0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				pre[i][j] = pre[i - 1][j] + pre[i][j - 1] + arr[i][j] - pre[i - 1][j - 1];
			}
		}

		//now since all the numbers are positive
		int ans = -1;
		int len = 0; //side of square matrix we are checking
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				//cheking this particular len

				while (i + len < n && j + len < m && squareSum(i, j, i + len, j + len, pre) <= maxSum) {
					ans = len + 1;
					len++;
				}
			}
		}
		return ans == -1 ? 0 : ans;
	}

	//O(n * m * log(min(n, m)))
	static int maxLen2(int[][] arr, int maxSum) {
		int n = arr.length;
		int m = arr[0].length;
		int[][] pre = new int[n][m];  //pre[i][j] = sum of all elements from 0,0 to i,j
		pre[0][0] = arr[0][0];

		// preprocess the first row
		for (int j = 1; j < arr[0].length; j++) {
			pre[0][j] = arr[0][j] + pre[0][j - 1];
		}

		// preprocess the first column
		for (int i = 1; i < arr.length; i++) {
			pre[i][0] = arr[i][0] + pre[i - 1][0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				pre[i][j] = pre[i - 1][j] + pre[i][j - 1] + arr[i][j] - pre[i - 1][j - 1];
			}
		}

		//now since all the numbers are positive
		int ans = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				//checking for all lengths
				int lo = 0;
				int hi = Math.min(n, m);
				while (lo <= hi) {
					int mid = lo + (hi - lo) / 2;
					if (i + mid < n && j + mid < m && squareSum(i, j, i + mid, j + mid, pre) <= maxSum) {
						ans = Math.max(ans, mid + 1);
						lo = mid + 1;
					}
					else {
						hi = mid - 1;
					}
				}
			}
		}
		return ans == -1 ? 0 : ans;
	}
	public static void main(String[] args) {
		int[][] arr = {{1, 1, 3, 2, 4, 3, 2},
					   {1, 1, 3, 2, 4, 3, 2},
					   {1, 1, 3, 2, 4, 3, 2}};
		int maxSum = 22;
		System.out.println(maxLen2(arr, maxSum));
	}
}