/*
https://leetcode.com/discuss/interview-question/958697/amazon-virtual-interview-binary-tree
Given a binary tree, print the node values in any order which follow SpecialSum Property.
SpecialSum Property is having sum of all the left childs only, equal to the sum of all the right childs only.
Note– all leaf nodes are not following SpecialSum Property.
 
*/
import java.util.*;
class printSpecialNodes{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right =  right;
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
    static ArrayList<Integer> ans;
    public static int[] solve(Node root){
        if(root == null){
            return new int[] {0, 0};
        }

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        int lsum = root.data + left[0];
        int rsum = root.data + right[1];

        if(lsum == rsum && (root.left != null || root.right != null)){
            ans.add(root.data);
        }
        return new int[] {lsum, rsum};
    }
    public static void main(String[] args){
        ans = new ArrayList<>();
        Integer[] arr = {26, 18, 30, 10, 21, 7, 5, 8, 11, null, null, null, null, 12, 2, 3, 4, 6};
        Node root = constructTree(arr);
        solve(root);
        System.out.println(ans);
    }
}