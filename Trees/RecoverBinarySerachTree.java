//leetcode 99
public class RecoverBinarySerachTree {
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

    TreeNode prev;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {
        first = second = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        correctTree(root);
        int temp = this.first.val;
        this.first.val = this.second.val;
        this.second.val = temp;
    }

    //using the property of bst that inorder traversal of bst is sorted
    //if any point of time we found a decreasing order means we have found the defective node
    public void correctTree(TreeNode root) {
        if (root == null)
            return;

        // inorder traversal
        correctTree(root.left);
        
        // first element found that is decreasing than prev(first prev)
        if (this.first == null && root.val < this.prev.val) {
            first =  prev;
        }

        // second element found that is decreasing than prev
        if (first != null && root.val < this.prev.val) {
            second = root;
        }

        // updating prev pointer
        this.prev = root;
        correctTree(root.right);
    }
}