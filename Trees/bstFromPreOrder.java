// Time complexity O(N)
// leetcode 1008
public class bstFromPreOrder {
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
    static int i;
    public static TreeNode bstFromPreorder(int[] preorder) {
        int lr = -(int)1e9;
        int rr = (int)1e9;
        i = 0;
        return constructBST(preorder, lr, rr);
    }

    public static TreeNode constructBST(int[] arr, int lr, int rr){
        if(i >= arr.length || arr[i] < lr || arr[i] > rr) return null;

        TreeNode n = new TreeNode(arr[i++]);
        n.left = constructBST(arr, lr, n.val);
        n.right = constructBST(arr, n.val, rr);
        return n;
    }
    public static void main(String[] args){
        int[] arr = {3, 2, 1, 6, 5, 7};
        TreeNode root = bstFromPreorder(arr);
    }
}
