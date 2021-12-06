//leetcode 687
/*
Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value.
This path may or may not pass through the root.
The length of the path between two nodes is represented by the number of edges between them.
*/
public class longestUnivaluePath {
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
    static int ans;
    int traverse(TreeNode root){
        if(root == null) return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        int lmax = 0;
        int rmax = 0;
        if(root.left != null && root.left.val == root.val){
            lmax = left + 1;
        }
        if(root.right != null && root.right.val == root.val){
            rmax = right + 1;
        }
        ans = Math.max(ans, lmax + rmax);
        return Math.max(lmax, rmax);
    }

    //each node is returning the length of longest univalue path
    public int longestUnivaluePath(TreeNode root) {
       ans = 0;
       traverse(root);
       return ans;
    }
}
