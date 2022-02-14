/* 
https://www.geeksforgeeks.org/find-count-of-singly-subtrees/
A Single Valued Subtree is one in which all the nodes have same value.
 Expected time complexity is O(n).
*/
import java.util.*;
public class singleValuedSubtree {
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
    static int cnt;
    public static boolean isSame(Node root, int data){
        if(root == null){
            return true;
        }
        boolean left = isSame(root.left, data);
        boolean right = isSame(root.right, data);
        if(left && right && root.data == data){
            return true;
        }
        return false;
    }

    //O(n * n)
    public static void cntTree1(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            cnt++;
            return;
        }

        boolean left = isSame(root.left, root.data);
        boolean right = isSame(root.right, root.data);

        if(left == true && right == true){
            cnt++;
        }

        cntTree1(root.left);
        cntTree1(root.right);
    }

    // o(N)
    public static boolean cntTree2(Node root){
        if(root == null){
            return true;
        }

        boolean left = cntTree2(root.left);
        boolean right = cntTree2(root.right);

        if(left == false || right == false){
            return false;
        }

        if(root.left != null && root.left.data != root.data){
            return false;
        }

        if(root.right != null && root.right.data != root.data){
            return false;
        }
        cnt++;
        return true;
    }

    public static void main(String[] args){
        Integer[] arr = {5, 1, 5, 5, 5, null, 5};
        Node root = constructTree(arr);
        cnt = 0;
        cntTree2(root);
        System.out.println(cnt);        
    }   
}
