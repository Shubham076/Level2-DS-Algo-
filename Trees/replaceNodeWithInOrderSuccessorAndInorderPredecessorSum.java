/*
binary tree =>     
              1
             / \
            2   3
           / \  / \
          4   5 6  7

output:
               11
              /  \
             9    13
           /  \   /  \
          2   3   4   3
*/
import java.util.*;
public class replaceNodeWithInOrderSuccessorAndInorderPredecessorSum {
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
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        int i = 0;
        while(q.size() > 0){
            int s = q.size();
            System.out.print("Level " + i + ": ");
            while(s-- > 0){
                Node rm = q.remove();
                System.out.print(rm.data + " ");

                if(rm.left != null){
                    q.add(rm.left);
                }

                if(rm.right != null){
                    q.add(rm.right);
                }
            }
            System.out.println();
            i++;
        }
    }

    static Node prev = null;
    static int pred = 0;
    public static void solve(Node root){
       if(root == null){
           return;
       }

       solve(root.left);
       int v = root.data;
       if(prev != null){
           prev.data += v;  //adding the successor of prev;
       }
       root.data = pred; //adding the predecessor of current
       prev = root;
       pred = v;
       solve(root.right);
    }
    public static void main(String[] args){
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node root = constructTree(arr);
        display(root);
        solve(root);
        System.out.println();
        display(root);
    }
}
