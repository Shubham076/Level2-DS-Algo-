//leetcode 1145
import java.util.*;
class binaryTreeColoring {
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
	public static TreeNode constructTree(Integer[] arr) {
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(new TreeNode(arr[0], null, null));
		TreeNode root = null;
		int i = 1;
		while (q.size() > 0 && i < arr.length) {
			TreeNode rp = q.remove();
			if (root == null) {
				root = rp;
			}

			//adding the left child
			if (arr[i] != null) {
				rp.left = new TreeNode(arr[i], null, null);
				q.add(rp.left);
			}
			i++;

			if (i >= arr.length) break;

			//adding the right child
			if (arr[i] != null) {
				rp.right = new TreeNode(arr[i], null, null);
				q.add(rp.right);
			}
			i++;
		}
		return root;
	}

	static int lc;
	static int rc;
	public static int travel(TreeNode root, int x) {
		if (root == null) {
			return 0;
		}
		int lcnt = travel(root.left, x);
		int rcnt = travel(root.right, x);
		if (root.val == x) {
			lc = lcnt;
			rc = rcnt;
		}

		return lcnt + rcnt + 1;
	}

	public static boolean btreeGameWinning(TreeNode root, int n, int x) {
		lc = 0;
		rc = 0;
		travel(root, x);
		int pc = n - lc - rc - 1; //parent subtree node cnt
		int max = Math.max(pc, Math.max(lc, rc));
		if (max > n / 2) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		Integer[] arr = {1, 2, 3};
		int n = 3, k = 1;
		TreeNode root = constructTree(arr);
		System.out.println(btreeGameWinning(root, n, k));
	}
}