//leetcode 337

class houseRobber {
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
		int withRobbery = 0;
		int withoutRobbery = 0;
	}
	public int rob(TreeNode root) {
		Pair p = rob_(root);
		return Math.max(p.withRobbery, p.withoutRobbery);
	}

	public Pair rob_(TreeNode root){
		if(root == null) return new Pair();
		Pair left = rob_(root.left);
		Pair right = rob_(root.right);

		Pair myAns = new Pair();
		myAns.withRobbery = left.withoutRobbery + root.val + right.withoutRobbery;
		myAns.withoutRobbery = Math.max(left.withRobbery, left.withoutRobbery) + Math.max(right.withRobbery, right.withoutRobbery);
		return myAns;
	}
}