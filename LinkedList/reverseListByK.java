import java.util.*;
class reverseListByK{
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

   static ListNode th; //temp head
   static ListNode tt; // temp tail;

   public int size(ListNode head){
   		int s = 0;
   		for(ListNode temp = head; temp != null; temp = temp.next){
   			s++;
   		}
   		return s;
   }

   public void addFirst(ListNode n){
   		if(th == null){
   			th = n;
   			tt = n;
   		}
   		else{
   			n.next = th;
   			th = n;
   		}
   }
 
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null || k == 0) return head;
        th = null;
        tt = null;
        ListNode oh = null; // original head
        ListNode ot = null; // original tail
        int size = size(head);
        ListNode cur = head;
        while(size >= k){
        	for(int i = 0; i < k; i++){
        		ListNode next = cur.next;
        		cur.next = null;
        		addFirst(cur);
        		cur = next;
        	}
        	if(oh == null){
	        	oh = th;
	        	ot = tt;
        	}
        	else{
        		ot.next = th;
        		ot = tt;
        	}

        	th = null;
        	tt = null;
        	size -= k;
        }
        ot.next = cur;
        return oh;
    }
}