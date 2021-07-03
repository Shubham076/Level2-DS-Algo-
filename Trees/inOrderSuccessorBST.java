//lintcode 448
class inOrderSuccessorBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	// O(N)
	static TreeNode ans;
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		ans = null;
		solve(root, p);
		return ans;
    }

    public static void solve(TreeNode root, TreeNode p){
    	if(root == null) return;

    	solve(root.left, p);
    	if(ans == null && root.val > p.val){
    		ans = root;
    		return;
    	}
    	solve(root.right, p);
    }

    // O(h) height of tree
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
		return helper2(root, p);
    }

    public static TreeNode helper2(TreeNode root, TreeNode p){
    	//first we find the node in the tree
    	TreeNode ans = null;
    	while(root != null){
    		if(root.val == p.val){

    			//case 1 after node is found we check if node.right == null then root is the answer i.e
    			//stored in ans variable
    			if(root.right != null){
    			
    				//case 2 if right subtree is not null then the leftmost of the rightSubtree
    				//is the answer
    				TreeNode rp1 = root.right;
    				while(rp1.left != null){
    					rp1 = rp1.left;
    				}
    				ans = rp1;
    			}
    			break;
    		}
    		else if(root.val < p.val){
    			root = root.right;
    		}
    		else{
    			ans = root;
    			root = root.left;
    		}
    	}
    	return ans;
    }
}