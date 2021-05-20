//Time complexity  O(Logn);
class searchInSortedRotatedArray {
	public static int find(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;
		int left = 0;
		int right = nums.length - 1;

		//using binary search to find the minimum number in the array
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) { //not normal conditon as in sorted array the mid point is smaller than last element
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		// after binary search left pointer contains the index of min no;
		int start = left;
		left = 0;
		right = nums.length - 1;

		if (target >= nums[start] && target <= nums[right]) {
			left = start;
		} else {
			right = start;
		}

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {4, 5, 6, 7, 0, 1, 2};
		int k = 0;
		System.out.println(find(arr, k));
	}
}