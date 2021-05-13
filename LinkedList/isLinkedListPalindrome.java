class isLinkedListPalindrome{
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 }
	public ListNode mid(ListNode node){
		ListNode slow = node;
		ListNode fast = node;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode reverse(ListNode node){
		ListNode prev = null;
		ListNode cur = node;
		while(cur != null){
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		} 
		return prev;
	}
	public boolean isPalindrome(ListNode head) {
        ListNode mid = mid(head);
        ListNode nh = mid.next;
        mid.next = null;
        nh = reverse(nh);  //reversed by pointer iterative
        boolean res = true;
        ListNode i = head;
        ListNode j = nh;
        while(i != null && j != null){
        	if(i.val != j.val){
        		res = false;
        		break;
        	}
        	i = i.next;
        	j = j.next;
        }

        nh = reverse(nh);
        mid.next = nh;
        return res;
    }
}