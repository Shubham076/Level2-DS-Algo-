/*
https://www.geeksforgeeks.org/find-closest-leaf-binary-tree/
Find the closest leaf in a Binary Tree
Difficulty Level : Hard
Last Updated : 25 Jun, 2021
Given a Binary Tree and a key ‘k’, find distance of the closest leaf from ‘k’.
*/
public class closestLeaf {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static int ans;
    static int min;
    public static void printLeaf(TreeNode root, TreeNode block, int d){
        if(root == null || root == block){
            return;
        }
        if(root.left == null && root.right == null){
            if(d < min){
                min = d;
                ans = root.val;
            }
        }
        printLeaf(root.left, block , d + 1);
        printLeaf(root.right, block , d + 1);
    }

    public static boolean solve(TreeNode root, int k){
        if(root == null){
            return false;
        }
        if(root.val == k){
            printLeaf(root, null, 0);
            return true;
        }
        boolean ld = solve(root.left, k);
        if(ld){
            printLeaf(root, root.left, 0);
            return true;
        }
        boolean rd = solve(root.right, k);
        if(rd){
            printLeaf(root, root.right, 0);
            return true;
        }
        return false;
    }

    public int findClosestLeaf(TreeNode root, int k) {
        ans = -1;
        min = Integer.MAX_VALUE;
        solve(root, k);
        return ans;
    }
}
