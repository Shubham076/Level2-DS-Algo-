//leetcode 561
/*
intution
Input: nums = [1,4,3,2]
Output: 4
Explanation: All possible pairings (ignoring the ordering of elements) are:
1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
So the maximum possible sum is 4.

from above test case we can see the pairing of sorted array gives max sum;
*/
import java.util.*;
class arrayPartition1{
	public static  int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i += 2){
        	sum += nums[i];
        }
        return sum;
    }
	public static void main(String[] args){
		int[] arr = {1, 4, 3, 2};
		System.out.println(arrayPairSum(arr));
	}
}