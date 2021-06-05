// leetcode 987 
import java.util.*;
public class verticalOrderOfBinaryTree {
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
    //hroizontal level = hl
    static class Pair {
        TreeNode n;
        int vl;
        int hl;

        Pair(TreeNode n, int vl, int hl) {
            this.n = n;
            this.vl = vl;
            this.hl = hl;
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

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.add(new Pair(root, 0, 0));

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (q.size() > 0) {
            int s = q.size();

            for (int i = 0; i < s; i++) {
                Pair rm = q.remove();
                min = Math.min(min, rm.vl);
                max = Math.max(max, rm.vl);
                if (map.get(rm.vl) != null) {
                    map.get(rm.vl).add(rm);
                } else {
                    List<Pair> list = new ArrayList<>();
                    list.add(rm);
                    map.put(rm.vl, list);
                }

                if (rm.n.left != null) {
                    q.add(new Pair(rm.n.left, rm.vl - 1, rm.hl + 1));
                }

                if (rm.n.right != null) {
                    q.add(new Pair(rm.n.right, rm.vl + 1, rm.hl + 1));
                }
            }
        }

        for (int i = min; i <= max; i++) {
            Collections.sort(map.get(i), (a, b) -> {
                if(a.hl < b.hl) return -1;
                else if(a.hl > b.hl) return 1;
                else return a.n.val - b.n.val;
            });

            List<Integer> temp = new ArrayList<>();
            for(Pair p : map.get(i)){
                temp.add(p.n.val);
            }
            ans.add(temp);
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
