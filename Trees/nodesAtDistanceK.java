//leetcode 863
import java.util.*;
class nodesAtDistanceK {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void printKLevelsDown(TreeNode root , int  k , TreeNode block){
        if(root == null || k < 0 || root == block)
            return;

        if(k == 0)
            ans.add(root.val);
        
            printKLevelsDown(root.left , k  - 1 , block);
            printKLevelsDown(root.right , k  - 1 , block);
    }

    public static ArrayList<TreeNode> node2Root(TreeNode root , int data){
        if(root == null)
            return new ArrayList<>();
        
        if(root.val == data){
            ArrayList<TreeNode> ans = new ArrayList<>();
            ans.add(root);
            return ans;
        }

        ArrayList<TreeNode> l = node2Root(root.left, data);
        if(l.size() > 0){
            l.add(root);
            return l;
        }

        ArrayList<TreeNode> r = node2Root(root.right, data);
        if(r.size() > 0){
            r.add(root);
            return r;
        }

        return new ArrayList<>();
    }

    static List<Integer> ans;
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<>();
        ArrayList<TreeNode> path = node2Root(root, target.val);
        for(int i = 0; i < path.size(); i++){
            printKLevelsDown(path.get(i), k - i , i == 0 ? null : path.get(i - 1));
        }
        return ans;
    }
}