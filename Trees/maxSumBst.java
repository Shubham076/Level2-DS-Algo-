/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * leetcode 1373
 */
class Solution {
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
    static class Pair{
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean isBst = true;
        int sum = 0; //sum of the subtree
        int maxSum = 0; //max sum bst 
        
        @Override
        public String toString() {
            return this.isBst + " " + this.min + " " + this.max + " " + this.maxSum;
        }
    }
    public int maxSumBST(TreeNode root) {
        Pair ans = max(root);
        return Math.max(ans.maxSum, 0);
    }
    
    static Pair max(TreeNode root) {
        if(root == null){
            return new Pair();
        }
        
        Pair left = max(root.left);
        Pair right = max(root.right);
        Pair mp = new Pair();
        
        mp.isBst = left.isBst && right.isBst && root.val > left.max && root.val < right.min;
        mp.min = Math.min(root.val, Math.min(left.min, right.min));
        mp.max = Math.max(root.val, Math.max(left.max, right.max));
        mp.sum = root.val + left.sum + right.sum;
        
        if(mp.isBst){
            mp.maxSum = Math.max(mp.sum, Math.max(left.maxSum, right.maxSum));    
        }
        else if(left.maxSum > right.maxSum) {
            mp.maxSum = left.maxSum;
        }
        else{
            mp.maxSum = right.maxSum;
        }       
        return mp;
    }
}