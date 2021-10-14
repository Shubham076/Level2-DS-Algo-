/*
https://www.geeksforgeeks.org/path-length-maximum-number-bends/
Given a binary tree, find the path length having maximum number of bends. 
Note: Here, bend indicates switching from left to right or vice versa while traversing in the tree. 
For example, consider below paths (L means moving leftwards, R means moving rightwards): 
LLRRRR – 1 Bend 
RLLLRR – 2 Bends 
LRLRLR – 5 Bends

note: if there are multiple paths in which number of bends are equal to maxbends return path with
max path len
*/
import java.util.*;
class pathLengthWithMaxBends{
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

    static int maxBends;
    static int maxPath;

    // when we going left assuming dir => false, when we are going right assuming dir = true
    public static void solve(Node root, int bends, int len, boolean dir, boolean parDir){
        if(root == null){
            return;
        }

        int n = bends;
        if(dir != parDir){
            n++;
        }

        //leaf node
        if(root.left == null && root.right == null){
            if(n > maxBends){
                maxBends = n;
                maxPath = len;
            }
            else if(n == maxBends){
                if(len > maxPath){
                    maxPath = len;
                }
            }
        }

        solve(root.left, n, len + 1, false, dir);
        solve(root.right, n, len + 1, true, dir);
    }
    public static void main(String[] args){
        Integer[] arr = {1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1, null, 1};
        Node root = constructTree(arr);
        // display(root);
        maxBends = 0;
        maxPath = 0; 

        /*
        according to our logic left dir is false and right dir is true
        but for the first time which dir we choose for the root element
        for eg =>        1
                        / \
                       2   3
        if we make root false the moment we reach 2 dir of 2 is false no bend is found it is fine
        but the moment we reach 3 dir becomes true and parent is false so our code says it is a bend 
        but it is not
        therefore to solve this problem we make 2 calls to the left and right subtree
        and out answer will be maxPath + 1 as root is also included in the path
        */
        solve(root.left, 0, 0, false, false);
        solve(root.right, 0, 0, true, true);

        System.out.println("Len of maxpath: " + (maxPath + 1) + ", " + "Max bends: " + maxBends);
    }   
}