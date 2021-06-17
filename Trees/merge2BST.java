// https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1
import java.util.*;
class merge2BST {
	static class Node {
		int data;
		Node left, right;

		public Node(int d) {
			data = d;
			left = right = null;
		}
	}
		static class ListNode{
			int val;
			ListNode next;
			ListNode(int v){
				this.val = v;
				next = null;
			}
		}
		static ListNode temp;
		static ListNode flatTree(Node root){
			ListNode n = new ListNode(-1);
			temp = n;
			getInOrder(root);
			return n.next;
		}
		static void getInOrder(Node root){
			if(root == null) return;
			getInOrder(root.left);
			temp.next = new ListNode(root.data);
			temp = temp.next;
			getInOrder(root.right);
		}

		public static ListNode merge2SortedList(ListNode l1, ListNode l2){
			if(l1 == null || l2 == null) return l1 != null ? l1 : l2;
		       	ListNode one = l1;
		       	ListNode two = l2;
		       	ListNode dummy = new ListNode(-1);
		       	ListNode temp = dummy;
		       	while(one != null && two != null){
		       		if(one.val <= two.val){
		       			temp.next = one;
		       			temp = temp.next;
		       			one = one.next;
		       		}
		       		else{
		       			temp.next = two;
		       			temp = temp.next;
		       			two = two.next;
		       		}
		       	}

		       	if(one != null){
		       		temp.next = one;
		       	}
		       	else{
		       		temp.next = two;
		       	}
		       	return dummy.next;
		}

		//O(N + M)
		public List<Integer> merge(Node root1, Node root2) {
			ListNode l1 = flatTree(root1);
			ListNode l2 = flatTree(root2);
			ListNode merge = merge2SortedList(l1, l2);
			List<Integer> ans = new ArrayList<>();
			temp = merge;
			while(temp != null){
				ans.add(temp.val);
				temp = temp.next;
			}
			return ans;
		}
}