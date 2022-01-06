/*
https://www.geeksforgeeks.org/print-nodes-dont-sibling-binary-tree/
a sibling is a node that has same parent. In a Binary Tree,
there can be at most one sibling). Root should not be printed as root cannot have a sibling.
*/
import java.util.*;
class printNodesDontHaveSiblings{
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	static Node construct(Integer[] arr){
		Node root = null;
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(arr[0]));
		int i = 1;
		while(q.size() > 0 && i < arr.length){
			Node rm = q.remove();
			if(root == null){
				root = rm;
			}
			if(arr[i] != null){
				rm.left = new Node(arr[i]);
				q.add(rm.left);
			}
			i++;

			if(i >= arr.length){
				break;
			}
			if(arr[i] != null){
				rm.right = new Node(arr[i]);
				q.add(rm.right);
			}
			i++;
		}
		return root;
	}

	static void singleSiblings(Node root){
		if(root == null) return;
		if(root.left != null && root.right != null){
			singleSiblings(root.left);
			singleSiblings(root.right);
		}
		else if(root.left != null){
			System.out.print(root.left.data + " ");
			singleSiblings(root.left);
		}
		else if(root.right != null){
			System.out.print(root.right.data + " ");
			singleSiblings(root.right);
		}
	}
	public static void main(String[] args){
		Integer[] arr =  {37, 20, null, 113, null};
		Node root = construct(arr);
		singleSiblings(root);
	}
}