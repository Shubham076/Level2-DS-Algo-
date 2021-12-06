/* 
leetcode 86
Given the head of a linked list and a value x, partition it such that all nodes less than x come
before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
*/
public class partitionList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode smallhead = new ListNode(-1);   
        ListNode bigHead = new ListNode(-1);
        ListNode stail = smallhead, btail = bigHead;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                stail.next = new ListNode(cur.val);
                stail = stail.next;
            }
            else{
                btail.next = new ListNode(cur.val);
                btail = btail.next;
            }
            cur = cur.next;
        }
        stail.next = bigHead.next;
        btail.next = null;
        return smallhead.next;
    }
}
