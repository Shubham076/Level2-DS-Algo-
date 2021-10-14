//geeksforgeeks.org/in-place-conversion-of-sorted-dll-to-balanced-bst/
import java.util.*;
class sortedDLLToBSt {
	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	static ListNode temp;
	static TreeNode mid(TreeNode head){
		if(head == null || head.right == null) return head;
		TreeNode slow = head;
		TreeNode fast = head;
		while(fast.right != null && fast.right.right != null){
			slow = slow.right;
			fast = fast.right.right;
		}
		return slow;
	}
	public TreeNode sortedListToBST(TreeNode head) {
     	return construct(head);   
    }
//O(N)
    public static TreeNode construct(TreeNode head){
    	if(head == null || head.right == null) return head;

    	TreeNode mid = mid(head);
    	TreeNode prev = mid.left;
    	TreeNode forw = mid.right;

    	forw.left = mid.right = mid.left = null;

    	//edge case when size of the list is 2
    	if(prev != null)
    		prev.right = null;

    	//edge case when size of the list is 2
    	TreeNode lefthead = prev != null ? head : null;
    	TreeNode righthead = forw;

    	mid.left = construct(lefthead);
    	mid.right = construct(righthead);

    	return mid;
    }	
} 