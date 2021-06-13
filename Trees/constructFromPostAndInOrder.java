class constructFromPostAndInOrder{
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

    public TreeNode buildTree(int[] post, int[] in) {
    	return construct(post, 0, post.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode construct(int[] post, int ps, int pe, int[] in, int is, int ie){
    	if(ps > pe || is > ie){
    		return null;
    	}

    	int idx = -1;
    	TreeNode n = new TreeNode(post[pe]);
    	for(int i = is; i <= ie; i++){
    		if(in[i] == post[pe]){
    			idx = i;
    			break;
    		}
    	}
    	int cnt = idx - is;

    	n.left = construct(post, ps, ps + cnt - 1, in, is, idx - 1);
    	n.right = construct(post, ps + cnt, pe - 1, in, idx + 1, ie);

    	return n;
    }
}