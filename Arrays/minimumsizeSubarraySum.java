//leetcode 209
//Time complexity O(N)
// return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
class minimumsizeSubarraySum {
	public static int minSubArrayLen(int target, int[] nums) {
    	int i = -1, j = -1;
    	int min = Integer.MAX_VALUE;
    	int sum = 0;
    	while(true){
    		boolean flag1 = false;
    		boolean flag2 = false;

    		while(i < nums.length - 1){
    			i++;
    			flag1 = true;
    			sum += nums[i];
    			if(sum >= target){
    				int len = i - j;
    				min = Math.min(min, len);
    				break;
    			}
    		}

    		while(j < i){
    			j++;
    			flag2 = true;
    			sum -= nums[j];
    			if(sum >= target){
    				int len = i - j;
    				min = Math.min(min, len);
    			}
    			else{
    				break;
    			}
    		}

    		if(flag1 == false && flag2 == false){
    			break;
    		}
    	}
    	return min != Integer.MAX_VALUE ? min : 0;
    }
	public static void main(String[] args) {
		int target = 4;
		int[] nums = {1, 1, 1};
		System.out.println(minSubArrayLen(target, nums));
	}
}