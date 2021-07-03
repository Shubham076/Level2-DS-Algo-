//leetcode 230
import java.util.*;
class kthSmallestInBST {
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

	//morris traversal
	public void inorderTraversal(TreeNode root, int k) {
		while (root != null) {
			if (root.left == null) {
				ans = root.val;
				k--;
				root = root.right;

				if(k == 0){
					break;
				}
			} else {
				TreeNode rp1 = root.left;  //root plus 1
				while (rp1.right != null && rp1.right != root) {
					rp1 = rp1.right;
				}

				if (rp1.right == null) {  //visiting first time
					rp1.right = root;
					root = root.left;
				} else {
					ans = root.val;
					k--;
					if(k == 0) break; //visiting second time
					rp1.right = null;
					root = root.right;
				}
			}
		}
	}
	static int ans;
	public int kthSmallest(TreeNode root, int k) {
        ans = Integer.MAX_VALUE;
        inorderTraversal(root, k);
        return ans;
    }
}