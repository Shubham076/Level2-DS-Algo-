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

    //O(N)
    public TreeNode flatten(TreeNode root) {
        if(root == null) return null;
        TreeNode lt = flatten(root.left);  //left tail
        TreeNode rt = flatten(root.right); // right tail

        if(lt == null && rt == null){
            return root;
        }
        else if(lt == null){
            return rt;
        }
        else if(rt == null){
            root.right = root.left;
            root.left = null;
            return lt;
        }
        else{
            TreeNode rh = root.right;  //right head;
            root.right = root.left;
            root.left = null;
            lt.right = rh;
            return rt;
        }
    }
}