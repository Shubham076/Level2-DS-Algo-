/*
https://www.geeksforgeeks.org/modify-a-binary-tree-by-shifting-all-nodes-to-as-far-right-as-possible/
*/
import java.util.*;
class shiftAllTheNodesToRight {
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
	public static Node construct(Integer[] arr) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(arr[0], null, null));
		int i = 1;
		Node root = null;
		while (q.size() > 0 && i < arr.length) {
			Node rm = q.remove();
			if (root == null) {
				root = rm;
			}
			if (arr[i] != null) {
				rm.left = new Node(arr[i], null, null);
				q.add(rm.left);
			}
			i++;

			if (i >= arr.length) {
				break;
			}

			if (arr[i] != null) {
				rm.right = new Node(arr[i], null, null);
				q.add(rm.right);
			}
			i++;
		}
		return root;
	}

	public static void display(Node root) {
		if (root == null) return;
		String s = "";
		s += root.left != null ? root.left.data : "-";
		s += " <- " + root.data + " -> ";
		s += root.right != null ? root.right.data : "-";
		System.out.println(s);
		display(root.left);
		display(root.right);
	}

	public static void addChild(Node root, Queue<Node> q) {
		if (root.right != null) {
			q.add(root.right);
		}
		if (root.left != null) {
			q.add(root.left);
		}
		root.left = root.right = null;
	}

	public static Node shiftToRight(Node root) {
		Queue<Node> child = new ArrayDeque<>();
		Stack<Node> par = new Stack<>();
		par.add(root);
		addChild(root, child);

		while (child.size() > 0) {
			Stack<Node> temp = new Stack<>();
			int s = child.size();

			while (s-- > 0) {
				Node c = child.remove();
				addChild(c, child);
				temp.add(c);
				if (par.peek().right == null) {
					par.peek().right = c;
				} else {
					par.peek().left = c;
					par.pop();
				}
			}
			par = new Stack<>();
			while (temp.size() > 0) {
				par.push(temp.pop());
			}
		}
		return root;
	}
	public static void main(String[] args) {
		Integer[] arr = {1, 2, 3, 4, 5, null, 6};
		Node root = construct(arr);
		display(root);
		System.out.println("-------------");
		Node ans = shiftToRight(root);
		display(ans);
	}
}