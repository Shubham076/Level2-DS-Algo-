//leetcode 81
class searchInSortedRotatedArray2 {

	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;
		int lo = 0;
		int hi = nums.length - 1;

		while (lo <= hi) {

			// to remove the duplicates test case {1, 0, 1, 1, 1}
			while (lo < hi && nums[lo] == nums[lo + 1])
				lo++;
			while (lo < hi && nums[hi] == nums[hi - 1])
				hi--;

			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target) {
				return true;
			}

			// check if left part is sorted or not
			else if (nums[lo] <= nums[mid]) {
				// if element is present in the sorted range
				if (target >= nums[lo] && target < nums[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
			// check if right part is sorted or not
			else if (nums[mid] <= nums[hi]) {
				// if element is present in sorted range or not
				if (target > nums[mid] && target <= nums[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}
		return false;
	}
}
