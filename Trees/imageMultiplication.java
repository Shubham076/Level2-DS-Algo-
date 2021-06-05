import java.util.*;
class imageMultiplication {
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
	static long sum;
	public static void multiply(Node left, Node right){
		if(left == null || right == null){
			return;
	        // code here
		}

		sum += (left.data * right.data);
		multiply(left.left, right.right);
		multiply(left.right, right.left);
	}
	public static long imgMultiply(Node root){
        sum = 0;
        sum += root.data * root.data;
        multiply(root.left, root.right);
        return sum;
    }
	public static void main(String[] args) {
		Integer[] tree = {1, 3, 2, 7, 6, 5, 4, 11 , 10, null, 15, 9, 8, null, 12};
		Node root = constructTree(tree);
		sum = 0;
		sum += root.data;
		System.out.println(imgMultiply(root));
	}
}