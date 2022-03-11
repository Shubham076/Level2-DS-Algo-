/*
lintcode 649
given binary tree you have to make it upside down
a binary tree can be made upside down in following ways:
  the original left child becomes root;
  the root becomes the very right child;
  the right child becomes the new left child

  it is guaranteed that every node in the tree have either zero or two child

  eg =>                1               =>      2
                     /   \                    /  \
                     2    3                   3    1
  
  Algorithm:
    this can be solved by using simple dfs call
    using dfs we reach the left most node and return the leftmost node
    now after backtracking previous level or (1) in the example receives 2;
    let us assume cur = 1
    after backtracking we recieve new_root = 2;

    2 conditions need to be added:
    cur.left.left = cur.right  => setting the left child of 2 => 3
    cur.left.right = cur  => setting the rigth child of 2 => 1
    cur.left = null;
    cur.right = null;
    return new root;

    we need to perform these 2 condtion only at left subtree and we are done;
*/  
class binaryTreeUpsideDown{
    static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public static TreeNode solve(TreeNode root){
        if(root == null){
            return null;
        }
        //leftmost node
        if(root.left == null){
            return root;
        }
        TreeNode newRoot = solve(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;
        return solve(root);
    }
}