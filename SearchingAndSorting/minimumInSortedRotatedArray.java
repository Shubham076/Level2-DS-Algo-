//leetcode 153
/*
eg 4, 5, 1, 2, 3
   ----  -------
   i        ii
in case of rotated sorted we have divided into 2 parts 
we can see both the individual parts are sorted
and the minimum element is the first element of second boundary

how to find the first element of second boundary??
we can see that it has some special property
1 it is the only element in the num whose left is greater

simlarly for the last element of first boundary
1 it is the only element whose right is smaller

*/
class minimumInSortedRotatedArray{
	public static int findMin(int[] nums) {
		int lo = 0;
		int hi = nums.length - 1;

		//if no rotation is present means first element is the answer
		if(nums[lo] <= nums[hi]){
			return nums[0];
		}

		while(lo <= hi){
			int mid = lo + (hi - lo ) / 2;

			//check if the right of mid is smaller 
			if(nums[mid] > nums[mid + 1]){
				return nums[mid + 1];
			}
			//check if the left of mid is larger
			else if(nums[mid - 1] > nums[mid]){
				return nums[mid];
			}

			//if left part is sorted move to the right part
			else if(nums[lo] <= nums[mid]){
				lo = mid + 1;
			}
			else if(nums[mid] <= nums[hi]){
				hi = mid - 1;
			}
		}
        return -1;
    }
	public static void main(String[] args) {
		int[] nums = {5, 1, 2, 3, 4};
		System.out.println(findMin(nums));
	}
}