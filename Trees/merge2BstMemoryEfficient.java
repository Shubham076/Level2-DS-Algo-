import java.util.*;
public class merge2BstMemoryEfficient {
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
    public static Node construct(int[] arr, int lo, int hi){
        if(lo > hi){
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        Node n = new Node(arr[mid], null, null);
        n.left = construct(arr, lo, mid - 1);
        n.right = construct(arr, mid + 1, hi);
        return n;
    }

    public static void solve(Node root1, Node root2){
        Node cur1 = root1;
        Node cur2 = root2;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        while(cur1 != null || st1.size() > 0 || cur2 != null || st2.size() > 0){
            while(cur1 != null){
                st1.push(cur1);
                cur1 = cur1.left;
            }

            while(cur2 != null){
                st2.push(cur2);
                cur2 = cur2.left;
            }

            Node rm1 = st1.size() > 0 ? st1.pop() : null;
            Node rm2 = st2.size() > 0 ? st2.pop() : null;

            if(rm1 == null && rm2 == null){
                break;
            }
            else if(rm1 == null){
                ans.add(rm2.data);
                cur2 = rm2.right;
            }
            else if(rm2 == null){
                ans.add(rm1.data);
                cur1 = rm1.right;
            }
            else if(rm1.data <= rm2.data){
                ans.add(rm1.data);
                cur1 = rm1.right;
                st2.push(rm2);
            }
            else if(rm1.data > rm2.data){
                ans.add(rm2.data);
                cur2 = rm2.right;
                st1.push(rm1);
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args){
        int[] arr1 = {1};
        int[] arr2 = {2, 3, 4, 5, 6, 7};
        Node root1 = construct(arr1, 0, arr1.length - 1);
        Node root2 = construct(arr2, 0, arr2.length - 1);
        solve(root1, root2);
    }
}
