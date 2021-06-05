//leetcode1512
class goodNumberOfPairs {
	public static int numIdenticalPairs(int[] nums) {
		if (nums.length == 0) return 0;
		int[] map = new int[101];
		int cnt = 0;
		for (int n : nums) {
			cnt += map[n]++;
		}
		return cnt;
	}
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 1};
		System.out.println(numIdenticalPairs(arr));
	}
}