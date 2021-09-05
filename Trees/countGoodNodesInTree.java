//leetcode 1448
public class countGoodNodesInTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int travel(TreeNode root, int max) {
        if (root == null) return 0;
        int cnt = root.val >= max ? 1 : 0;

        cnt += travel(root.left, Math.max(max, root.val));
        cnt += travel(root.right, Math.max(max, root.val));
        return cnt;
    }

    public int goodNodes(TreeNode root) {
        return travel(root, Integer.MIN_VALUE);
    }
}
