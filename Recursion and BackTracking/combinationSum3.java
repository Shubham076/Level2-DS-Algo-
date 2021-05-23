// leetcode 216
import java.util.*;
public class combinationSum3 {

    public static List<List<Integer>> combinationSum(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), 1, n, k, 0);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> res, int idx, int n, int k, int sum) {
        if (sum == n && res.size() == k) {
            ans.add(new ArrayList<>(res));
            return;
        }

        for (int i = idx; i <= 9; i++) {
            res.add(i);
            dfs(ans, res, i + 1, n, k, sum + i);
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        System.out.println(combinationSum(k, n));
    }
}
