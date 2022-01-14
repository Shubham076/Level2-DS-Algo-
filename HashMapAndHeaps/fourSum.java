import java.util.*;
//Time complexity O(N ^ 3)
class fourSum {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 0, 0 };
        System.out.println(foursum(nums, 0));
    }

    public static List<List<Integer>> foursum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    int left = j + 1;
                    int right = nums.length - 1;

                    if (j == i + 1 || j > i + 1 && nums[j] != nums[j - 1]) {
                        while (left < right) {
                            int sum = nums[i] + nums[j] + nums[left] + nums[right];
                            if (sum == target) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                left++;
                                right--;

                                while (left < right && nums[left] == nums[left - 1]) {
                                    left++;
                                }
                                while (left < right && nums[right] == nums[right + 1]) {
                                    right--;
                                }
                            } else if (sum > target) {
                                right--;
                            } else {
                                left++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}