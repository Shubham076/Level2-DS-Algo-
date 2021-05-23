//leetcode 39
import java.util.*;
public class combinationSum1 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(ans, new ArrayList<>(), 0, target, candidates, 0);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, List<Integer> res, int index, int target, int[] nums, int sum) {
            if (sum == target) {
                ans.add(new ArrayList<>(res));
                return;
            }
            for (int i = index; i < nums.length; i++) {
                if (sum + nums[i] <= target) {
                    res.add(nums[i]);
                    dfs(ans, res, i, target, nums, sum + nums[i]);
                    res.remove(res.size() - 1);
                }
            }
        }
}
