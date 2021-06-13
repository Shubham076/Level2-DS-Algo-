//leetcode 105
//O(NlogN) further reduces to O(N) is we used hashing to find the number is inorder
class contructFromPreAndInOrder{
	static class TreeNode {
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

    public TreeNode buildTree(int[] pre, int[] in) {
    	return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie){
    	if(ps > pe || is > ie){
    		return null;
    	}

    	int idx = -1;
    	TreeNode n = new TreeNode(pre[ps]);

        //logn -> O(1) using hashmap
    	for(int i = is; i <= ie; i++){
    		if(in[i] == pre[ps]){
    			idx = i;
    			break;
    		}
    	}
    	int cnt = idx - is;

    	n.left = construct(pre, ps + 1, ps + cnt, in, is, idx - 1);
    	n.right = construct(pre, ps + cnt + 1, pe, in, idx + 1, ie);

    	return n;
    }
}