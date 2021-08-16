//leetcode 111
import java.util.*;
public class minimumDepthOfBinrayTree {
    public class TreeNode {
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

    //bfs or level order trtaversal 
    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        int d = 1;
        q.add(root);
        while(q.size() > 0){
            int s = q.size();
            while(s-- > 0){
                TreeNode rm = q.remove();
                if(rm.left == null && rm.right == null){
                    return d;
                }

                if(rm.left != null){
                    q.add(rm.left);
                }
                if(rm.right != null){
                    q.add(rm.right);
                }
            }
            d++;
        }
        return -1;
    }
}
