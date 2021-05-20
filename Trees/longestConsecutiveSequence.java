//lintcode 595
public class longestConsecutiveSequence {
    static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static int ans;

    public void solve(TreeNode root, int curLen, int expectedSum) {
        if (root == null)
            return;

        if (root.val == expectedSum) {
            curLen += 1;
        }
        else{
            curLen = 1;
        }

        ans = Math.max(ans, curLen);
        solve(root.left, curLen, root.val + 1);
        solve(root.right, curLen, root.val + 1);
    }

    public int longestConsecutive(TreeNode root) {
        ans = Integer.MIN_VALUE;
        solve(root, 0, 1);
        return ans;
    }
}
