class middleOfLinkedList{
	public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   	}

   	public ListNode middleNode(ListNode head) {
   	 	ListNode slow = head;
   	 	ListNode fast = head;
   	 	while(fast.next != null && fast.next.next != null){
   	 		slow = slow.next;
   	 		fast = fast.next.next;
   	 	} 
   	 	return slow;  
   	}

      //note in case of even linked list if we have 2 mid nodes
      //above solution return first node
      //for returning the secong node just change the condition to (fast.next != null && fast != null)
}