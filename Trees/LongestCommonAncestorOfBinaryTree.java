//https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
import java.util.*;
class LongestCommonAncestorOfBinaryTree {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	/*(N)
	lca is the first node that is common in node to root path
	intuition we will ask from both left and right subtree whether they have any node n1 and n2
	if yes we return node
	4 cases
	 left == null && right == null when nodes doesnt exist in the tree
	 left != null && right != null when nodes exist and root is the lca because root is the first common in node 2 root path
	 left != null && right == null when both nodes found in the left subtree so lca is the left node 
	 left == null && right != null when both nodes found in the right subtree so lca is the right node 
	else we return null
	*/
	Node lca(Node root, int n1, int n2) {
		if(root == null) return null;

		if(root.data == n1 || root.data == n2){
			return root;
		}

		Node left = lca(root.left, n1, n2);
		Node right = lca(root.right, n1, n2);

		if(left == null && right == null){
			return null;
		}
		else if(left != null && right == null){
			return left;
		}
		else if(left == null && right != null){
			return right;
		}
		else{
			return root;
		}
	}
}