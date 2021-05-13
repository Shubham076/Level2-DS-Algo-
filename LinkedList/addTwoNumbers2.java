//leetcode 445
public class addTwoNumbers2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        int carry = 0;
        while(l1 != null || l2 != null || carry > 0){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;
            ListNode cur = new ListNode(sum % 10);
            temp.next = cur;
            temp = temp.next;
            carry = sum / 10;

            //move the pointers
            if(l1 != null) l1 =  l1.next;
            if(l2 != null) l2 =  l2.next;
        }
        head = reverse(head.next);
        return head;
    }
}
