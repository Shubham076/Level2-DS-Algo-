//https://www.geeksforgeeks.org/convert-bst-to-max-heap/
import java.util.*;
class convertBstToMaxHeap{
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	static Node construct(int[] arr, int lo, int hi){
		if(lo == hi){
			return new Node(arr[lo]);
		}
		int mid = lo + (hi - lo) / 2;
		Node n = new Node(arr[mid]);
		n.left = construct(arr, lo, mid - 1);
		n.right = construct(arr, mid + 1, hi);
		return n;
	}
	static void inOrder(Node n){
		if(n == null) return;
		inOrder(n.left);
		list.add(n.data);
		inOrder(n.right);
	}
	static void levelOrder(Node n){
		Queue<Node> q = new ArrayDeque<>();
		q.add(n);
		while(q.size() > 0){
			int s = q.size();
			while(s-- > 0){
				Node rm = q.remove();
				System.out.print(rm.data + " ");

				if(rm.left != null){
					q.add(rm.left);
				}
				if(rm.right != null){
					q.add(rm.right);
				}
			}
			System.out.println();
		}
	}

	static void convertToMaxHeap(Node root){
		if(root == null) return;
		convertToMaxHeap(root.left);
		convertToMaxHeap(root.right);
		root.data = list.get(i++);
	}

	static void convertToMinHeap(Node root){
		root.data = list.get(i++);
		if(root == null) return;
		convertToMaxHeap(root.left);
		convertToMaxHeap(root.right);
	}
	static ArrayList<Integer> list;
	static int i;
	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		list = new ArrayList<>();
		i = 0;
		Node root = construct(arr, 0, arr.length - 1);
		inOrder(root);
		// System.out.println(list);
		convertToMaxHeap(root);
		levelOrder(root);
	}
}