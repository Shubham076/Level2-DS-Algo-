//leetcode 1004
class maxConsecutiveOnes3 {
	public static int longestOnes(int[] nums, int k) {
		int max = Integer.MIN_VALUE;
		int j = -1;
		int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				cnt++;
			}
			while (cnt > k) {
				j++;
				if (nums[j] == 0) {
					cnt--;
				}
			}

			max = Math.max(max, (i - j));
		}
		return max;
	}
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
		int k = 2;
		System.out.println(longestOnes(arr, k));
	}
}