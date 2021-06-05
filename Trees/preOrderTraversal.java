//morris traversal o(N) time O(1) space
import java.util.*;
class preOrderTraversal {
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
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		while (root != null) {
			if (root.left == null) {
				ans.add(root.val);
				root = root.right;
			} else {
				TreeNode rp1 = root.left;  //root plus 1
				while (rp1.right != null && rp1.right != root) {
					rp1 = rp1.right;
				}

				if (rp1.right == null) {
					ans.add(root.val);
					rp1.right = root;
					root = root.left;
				} else {
					rp1.right = null;
					root = root.right;
				}
			}
		}
		return ans;
	}
}