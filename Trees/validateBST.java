//leetcode 98
class validateBST {
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
	TreeNode prev = null;
	public boolean isValidBST(TreeNode root) {
		if(root == null) return true;

		if(!isValidBST(root.left)) return false;

		if(prev != null && prev.val > root.val) return false;
		prev = root;

		if(!isValidBST(root.right)) return false;
		return true;
	}

	//morris inorder traversal O(1) space
	public boolean isValidBST2(TreeNode root){
		if(root == null) return false;
		TreeNode prev = null;
		while(root != null){
			if(root.left == null){
				if(prev != null && root.val <= prev.val){
					return false;
				}
                prev = root;
				root = root.right;
			}
			else{
				TreeNode rp1 = root.left;
				while(rp1.right != null && rp1.right != root){
					rp1 = rp1.right;
				}
				if(rp1.right == null){
					rp1.right = root;
					root = root.left;
				}
				else{
					if(root.val <= prev.val){
						return false;
					}
                    rp1.right = null;
					prev = root;
					root = root.right;
				}
			}
		}
		return true;
	}
}