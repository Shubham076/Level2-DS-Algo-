import java.util.*;
class leftViewOfBinaryTree {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}
	//level order traversal
	public ArrayList<Integer> leftView(Node root) {
		// Your code here
		Queue<Node> q = new ArrayDeque<>();
		ArrayList<Integer> ans = new ArrayList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Node rp = q.remove();
				if (i == 0) ans.add(rp.data);

				if (rp.left != null) {
					q.add(rp.left);
				}

				if (rp.right != null) {
					q.add(rp.right);
				}
			}
		}

		return ans;
	}

	//preorder traversal
	public ArrayList<Integer> leftView2(Node root) {
		ArrayList<Integer> ans = new ArrayList<>();
		if(root == null) return ans;
		traverseTree1(root, ans, 0);
		return ans;
	}
	static void traverseTree1(Node root, ArrayList<Integer> ans, int l){
		if(root == null) return;
		if(l == ans.size()) ans.add(root.data);
		traverseTree1(root.left, ans, l + 1);
		traverseTree1(root.right, ans, l + 1);
	}

	//preorder traversal
	static int max;
	public ArrayList<Integer> leftView3(Node root) {
		ArrayList<Integer> ans = new ArrayList<>();
		max = Integer.MIN_VALUE;
		if(root == null) return ans;
		traverseTree2(root, ans, 0);
		return ans;
	}
	static void traverseTree2(Node root, ArrayList<Integer> ans, int l){
		if(root == null) return;
		if(l > max) ans.add(root.data);
		max = Math.max(l, max);
		traverseTree2(root.left, ans, l + 1);
		traverseTree2(root.right, ans, l + 1);
	}
}