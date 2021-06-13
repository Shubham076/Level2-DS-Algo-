import java.util.*;
public class widthOfBinaryTree {
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
    static int[] ans; //0th index stores min vl & 1st index stores max vl
    //this method calculates the length of shadow tree is going to make if a torch is lit from top view of tree 
    //or width in terms of total vertical levels
    static void width(Node root, int vl){  //vertical level = vl
        if(root == null) return;
        ans[0] = Math.min(ans[0] , vl);
        ans[1] = Math.max(ans[1], vl);

        width(root.left, vl - 1);
        width(root.right, vl + 1);
    }

    //leetcode 662
    // The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.
    // above solution wont work
    static class Pair{
        Node n;
        int idx;
        Pair(Node n, int idx){
            this.n = n;
            this.idx = idx;
        }
    }
    static int width2(Node root){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        int min = 0, max = 0;
        int res = 1;
        while(q.size() > 0){
            int s = q.size();

            for(int i = 0; i < s; i++){
                Pair rp = q.remove();
                if(i == 0){
                    min = rp.idx;
                }

                if(i == s - 1){ 
                    max = rp.idx;
                }

                if(rp.n.left != null){
                    q.add(new Pair(rp.n.left, 2 * rp.idx + 1));
                }

                if(rp.n.right != null){
                    q.add(new Pair(rp.n.right, 2 * rp.idx + 2));
                }
            }
            res = Math.max(res, (max - min + 1));
        }
        return res;
    }

    public static void main(String[] args){
        Integer[] arr = {1, 3, 2, 5, 3, null, 9}; //level order
        Node root = constructTree(arr);
        ans = new int[2];
        width(root, 0);
        System.out.println(ans[1] - ans[0] + 1);
        System.out.println(width2(root));
    }    
}
