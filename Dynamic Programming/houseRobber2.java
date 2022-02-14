/* leetcode 213
Since you cannot rob both the first and last house, just create two separate vectors,
one excluding the first house, and another excluding the last house. The best solution
generated from these two vectors using the original House Robber DP algorithm is the optimal one.
O(N) and O(1) space
*/
public class houseRobber2 {
    public static int robHouse(int lo, int hi, int[] nums){
        int inc = nums[lo];
        int exc = 0;
        for(int i = lo + 1; i <= hi; i++){
            int ninc = nums[i] + exc;
            int nexc = Math.max(inc, exc);

            inc = ninc;
            exc = nexc;
        }
        return Math.max(inc, exc);
    }
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(robHouse(0, nums.length - 2, nums), robHouse(1, nums.length - 1, nums));
    }
}
