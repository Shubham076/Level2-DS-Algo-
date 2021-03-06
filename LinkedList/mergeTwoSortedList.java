import java.util.Scanner;
class mergeTwoSortedList{
	public static Scanner scn = new Scanner(System.in);

	    public static class ListNode {
	        int val = 0;
	        ListNode next = null;

	        ListNode(int val) {
	            this.val = val;
	        }
	    }

	    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	       	if(l1 == null || l2 == null) return l1 != null ? l1 : l2;
	       	ListNode one = l1;
	       	ListNode two = l2;
	       	ListNode dummy = new ListNode(-1);
	       	ListNode temp = dummy;
	       	while(one != null && two != null){
	       		if(one.val <= two.val){
	       			temp.next = one;
	       			temp = temp.next;
	       			one = one.next;
	       		}
	       		else{
	       			temp.next = two;
	       			temp = temp.next;
	       			two = two.next;
	       		}
	       	}

	       	if(one != null){
	       		temp.next = one;
	       	}
	       	else{
	       		temp.next = two;
	       	}
	       	return dummy.next;
	    }

	    public static void printList(ListNode node) {
	        while (node != null) {
	            System.out.print(node.val + " ");
	            node = node.next;
	        }
	    }

	    public static ListNode createList(int n) {
	        ListNode dummy = new ListNode(-1);
	        ListNode prev = dummy;
	        while (n-- > 0) {
	            prev.next = new ListNode(scn.nextInt());
	            prev = prev.next;
	        }

	        return dummy.next;
	    }

	    public static void main(String[] args) {
	        int n = scn.nextInt();
	        ListNode h1 = createList(n);
	        int m = scn.nextInt();
	        ListNode h2 = createList(m);


	        ListNode head = mergeTwoLists(h1, h2);
	        printList(head);
	    }
}