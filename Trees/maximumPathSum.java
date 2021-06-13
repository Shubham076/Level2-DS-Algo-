import java.util.*;
class maximumPathSum {
    static class Node {
        int data;
        Node left = null;
        Node right = null;

        public Node(int data , Node left , Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair {
        Node n;
        int state;
        public Pair(Node n , int state) {
            this.n = n;
            this.state = state;
        }
    }


    private static Node constructBinaryTree(Integer[] arr) {
        Stack<Pair> s = new Stack<>();
        Node root = new Node(arr[0] , null , null);
        s.push(new Pair(root , 1));
        int idx = 0;

        while (s.size() > 0) {
            Pair p  = s.peek();

            if (p.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    Node left = new Node(arr[idx] , null , null);
                    p.n.left = left;
                    s.push(new Pair(left , 1));
                }
                p.state++;

            } else if (p.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    Node right = new Node(arr[idx] , null , null);
                    p.n.right = right;
                    s.push(new Pair(right , 1));
                }
                p.state++;
            } else {
                s.pop();
            }
        }

        return root;
    }

    public static void display(Node root) {

        if (root == null)
            return;
        String str = "";
        str += root.left != null ? root.left.data + " " : ". ";
        str += "<-- " + root.data + " -->";
        str += root.right != null ? " " + root.right.data :  " .";
        System.out.println(str);


        display(root.left);
        display(root.right);

    }

    static int max = Integer.MIN_VALUE;
    public static int maxpathSum(Node node) {
        if (node == null) return 0;

        int lmax = Math.max(0, maxpathSum(node.left));
        int rmax = Math.max(0, maxpathSum(node.right));

        max = Math.max(max , lmax + node.data + rmax);

        /* returning max linear valid path to our parent (why not returning
        // root.val + left.val + right.val in path because it is given in question node can be a part of
         atmost one path)
        or we can also see that a path has only 2 end point start or end
        while considering  root.val + left.val + right.val the path has become three end point
                            20
                                \
                                  10
                                 /   \
                                4      5
        20 ask for max path of right subtree so two valid paths possible are either 10 - 4
        or 10 - 5 if we consider 4, 10, 5 its not a path as it has three ends
        */
        return Math.max(lmax, rmax) + node.data;
    }

    public static void main(String[] args) {
        Integer[] arr = { -10, 9, null, null, 20, 15, null, null, 7, null, null};
        // The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
        Node root = constructBinaryTree(arr);
        display(root);
        maxpathSum(root);
        System.out.println(max);
    }
}