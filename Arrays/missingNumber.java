//leetcode 268
class missingNumber{
	public int missingnumber(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        int n = nums.length;
        return (n * (n + 1)/ 2 - sum);
    }
}