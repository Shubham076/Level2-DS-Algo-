//leetcode 413 meaning of the cell is the no of aps ending at dp[i]
class arithmeticSlices {

	//O(n * n)
	static int bruteforce(int[] arr) {
		if (arr.length < 3) return 0;
		int cnt = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			int cd = arr[i + 1] - arr[i];
			for (int j = i + 2; j < arr.length; j++) {
				if (arr[j] - arr[j - 1] != cd) break;
				else {
					if (j - i + 1 >= 3) cnt++;
				}
			}
		}
		return cnt;
	}

	//O(n) o(1) space
	static int count(int[] arr) {  
		int sum = 0, cur = 0;
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
				cur += 1;
				sum += cur;
			} else {
				cur = 0;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		int n = arr.length;
		int[] dp = new int[n];
		int ans = 0;
		for (int i = 2; i < n; i++) {
			if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
				dp[i] = 1 + dp[i - 1];
				ans += dp[i];
			}
		}
		System.out.println(ans);
	}
}