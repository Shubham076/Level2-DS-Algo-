class oddEvenList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode eh = new ListNode(-1); // even head
		ListNode oh = new ListNode(-1); // odd head;
		ListNode et = eh; // even tail
		ListNode ot = oh; // odd tail
		boolean odd = true;
		ListNode cur = head;
		while (cur != null) {

			if (!odd) {
				et.next = cur;
				et = et.next;
				odd = !odd;
			} else {
				ot.next = cur;
				ot = ot.next;
				odd = !odd;
			}
			cur = cur.next;
		}

		ot.next = eh.next;

	//now to remove the cycle
		et.next = null;

		return oh.next;
	}
}