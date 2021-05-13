// leetcode 462
import java.util.*;
class minMovesToEqualArrayElements {
	//minimum moves always present at the median
	public static void main(String[] args) {
		int[] nums = {3, 1, 2};
		Arrays.sort(nums);
		int median = nums[nums.length / 2];
		int ans = 0;
		for (int i : nums) {
			ans += Math.abs(i - median);
		}

		System.out.println(ans);
	}
}