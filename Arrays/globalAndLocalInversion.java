// leetcode 775
// The number of global inversions is the number of the different pairs (i, j) where:

// 0 <= i < j < n
// nums[i] > nums[j]
// The number of local inversions is the number of indices i where:

// 0 <= i < n - 1
// nums[i] > nums[i + 1]
// Return true if the number of global inversions is equal to the number of local inversions.


//from above condition it can be concluded that all the local inversion are global inversions
//answer is true if all the global inversion are local inversions
//answer is false if any pair exist where max > a[i + 2] return false;
//why max ? coz if max cant satisfy the condition then all the smaller can also cant satisfy
//why not checking i + 1 coz it is the case of local inversion
class globalAndLocalInversion {
	public static boolean isIdealPermutation(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {
			max = Math.max(max, nums[i]);
			if (max > nums[i + 2])
				//found a global inversion that is not local inversion
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int[] arr = {1, 0, 2};
		System.out.println(isIdealPermutation(arr));
	}
}