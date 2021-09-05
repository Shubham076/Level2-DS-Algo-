import java.util.*;
public class reverseOddLevelsOfPerfectBinaryTree {
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

    public static void reverseOddLevel(Node left, Node right, int l){
        if(left == null || right == null){
            return;
        }

        if(l % 2 == 0){
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
        }

        reverseOddLevel(left.left, right.right, l + 1);
        reverseOddLevel(left.right, right.left, l + 1);
    }

    public static void reverseEvenLevel(Node left, Node right, int l){
        if(left == null || right == null){
            return;
        }

        if(l % 2 == 1){
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
        }

        reverseEvenLevel(left.left, right.right, l + 1);
        reverseEvenLevel(left.right, right.left, l + 1);
    }
    public static void main(String[] args){
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Node root = constructTree(arr);
        display(root);
        // reverseOddLevel(root.left, root.right, 0);
        reverseEvenLevel(root.left, root.right, 0);
        display(root);
    }
}
