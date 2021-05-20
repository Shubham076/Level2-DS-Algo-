//leetcode 112
public class pathSum {
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
    public boolean solve(TreeNode root, int target){
        if(root == null) return false;

        if(root.left == null && root.right == null) return root.val == target;

        return solve(root.left, target - root.val) || solve(root.right, target - root.val);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum);
    }
}
