//leetcode 82
class removeDuplicates2{
	public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode dummy = new ListNode(-1);
    	ListNode temp = dummy;
    	temp.next = head;  //potential unique node
    	ListNode cur = head.next;
    	while(cur != null){
    		boolean running = false;

    		while(cur != null && temp.next.val == cur.val){
    			cur = cur.next;
    			running = true;
    		}

    		//if the above loop runs means the next of temp is not a unique element
    		//so change our potential unique to cur;

    		if(running) temp.next = cur;
    		else temp = temp.next;

    		if(cur != null) cur = cur.next;
    	}
    	return dummy.next;	
    }
}