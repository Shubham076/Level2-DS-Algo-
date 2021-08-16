//leetcode 993
public class binaryTreeCousions {
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

    static TreeNode xpar;
    static TreeNode ypar;
    static int dx;   //depth of x
    static int dy;

    public static void helper(TreeNode root, TreeNode par, int x, int y, int d) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            xpar = par;
            dx = d;
        } else if (root.val == y) {
            ypar = par;
            dy = d;
        } else {
            helper(root.left, root, x, y, d + 1);
            helper(root.right, root, x, y, d + 1);
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        xpar = ypar = null;
        dx = dy = -1;
        helper(root, null, x, y, 0);
        return dx == dy && xpar != ypar;
    }
}
