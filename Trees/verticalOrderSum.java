import java.util.*;
public class verticalOrderSum {
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

    
    static class Pair {
        Node n;
        int vl;

        Pair(Node n, int vl) {
            this.n = n;
            this.vl = vl;
        }
    }

    static int[] minmax;
    static void width(Node root, int vl){  //vertical level = vl
        if(root == null) return;
        minmax[0] = Math.min(minmax[0] , vl);
        minmax[1] = Math.max(minmax[1], vl);

        width(root.left, vl - 1);
        width(root.right, vl + 1);
    }

    public static ArrayList<Integer> verticalOrderSum(Node root) {
        Queue<Pair> q = new ArrayDeque<>();
        minmax = new int[2];
        width(root, 0);
        ArrayList<Integer> ans = new ArrayList<>();
        int len = minmax[1] - minmax[0] + 1;
        for(int i = 0; i < len; i++){
            ans.add(0);
        }

        q.add(new Pair(root, Math.abs(minmax[0])));

        while (q.size() > 0) {
            int s = q.size();
            while(s-- > 0){
                Pair rp = q.remove();
                ans.set(rp.vl, ans.get(rp.vl) + rp.n.data);

                if(rp.n.left != null){
                    q.add(new Pair(rp.n.left, rp.vl - 1));
                }
                if(rp.n.right != null){
                    q.add(new Pair(rp.n.right, rp.vl + 1));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args){
        Integer[] arr = {10, 20, 30, 40, 60, 90, 100}; //level order
        Node root = constructTree(arr);
        ArrayList<Integer> ans = verticalOrderSum(root);
        System.out.println(ans);
    }
}
