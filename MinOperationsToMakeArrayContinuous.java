/*
n=size of nums
sort the numbers
ind a range of length n => [l, l+n-1]
find how many unique numbers fall into that range
find for all possible ranges (the moment we found el greater than range update start of window)
store the max of them in mx
ans = n-mx
leetcode 2009
*/
import java.util.*;

class MinOperationToMakeArrayContinuous {
	public int minOperations(int[] nums) {
	        
	        int n = nums.length;
	        Arrays.sort(nums);
	        int i = 0, j = 0, limit = nums[0] + n - 1, max = 0, cnt = 0;
	        
	        while(i < n) {
	            if(nums[i] <= limit){        
	                cnt++;
	                i++;
	                max = Math.max(max, cnt);
	                
	                //handling the duplicates
	                while(i < n && nums[i] == nums[i - 1]) {
	                    i++;
	                }
	            }
	            else {
	                j++;
	                cnt--;
	                
	                //handling the duplicates
	                while(j < n && nums[j] == nums[j - 1]){
	                    j++;
	                }           
	                limit = nums[j] + n - 1;
	            }
	        }
	        return n - max;
	    }
}