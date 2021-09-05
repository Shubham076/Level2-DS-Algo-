//leetcode 1123
class lowestCommonAncestorOfDeepestLeaves{
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
	static int deepest;
	static TreeNode lca;
	public static int helper(TreeNode root, int d){
		deepest = Math.max(deepest, d);
		if(root == null){
			return d;
		}
		int dl = helper(root.left, d + 1); //depth of left
		int dr = helper(root.right, d + 1); // depth of right

		if(dl == deepest && dr == deepest){
			lca = root;
		}
		return Math.max(dl, dr);
	}
	public TreeNode lcaDeepestLeaves(TreeNode root) {
        deepest = 0;
        lca = null;
        helper(root, 0);
        return lca;
    }
}