//leetcode 24
/*
1 -> 2 -> 3 -> 4   
2 -> 1 -> 4 -> 3
*/
static class swapPairs{
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode third = second.next;
        second.next = head;
        head.next = swapPairs(third);
        return second;
    }
}