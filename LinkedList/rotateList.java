//1 -> 2 -> 3 -> 4 -> 5  => 4 -> 5 -> 1 -> 2 -> 3

class rotateList{
	static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode rotateRight(ListNode head, int k) {
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
            System.out.println(i);
        	temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
    public static void main(String[] args){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        for(int i = 1; i <= 5; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode ans = rotateRight(dummy.next, 2);
        temp = ans;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}