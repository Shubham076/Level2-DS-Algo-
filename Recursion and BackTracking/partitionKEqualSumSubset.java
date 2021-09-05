//leetcode 698 O(k * 2 ^ N) + O(N + recursion space)
import java.util.*;
public class partitionKEqualSumSubset {
    public static boolean backtrack(int[] nums, int i, int csum, int k, int target, int[] vis){
        // if k == 1 means we have made k - 1 subsets with target sum and last subset will also have target sum.
        if(k == 1) return true;

        // Current subset sum exceeds target sum, no need to proceed further.
        if(csum > target) return false;

        if(csum == target){
        // When current subset sum reaches target sum then one subset is made.
        // Decrement k and reset current subset sum to 0 and start searhing for other subset
            return backtrack(nums, 0, 0, k - 1, target, vis);
        }

        for(int j = i; j < nums.length; j++){
            if(vis[j] == 0){
                vis[j] = 1;
                if(backtrack(nums, j + 1, csum + nums[j], k, target, vis)){
                    return true;
                }
                vis[j] = 0;
            }
        }

        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k <= 0 || k > nums.length) return false;
        int sum = 0;
        for(int el : nums) sum += el;
        if(sum % k != 0) return false;
        int target = sum / k;
        return backtrack(nums, 0, 0, k, target, new int[nums.length]);  
    }
}
