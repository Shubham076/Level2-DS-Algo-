import java.util.*;
class segregateLinkedList {
	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static  ListNode segregateEvenOdd(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode dummyEven = new ListNode(-1);  //even head
 		ListNode dummyOdd = new ListNode(-1);  // odd head;
		ListNode et = dummyEven; //even tail
		ListNode ot = dummyOdd; // odd tail

		ListNode cur = head;
		while(cur != null){
			if(cur.val % 2 == 0){
				et.next = cur;
				et = et.next;
			}
			else{
				ot.next = cur;
				ot = ot.next;
			}

			cur = cur.next;
		}

		ot.next = dummyEven.next;
		et.next = null;

		return dummyOdd.next;
	}

	public static void printList(ListNode node) {
	        while (node != null) {
	            System.out.print(node.val + " ");
	            node = node.next;
	        }
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		while (n-- > 0) {
			prev.next = new ListNode(scn.nextInt());
			prev = prev.next;
		}

		ListNode head = segregateEvenOdd(dummy.next);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}