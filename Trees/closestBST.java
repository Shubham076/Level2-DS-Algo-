/*Lintcode 900
	Given a binary search tree and a target node K. The task is to find the
	node with minimum absolute difference with given target value K.

	intuition in case of binary search if we search a element that is not
	present in array mid gives the closest element

	similary is case of bst we can use the same logic as find function
	of bst
*/
class closestBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	//O(h)
	public int closestValue(TreeNode root, double target) {
		// write your code here
		int ans = root.val;
		while (root != null) {

			if (Math.abs(root.val - target) < Math.abs(ans - target)) {
				ans = root.val;
			}

			if (root.val == target) {
				break;
			}
			else if (root.val < target) {
				root = root.right;
			}
			else {
				root = root.left;
			}
		}
		return ans;
	}
}