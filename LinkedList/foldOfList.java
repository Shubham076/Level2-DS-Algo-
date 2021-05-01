//leetcode 143
class foldOfList{
	public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   	}

	public ListNode mid(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode reverse(ListNode head){
		ListNode prev = null;
		ListNode cur = head;
		while(cur != null){
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	public void reorderList(ListNode head) {
	 	 ListNode mid = mid(head);
	 	 ListNode nh = mid.next;
	 	 mid.next = null;
	 	 nh = reverse(nh);   //reverse by pointer ;
	 	 ListNode i = head;
	 	 ListNode j = nh;
	 	 ListNode ni = null;
	 	 ListNode nj = null;
	 	 while(i != null && j != null){
	 	 	ni = i.next;
	 	 	nj = j.next;

	 	 	i.next = j;
	 	 	j.next = ni;

	 	 	i = ni;
	 	 	j = nj;
	 	 }
	}
}