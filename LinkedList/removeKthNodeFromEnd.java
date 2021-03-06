public class removeKthNodeFromEnd {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i = 0; i < n; i++)   {
            fast = fast.next;
        }

        //means we have to remove the starting node
        if(fast == null) return head.next;

        //Move fast to the end, maintaining the gap
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return head;
    }    
}
