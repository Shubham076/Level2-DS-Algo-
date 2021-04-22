//leetcode 968
class binaryTreeCameras {
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

	//-1 means need camera
	//0 used one camera
	//1 I am already covered

	static int camera;
	public int minCameraCover(TreeNode root) {
		camera = 0;
		if(minCameraCover_(root) == -1) camera++;
		return camera;
	}

	public int minCameraCover_(TreeNode root){
		if(root == null) return 1;

		int lc = minCameraCover_(root.left);
		int rc = minCameraCover_(root.right);

		if(lc == -1 || rc == -1){
			camera++;
			return 0;
		}

		if(lc == 0 || rc == 0){
			return 1;
		}

		//means left is covered and right is covered
		return -1;
	}
}