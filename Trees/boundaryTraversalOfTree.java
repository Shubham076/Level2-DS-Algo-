//Time complexity o(N)
import java.util.*;
class boundaryTraversalOfTree {
	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return this.data + "";
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

	public static void printLeftBoundary(Node root){
		if(root == null) return;
		if(root.left != null){
			System.out.print(root.data +  " ");
			printLeftBoundary(root.left);
		}
		else if(root.right != null){
			System.out.print(root.data + " ");
			printLeftBoundary(root.right);
		}
	}

	public static void printRightBoundary(Node root){
		if(root == null) return;
		if(root.right != null){
			printRightBoundary(root.right);
			System.out.print(root.data +  " ");
		}
		else if(root.left != null){
			printRightBoundary(root.left);
			System.out.print(root.data + " ");
		}
	}

	public static void printLeaf(Node root){
		if(root == null) return;
		if(root.left == null && root.right == null){
			System.out.print(root.data + " ");
		}
		printLeaf(root.left);
		printLeaf(root.right);
	}

	//anticlockwise
	public static void boundaryTraversal(Node root) {
		System.out.print(root.data + " ");
		printLeftBoundary(root.left);
		printLeaf(root);
		printRightBoundary(root.right);
	}
	public static void display(Node root){
        if(root == null) return;
        String str = "";
        str += root.left == null ? "." : root.left.data;
        str += " => " +  root.data + " <= ";
        str += root.right == null ? "." : root.right.data;
        System.out.println(str);

        display(root.left);
        display(root.right);
    }

	public static void main(String[] args) {
		Integer[] arr = {1, 2, 3, 4, 5};
		Node root = constructTree(arr);
		// display(root);
		boundaryTraversal(root);
		System.out.println();
	}
}