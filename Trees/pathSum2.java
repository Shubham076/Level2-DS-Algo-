//leetcode 113
import java.util.*;
public class pathSum2 {
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

    public void solve(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> path){
        if(root == null){
            return; 
        }

        path.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum){
            ans.add(new ArrayList<>(path));
        }
        else{
            solve(root.left, targetSum - root.val, ans, path);
            solve(root.right, targetSum - root.val, ans, path);
        }
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(root, targetSum, ans, temp);
        return ans;   
    }
}
