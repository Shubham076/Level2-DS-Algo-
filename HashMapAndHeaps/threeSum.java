import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public static void main(String[] args) {

        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threesum(nums));

    }
// O(NlogN + N^2)
    public static List<List<Integer>> threesum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }

                    }
                    else if (sum > 0) {
                        right--;
                    }
                    else {
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}