/* leetcode 222
* in case of full binary tree no of nodes equal to 2^h - 1 all the levels are completely filled
* full binary tree is the tree in which all the  nodes have 2 child except the leaf nodes
* in case of complete binary tree all the levels are completely filled except the last node
* in case of complete binary tree height = log(n);
* in case of complete binary either left or right subtree is full binary tree
* Time complexity O(h * h);
*/
class countCompleteTreeNodes {
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
	public static int leftHeight(TreeNode root){
		int cnt = 1;
		while(root.left != null){
			root = root.left;
			cnt++;
		}
		return cnt;
    }
    public static int rightHeight(TreeNode root){
    	int cnt = 1;
		while(root.right != null){
			root = root.right;
			cnt++;
		}
		return cnt;
    }
	public int countNodes(TreeNode root) {
		if(root == null){
			return 0;
		}

		int lh = leftHeight(root);
		int rh = rightHeight(root);
		if(lh == rh){
			return ((1 << lh) - 1); //2^h - 1
		}
     	int l = countNodes(root);
     	int r = countNodes(root);

     	return l + r + 1;  
    }
}