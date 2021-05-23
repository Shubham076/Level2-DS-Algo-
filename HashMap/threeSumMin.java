
// 
// Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
import java.util.*;

public class threeSumMin {
    public static int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int cnt = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                 if (sum < target) {
                    cnt += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = { 1, -2, 2, 1, 0 };
        int target = 1;
        System.out.println(threeSumSmaller(arr, target));
    }
}
