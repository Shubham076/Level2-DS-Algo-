public class bstFromPostOrder {
    static class TreeNode {
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

    static int i;

    public static TreeNode bstFromPostorder(int[] postorder) {
        int lr = -(int) 1e9;
        int rr = (int) 1e9;
        i = postorder.length - 1;
        return constructBST(postorder, lr, rr);
    }

    public static TreeNode constructBST(int[] arr, int lr, int rr) {
        if (i < 0 || arr[i] < lr || arr[i] > rr)
            return null;

        TreeNode n = new TreeNode(arr[i--]);
        n.right = constructBST(arr, n.val, rr);
        n.left = constructBST(arr, lr, n.val);
        return n;
    }

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));
        System.out.println(sb);
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 6, 7, 5, 3 };
        TreeNode root = bstFromPostorder(arr);
        display(root);
    }
}
