import java.util.Arrays;
public class threeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threesumClosest(nums, 1));
    }

    public static int threesumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
    
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];

                if (curSum > target) {
                    right--;
                } 
                else {
                    left++;
                }

                if (Math.abs(curSum - target) < Math.abs(result - target)) {
                    result = curSum;
                }
            }
        }
        return result;
    }
}