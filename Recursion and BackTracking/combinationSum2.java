//leetcode 40
import java.util.*;

public class combinationSum2 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), 0, target, candidates);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> res, int index, int target, int[] nums) {
        if (target == 0) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue; // for skipping the duplicates
            if (nums[i] <= target) {
                res.add(nums[i]);
                dfs(ans, res, i + 1, target - nums[i], nums);
                res.remove(res.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        System.out.println(combinationSum(arr, target));
    }
}
