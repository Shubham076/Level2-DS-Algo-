// leetcode 173 in order
import java.util.*;
class BSTIterator {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	TreeNode cur;
	Stack<TreeNode> st;
	public BSTIterator(TreeNode root) {
		cur = root;
		st = new Stack<>();
	}

	public int next() {
		while(cur != null){
			st.push(cur);
			cur = cur.left;
		}
		TreeNode rem = st.pop();
		cur = rem.right;
		return rem.val;
	}

	public boolean hasNext() {
		return cur != null || st.size() > 0;		
	}
}