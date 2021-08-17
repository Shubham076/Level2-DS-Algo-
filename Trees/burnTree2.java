//print the time at which each node in a tree burns
import java.util.*;
public class burnTree2 {
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
    public static Node construct(Integer[] arr){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(arr[0], null, null));
        int i = 1;
        Node root = null;
        while(q.size() > 0 && i < arr.length){
            Node rm = q.remove();
            if(root == null){
                root = rm;
            }

            if(arr[i] != null){
                rm.left = new Node(arr[i], null, null);
                q.add(rm.left);
            }
            i++;

            if(i >= arr.length){
                break;
            }

            if(arr[i] != null){
                rm.right = new Node(arr[i], null, null);
                q.add(rm.right);
            }
            i++;
        }
        return root;
    }

    static ArrayList<ArrayList<Integer>> ans;
    public static void burnTree(Node root, int time, Node block){
        if(root == null || root == block){
            return;
        }
        if(time == ans.size()) ans.add(new ArrayList<>());
        ans.get(time).add(root.data);

        burnTree(root.left, time + 1, block);
        burnTree(root.right, time + 1, block);
    }

    public static int solve(Node root, Node fireNode){
        if(root == null) return -1;

        if(root.data == fireNode.data){
            burnTree(root, 0, null);
            //parent is going to burn 1 sec later
            return 1;
        }

        int lt = solve(root.left, fireNode);
        if(lt != -1){
            burnTree(root, lt, root.left);
            return lt + 1;
        }

        int rt = solve(root.right, fireNode);
        if(rt != -1){
            burnTree(root, rt, root.right);
            return rt + 1;
        }

        return -1;
    }

    public static void main(String[] args){
        Integer[] arr = {1, 2, 3, 4, 5, null, 6, null, null, 7, 8, null, 9, null, null, null, null, null, 10};
        Node root = construct(arr);
        ans = new ArrayList<>();
        Node fire = new Node(8, null, null);
        solve(root, fire);
        System.out.println(ans);
    }
}
