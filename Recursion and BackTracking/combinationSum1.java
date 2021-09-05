//leetcode 39
import java.util.*;
public class combinationSum1 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(ans, new ArrayList<>(), 0, target, candidates);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, List<Integer> res, int index, int target, int[] nums) {
            if (target == 0) {
                ans.add(new ArrayList<>(res));
                return;
            }
            for (int i = index; i < nums.length; i++) {
                if (nums[i] <= target) {
                    res.add(nums[i]);
                    dfs(ans, res, i, target - nums[i], nums);
                    res.remove(res.size() - 1);
                }
            }
        }
}
