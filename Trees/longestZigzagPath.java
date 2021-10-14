class longestZigzagPath{
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

	static class Pair{
		int forwardHeight = -1;
		int backwardHeight = -1;
		int max = 0;
	}

	public int longestZigZag(TreeNode root) {
       Pair p = longestZigZag_(root);
       return p.max;
    }

    public Pair longestZigZag_(TreeNode root){
    	if(root == null) return new Pair();
    	Pair left = longestZigZag_(root.left);
    	Pair right = longestZigZag_(root.right);
    	Pair ans = new Pair();
		
    	ans.max = Math.max(left.max , Math.max(right.max, Math.max(left.backwardHeight, right.forwardHeight) + 1));
    	ans.forwardHeight = left.backwardHeight + 1;
    	ans.backwardHeight = right.forwardHeight + 1;
    	return ans;
    }
}