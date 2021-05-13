//leetcode 160
//using differnce method
import java.util.*;
public class intersectionOfLinkedList {
    static Scanner scn = new Scanner(System.in);
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static int size(ListNode head){
        int s = 0;
        for(ListNode temp = head; temp != null; temp = temp.next){
            s++;
        }
        return s;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int s1 = size(headA);
        int s2 = size(headB);
        int k = Math.abs(s1 - s2);

        if(s1 > s2){
            for(int i = 0; i < k; i++){
                headA = headA.next;
            }
        }
        else{
            for(int i = 0; i < k; i++){
                headB = headB.next;
            }
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());
        int idx = scn.nextInt();
        ListNode head2 = makeList(scn.nextInt());

        if (idx >= 0) {
            ListNode curr = head1;
            while (idx-- > 0)
                curr = curr.next;

            ListNode prev = head2;
            while (prev.next != null)
                prev = prev.next;

            prev.next = curr;
        }

        ListNode ans = getIntersectionNode(head1, head2);
        System.out.println(ans != null ? ans.val : -1);
    }
}
