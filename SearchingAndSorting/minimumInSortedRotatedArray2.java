/*
when we rotate a sorted array
for eg 4 5       1 2 3
       --11--    --1---
ans is the first element of first part
what we do we calculate mid and check 
* if arr[mid] < arr[hi]
    means mid belongs to first part it can be our potential ans so i simply put hi to mid
* arr[mid] > arr[hi]
   means mid belongs to second part we simply move lo = mid + 1 as min wont lie in the second part
   why plus one ? beacause it is possible that mid + 1 can be our answer

* if arr[mid] == hi
  we cant neglect any part so we simply reduce by hi by one why beacuse if hi
   is our answer it is covered by mid

  O(N)
*/
//leetcode 154
public class minimumInSortedRotatedArray2 {
    public int findMin(int[] nums) {
        int lo = 0;
		int hi = nums.length - 1;
		while(lo < hi){
			int mid = lo + (hi - lo) / 2;
			if(nums[mid] < nums[hi]){
				hi = mid;
			}
			else if(nums[mid] > nums[hi]){
				lo = mid + 1;
			}
            else{
                hi--;
            }
		}
		return nums[lo];
    }
}
