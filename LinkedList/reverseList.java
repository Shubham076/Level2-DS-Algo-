class reverseList{
	public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   	}

	static ListNode th;
	static ListNode tt;
	public void addFirst(ListNode n){
		if(th == null){
			th = tt = n;
		}
		else{
			n.next = th;
			th = n;
		}
	}
	public ListNode reverseList(ListNode head) {
     	   th = null;
     	   tt = null;
     	   ListNode cur = head;
     	   while(cur != null){
     	   		ListNode next = cur.next;
     	   		cur.next = null;
     	   		addFirst(cur);
     	   		cur = next;
     	   }
     	   return th;
    }
}