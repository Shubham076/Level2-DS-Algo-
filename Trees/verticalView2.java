import java.util.*;
public class verticalView2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //vertical level = vl
    static class Pair {
        TreeNode n;
        int vl;

        Pair(TreeNode n, int vl) {
            this.n = n;
            this.vl = vl;
        }
    }

    public static TreeNode constructTree(Integer[] arr) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(new TreeNode(arr[0], null, null));
        TreeNode root = null;
        int i = 1;
        while (q.size() > 0 && i < arr.length) {
            TreeNode rp = q.remove();
            if (root == null) {
                root = rp;
            }

            // adding the left child
            if (arr[i] != null) {
                rp.left = new TreeNode(arr[i], null, null);
                q.add(rp.left);
            }
            i++;

            if (i >= arr.length)
                break;

            // adding the right child
            if (arr[i] != null) {
                rp.right = new TreeNode(arr[i], null, null);
                q.add(rp.right);
            }
            i++;
        }
        return root;
    }

    static int[] minmax;
    static void width(TreeNode root, int vl) { //vertical level = vl
        if (root == null) return;
        minmax[0] = Math.min(minmax[0] , vl);
        minmax[1] = Math.max(minmax[1], vl);

        width(root.left, vl - 1);
        width(root.right, vl + 1);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        minmax = new int[2];
        width(root, 0);
        List<List<Integer>> ans = new ArrayList<>();
        int len = minmax[1] - minmax[0] + 1;
        for (int i = 0; i < len; i++) {
            ans.add(new ArrayList<Integer>());
        }

        q.add(new Pair(root, Math.abs(minmax[0])));

        while (q.size() > 0) {
            int s = q.size();
            while (s-- > 0) {
                Pair rp = q.remove();
                ans.get(rp.vl).add(rp.n.val);

                if (rp.n.left != null) {
                    q.add(new Pair(rp.n.left, rp.vl - 1));
                }
                if (rp.n.right != null) {
                    q.add(new Pair(rp.n.right, rp.vl + 1));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Integer[] arr = { 3, 1, 4, 0, 2, 2 }; // level order
        TreeNode root = constructTree(arr);
        List<List<Integer>> ans = verticalTraversal(root);
        System.out.println(ans);
    }
}
