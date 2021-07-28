//leetcode 1877 O(sort)
import java.util.*;
public class minimizeMaxPairSum {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length / 2; i++){
            ans = Math.max(ans, nums[i] + nums[n - 1 - i]);
        }
        return ans;    
    }
}
