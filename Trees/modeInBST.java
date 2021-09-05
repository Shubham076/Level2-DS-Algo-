//leetcode 501
import java.util.*;
class modeInBST {
	static class TreeNode {
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
	static int cnt;
	static int max;
	static TreeNode prev;
	public static void traverse(TreeNode root, ArrayList<Integer> ans) {
		if (root == null) {
			return;
		}

		traverse(root.left, ans);

		if (prev != null) {
			if (prev.val == root.val) {
				cnt++;
			} 
			else {
				cnt = 1;
			}
		}

		if (cnt > max) {
			ans.clear();
			max = cnt;
			ans.add(root.val);
		} 
		else if (cnt == max) {
			ans.add(root.val);
		}

		prev = root;
		traverse(root.right, ans);
	}
	public int[] findMode(TreeNode root) {
		cnt = 1;
		prev = null;
		max = Integer.MIN_VALUE;

		ArrayList<Integer> list = new ArrayList<>();
		traverse(root, list);

		int[] ans = new int[list.size()];
		for (int i = 0; i < list.size() ; i++) {
			ans[i] = list.get(i);
		}
		return ans;
	}
}
