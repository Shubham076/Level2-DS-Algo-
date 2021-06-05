//leetcode 572
class subtreeOfAnotherTree {
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

	public static boolean isSame(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return p == q;
		}
		return p.val == q.val && isSame(p.left, q.left) && isSame(p.right, q.right);
	}

	public static void find(TreeNode root, TreeNode target) {
		if (root == null) return;
		if (root.val == target.val) {
			found = isSame(root, target);
			if (found) return;
		}

		if(!found) find(root.left, target);
		if(!found) find(root.right, target);
	}
	static boolean found; //O(n * m); 
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		found = false;
		find(root, subRoot);
		return found;
	}
}