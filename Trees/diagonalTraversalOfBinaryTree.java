import java.util.*;
public class diagonalTraversalOfBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
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

    public static ArrayList<ArrayList<Integer>> diagonalTraversal(Node root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() > 0){
            int s = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while(s-- > 0){
                Node n = q.remove();

                while(n != null){
                    temp.add(n.data);

                    if(n.left != null)
                        q.add(n.left);
                    n = n.right;
                }
            }
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String[] args){
        Integer[] arr = {1, 2, 3, 4, 5};
        Node root = constructTree(arr);
        ArrayList<ArrayList<Integer>> ans = diagonalTraversal(root);
        System.out.println(ans);
    }
}
