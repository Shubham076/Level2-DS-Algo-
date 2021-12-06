/*  leetcode 1609
A binary tree is named Even-Odd if it meets the following conditions:

* The root of the binary tree is at level index 0, its children are at level index 1,
 their children are at level index 2, etc.

* For every even-indexed level, all nodes at the level have odd integer 
values in strictly increasing order (from left to right).

* For every odd-indexed level, all nodes at the level have even integer
 values in strictly decreasing order (from left to right).
*/
public class evenOddTree {
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
    int[] data;
    static int height(TreeNode root){
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    boolean check(TreeNode root, int l){
        if(root == null) return true;
        if(l % 2 == 0){
            if(root.val % 2 == 0) return false;
            if(root.val <= data[l]) return false;
            data[l] = root.val; 
        }
        else{
            if(root.val % 2 == 1) return false;
            if(root.val >= data[l]) return false;
            data[l] = root.val;
        }
        return check(root.left, l + 1) && check(root.right, l + 1);
    }
    public boolean isEvenOddTree(TreeNode root) {
        int h = height(root);
        data = new int[h];
        for(int i = 0; i < h; i++){
            data[i] = i % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return check(root, 0);
    }
}
