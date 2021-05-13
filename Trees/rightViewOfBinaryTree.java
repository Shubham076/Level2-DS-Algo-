import java.util.*;
class rightViewOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<Integer> rightSideView(TreeNode root) {
		Queue<TreeNode> q = new ArrayDeque<>();
		List<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode rp = q.remove();
				if (i == size - 1)
					ans.add(rp.val);

				if (rp.left != null) {
					q.add(rp.left);
				}

				if (rp.right != null) {
					q.add(rp.right);
				}
			}
		}

		return ans;
	}
}