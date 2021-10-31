import java.util.HashMap;

/*
https://binarysearch.com/problems/Pair-Sums-to-Power-of-Two
You are given a list of integers nums. Return the number of pairs i < j such that nums[i] + nums[j] is equal to 2 ** k for some 0 ≤ k.
O(32 * N)
*/
public class twoSumWithPowerOfTwo {
    public int solve(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < 32; j++){
                int rem = (1 << j) - nums[i];
                cnt += map.getOrDefault(rem, 0);
                
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return cnt;   
    }
}
