/*
Given a Binary Search Tree (BST) with root node root, and a target value V, split the tree into two subtrees where one subtree has nodes that are all smaller or equal to the target value, while the other subtree has all nodes that are greater than the target value.  It's not necessarily the case that the tree contains a node with value V.
Additionally, most of the structure of the original tree should remain.  Formally, for any child C with parent P in the original tree, if they are both in the same subtree after the split, then node C should still have the parent P.
You should output the root TreeNode of both subtrees after splitting, in any order.
Example 1:
Input: root = [4,2,6,1,3,5,7], V = 2
Output: [[2,1],[4,3,6,null,null,5,7]]
Explanation:
Note that root, output[0], and output[1] are TreeNode objects, not arrays.

time complexity Log(n) and space O(1);
*/
import java.util.*;
public class splitBST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString(){
            return this.data + "";
        }
    }

    public static Node constructTree(Integer[] arr){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(arr[0], null, null));
        Node root = null;
        int i = 1;
        while(q.size() > 0 && i < arr.length){
            Node rp = q.remove();
            if(root == null){
                root = rp;
            }

            //adding the left child
            if(arr[i] != null){
                rp.left = new Node(arr[i], null, null);
                q.add(rp.left);
            }
            i++;

            if(i >= arr.length) break;
            
            //adding the right child
            if(arr[i] != null){
                rp.right = new Node(arr[i], null, null);
                q.add(rp.right);
            }
            i++;
        }
        return root;
    }

    public static void display(Node root){
        if(root == null) return;
        String str = "";
        str += root.left == null ? "." : root.left.data;
        str += " => " +  root.data + " <= ";
        str += root.right == null ? "." : root.right.data;
        System.out.println(str);

        display(root.left);
        display(root.right);
    }
    public static Node[] split(Node root, int val){
        if(root == null){
            return new Node[] {null, null};
        }
        else if(root.data <= val){
            // means all the values in the subtree belong to first half but we are not sure about right subtree
            //so we have to right subtree
            Node[] ans = split(root.right, val);
            root.right = ans[0];
            ans[0] = root;
            return ans;
        }
        else{
            Node[] ans = split(root.left, val);
            root.left = ans[1];
            ans[1] = root;
            return ans;
        }
    }
    public static void main(String[] args){
        Integer[] arr = {4, 2, 6, 1, 3, 5, 7};
        int val = 2;
        Node root = constructTree(arr);
        display(root);

        System.out.println();
        Node[] ans = split(root, val);
        for(Node n: ans){
            display(n);
            System.out.println();
        }
    }  
}
