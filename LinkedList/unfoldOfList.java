import java.util.Scanner;

class unfoldOfList {
	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode reverse(ListNode node) {
		ListNode prev = null;
		ListNode cur = node;
		ListNode next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	public static void unfold(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode head1 = head;
		ListNode head2 = head.next;
		ListNode fp = head1; // first pointer
		ListNode sp = head2; // second pointer

		while (sp != null && sp.next != null) {
			ListNode forw = sp.next;

			// connect the links
			fp.next = forw;
			sp.next = forw.next;

			// moving forward
			fp = fp.next;
			sp = sp.next;
		}

		head2 = reverse(head2);
		fp.next = head2;
	}

	static void printList(ListNode node) {
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

		ListNode head = dummy.next;
		unfold(head);
		printList(head);
	}
}