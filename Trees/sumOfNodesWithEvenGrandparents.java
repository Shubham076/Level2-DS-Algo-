/*
leetcode 1315
Given a Binary Tree, calculate the sum of nodes with even valued Grandparents.
*/
import java.util.*;
class sumOfNodesWithEvenGrandparents {
	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	public static Node constructTree(Integer[] arr) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(arr[0], null, null));
		Node root = null;
		int i = 1;
		while (q.size() > 0 && i < arr.length) {
			Node rp = q.remove();
			if (root == null) {
				root = rp;
			}

			//adding the left child
			if (arr[i] != null) {
				rp.left = new Node(arr[i], null, null);
				q.add(rp.left);
			}
			i++;

			if (i >= arr.length) break;

			//adding the right child
			if (arr[i] != null) {
				rp.right = new Node(arr[i], null, null);
				q.add(rp.right);
			}
			i++;
		}
		return root;
	}
	static int sum;
	public static void solve(Node root, Node p, Node gp) {
		if (root == null) {
			return;
		}

		if (gp != null && gp.data % 2 == 0) {
			sum += root.data;
		}

		solve(root.left, root, p);
		solve(root.right, root, p);
	}
	public static void main(String[] args) {
		Integer[] arr = {50, null, 54, 98, 6, null, null, null, 34};
		Node root = constructTree(arr);
		solve(root, null, null);
		System.out.println(sum);
	}
}