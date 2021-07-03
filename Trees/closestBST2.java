/*
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
*/
import java.util.*;
class closestBST2{
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	static LinkedList<Integer> ans;
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
        ans = new LinkedList<>();
        helper(root, target, k);
        return ans;
    }

    //O(N)
    public static void helper(TreeNode root, double target, int k){
    	if(root == null){
    		return;
    	}

    	helper(root.left, target, k);

    	if(ans.size() < k){
    		ans.add(root.val);
    	}
    	else{
    		if(Math.abs(root.val - target) < Math.abs(ans.peekFirst() - target)){
    			ans.removeFirst();
    			ans.add(root.val);
    		}
    	}
    	helper(root.right, target, k);
    }
}