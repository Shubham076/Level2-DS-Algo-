//leetcode 1026
class maximumDifferenceBetweenNodeAndAncestor {
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

    public static void helper(TreeNode root, int min, int max) {
        if (root == null) {
            ans = Math.max(ans, Math.abs(min - max));
            return;
        }

        helper(root.left, Math.min(root.val, min), Math.max(root.val, max));
        helper(root.right, Math.min(root.val, min), Math.max(root.val, max));

    }

    public int maxAncestorDiff(TreeNode root) {
        ans = Integer.MIN_VALUE;
        helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return ans;
    }
}