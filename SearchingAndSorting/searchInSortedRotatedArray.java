//Time complexity  O(Logn);
//this code does not handle duplicates
class searchInSortedRotatedArray {
	public static int find(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;
		int lo = 0;
		int hi = nums.length - 1;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			//check if left part is sorted or not
			else if (nums[lo] <= nums[mid]) {
				//if element is present in the sorted range
				if (target >= nums[lo] && target < nums[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
			//check if right part is sorted or not
			else if (nums[mid] <= nums[hi]) {
				//if element is present in sorted range or not
				if (target > nums[mid] && target <= nums[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {4, 5, 1, 2, 3};
		int k = 3;
		System.out.println(find(arr, k));
	}
}