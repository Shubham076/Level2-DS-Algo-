//leetcode 92 O(N)
import java.util.*;
class reverseInRange{
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int data){
			this.val = data;
			this.next = null;
		}
		ListNode(int data, ListNode next){
			this.val = data;
			this.next = next;
		}
	}

// 1 -> 2 -> 3 -> 4  left = 1 right = 2
	public static void print(ListNode n){
		for(ListNode temp = n; temp != null; temp = temp.next){
			System.out.print(temp.val + " ");
		}
		System.out.println();
	}

	public static ListNode reverseBetween(ListNode head, int left, int right) {
     	if(head == null || head.next == null) return head;
     	left--; //making zero based
     	right--; //making zero based
		ListNode cur1 = head;
		ListNode prev1 = null;
		for(int i = 0; i < left; i++){
			prev1 = cur1;
			cur1 = cur1.next;
		}

		ListNode cur2 = cur1;
		ListNode prev2 = prev1;

		//reverse the list from left to right
		for(int i = left; i <= right; i++){
			ListNode next = cur2.next;
			cur2.next = prev2;
			prev2 = cur2;
			cur2 = next;
		}

		if(prev1 != null)
			prev1.next = prev2;
		cur1.next = cur2;
		/*
			prev1 is null only when left = 0;
			so after reversing the prev2 becomes new head;
		*/   
		return prev1 != null ? head : prev2;
    }
	public static void main(String[] args) {
		ListNode dummy = new ListNode(-1);
		ListNode temp = dummy;
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for(int i = 0; i < n; i++){
			temp.next = new ListNode(scn.nextInt());
			temp = temp.next;
		}
		int left = scn.nextInt();
		int right = scn.nextInt();
		ListNode ans = reverseBetween(dummy.next, left, right);
		print(ans);
	}
}
