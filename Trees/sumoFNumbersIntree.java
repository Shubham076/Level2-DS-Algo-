/*
Given a tree were each leaf to root path represents a number, and we were supposed to return the sum of all the numbers that were formed int the tree
eg      3
      /   \
    2      4
   /      / \ 
  1      5   6
  ans = 123 + 456 + 643 = 1309
  O(N) time and o(1) space
*/
import java.util.*;
public class sumoFNumbersIntree {
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
    static int sum = 0;
    public static void solve(Node root, String n){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            n = root.data + n; 
            sum += Integer.parseInt(n);
            return;
        }

        solve(root.left, root.data + n);
        solve(root.right, root.data + n);
    }
    public static void main(String[] args){
        Integer[] arr = {3, 2, 4, 1, null, 5, 6};
        Node root = constructTree(arr);
        solve(root, "");;
        System.out.println(sum);
    }
}
