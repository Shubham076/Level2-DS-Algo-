//leetcode 863
import java.util.*;
class nodesAtDistanceK {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    static List<Integer> ans;
    public static void printkLevelsDown(TreeNode root, int k, TreeNode block){
        if(root == null || k < 0 || root == block){
            return;
        }

        if(k == 0){
            ans.add(root.val);
        }
        printkLevelsDown(root.left, k - 1, block);
        printkLevelsDown(root.right, k - 1, block);
    }
    public static int find(TreeNode root, int target, int k){
        if(root == null){
            return -1;
        }

        if(root.val == target){
            printkLevelsDown(root, k, null);
            return 1;  
        }

        int ld = find(root.left, target, k);
        if(ld != -1){
            printkLevelsDown(root, k - ld, root.left);
            return ld + 1;
        }

        int rd = find(root.right, target, k);
        if(rd != -1){
            printkLevelsDown(root, k - rd, root.right);
            return rd + 1;
        }

        return -1;
    }
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<>();
        find(root, target.val, k);
        return ans;
    }
}