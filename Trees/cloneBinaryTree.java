// https://practice.geeksforgeeks.org/problems/clone-a-binary-tree/1
class cloneBinaryTree {
	static class Node {
		int data;
		Node left, right, random;
		Node(int d) {
			data = d;
			left = null;
			right = null;
			random = null;
		}
	}
	public static void addCopyNodesToLeft(Node root){
		if(root == null) return;
		Node n = new Node(root.data);
		Node rp1 = root.left;
		root.left = n;
		n.left = rp1;

		addCopyNodesToLeft(root.left.left);
		addCopyNodesToLeft(root.right);
	}

	public static void connectRandomPointers(Node root){
		if(root == null) return;
		if(root.random != null){
			root.left.random = root.random.left;
		}

		connectRandomPointers(root.left.left);
		connectRandomPointers(root.right);
	}

	public static Node extractTree(Node root){
		if(root == null) return null;
		Node l = extractTree(root.left.left);
		Node r = extractTree(root.right);
		Node temp = root.left;
		root.left = root.left.left;
		temp.left = l;
		temp.right = r;
		return temp;
	}
	//O(N) time O(1) space
	public static Node cloneNode(Node root) {
		//add copy nodes
		addCopyNodesToLeft(root);

		//connect the random pointers
		connectRandomPointers(root);

		//extract tree
		return extractTree(root);
	}
}