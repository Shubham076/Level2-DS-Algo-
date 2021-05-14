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
}