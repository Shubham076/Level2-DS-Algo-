class rotateList{
	public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode rotateRight(ListNode head, int k) {
    	if(head == null || head.next == null || k == 0) return head;
    	int s = 0;
    	ListNode temp;
    	for(temp = head; temp.next != null; temp = temp.next){
    		s++;
    	}
    	temp.next = head;
    	s++;
       	k = k % s;
        if(k < 0){
        	k = k + s;
        }
        temp = head;
        int x = s - k;  //list remaining to left of k
        for(int i = 0; i < x - 1; i++){
        	temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}