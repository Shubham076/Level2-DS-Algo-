/*
Consider a binary tree of N nodes (1 Root and N-1 descendants).
The tree is represented as a series of relationships of each node to the Root node such as 
L, R, LL, LR.. and so on, where each node is left (L) to Root or left-left (LL) or right-left (RL)
 to Root and so on. Write a program to build the tree
and print preorder traversal
*/
public class buildTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static void traverse(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        traverse(root.left);
        traverse(root.right);
    }

    static void buildTree(Node root, String s, int val) {
        Node cur = root;
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                cur = cur.left;
            } else
                cur = cur.right;
        }
        Node nn = new Node(val);
        if (s.charAt(n - 1) == 'L') {
            cur.left = nn;
        }
        else
            cur.right = nn;
    }

    public static void main(String[] args) {
        int n = 8;
        int root = 111;
        Node r = new Node(root);
        String[] str = { "L", "R", "LL", "LR", "RL", "RR", "RRL" };
        int[] val = { 141, 282, 72, 36, 92, 141, 99 };
        // n - 1 nodes in the form o String val
        for (int i = 0; i < n - 1; i++) {
            buildTree(r, str[i], val[i]);
        }
        traverse(r);
    }
}
