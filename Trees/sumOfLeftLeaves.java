//leetcode 404
import java.util.*;
class sumOfLeftLeaves {
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
	static int sum = 0;
	public static void solve(TreeNode root, boolean left){
		if(root == null){
			return;
		}
		if(left && root.left == null && root.right == null){
			sum += root.val;
		}
		solve(root.left, true);
		solve(root.right, false);
	}
	public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        solve(root, false);
        return sum;
    }
}