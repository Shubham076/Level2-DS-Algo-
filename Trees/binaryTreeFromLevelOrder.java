//leetcode serialize and deserialize binary tree
import java.util.*;
public class binaryTreeFromLevelOrder {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node constructTree(Integer[] arr){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(arr[0], null, null));
        Node root = null;
        int i = 1;
        while(q.size() > 0){
            Node rp = q.remove();
            if(root == null){
                root = rp;
            }

            //adding the left child
            if(arr[i] != null){
                rp.left = new Node(arr[i], null, null);
                q.add(rp.left);
                i++;
            }
            else{
                i++;
            }

            //adding the right child
            if(arr[i] != null){
                rp.right = new Node(arr[i], null, null);
                q.add(rp.right);
                i++;
            }
            else{
                i++;
            }
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


    public static void main(String[] args){
        Integer[] arr = {1, 2, 3, null, null, 4, 5, null, null, null, null};
        Node root = constructTree(arr);
        display(root);
    }
    
}
