class trimOfBST{
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
	public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;

        /* case1 when root is less than low
        	means we have remove all the nodes to the left of root including root
        */
        if(root.val < low){
        	return trimBST(root.right, low, high);
        }

        /* case2 when root is greater than high
        	means we have remove all the nodes to the right of root including root
        */
        if(root.val > high){
        	return trimBST(root.left, low, high);
        }

        /*
		case 3 means root is in the range
		but we are not sure about about left and right
        */

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}