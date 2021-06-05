//leetcode 114
class flattenBinaryTreeToLinkedList{
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

    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        flatten(left);
        flatten(right);

        root.left = null;
        root.right = left;
        TreeNode temp = root;
        while(temp.right != null){
            temp = temp.right;
        }

        temp.right = right;
    }
}