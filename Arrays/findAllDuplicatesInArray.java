//leetcode 442 O(N) O(1) space
import java.util.*;
class findAllDuplicatesInArray {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == i + 1) continue;
			int si = i;
			int ei = nums[i] - 1;
			if (nums[ei] == nums[si]) continue;
			swap(nums, si, ei);
			i--;
		}

		for (int i = 0; i < nums.length; i++) {
			if (i + 1 == nums[i]) continue;
			else ans.add(nums[i]);
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
		System.out.println(findDuplicates(arr));
	}
}