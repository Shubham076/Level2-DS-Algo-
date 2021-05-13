//assuming that list l1 is always greater than list
import java.util.*;
public class subtractTwolist {
     static Scanner scn = new Scanner(System.in);
        
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    public static Node reverse(Node head){
        if(head == null || head.next == null) return head;
        Node prev = null;
        Node cur = head;
        Node next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    static Node subtractTwoNumbers(Node l1, Node l2){
        if(l2 == null) return l1;
        if(l1 == null){
            l2.data = -l2.data;
            return l2;
        }

        l1 = reverse(l1);
        l2 = reverse(l2);
        Node head = new Node(-1);
        Node temp = head;
        int carry = 0;
        while(l1 != null){
            int v1 = l1.data + carry;
            int v2 = l2 == null ? 0 : l2.data;
            int diff = 0;
            if(v1 >= v2){
                diff = v1 - v2;
                carry = 0;
            }
            else{
                carry = -1;
                diff = v1 + 10 - v2;
            }
            Node cur = new Node(diff);
            temp.next = cur;
            temp = temp.next;

            //move the pointers
            l1 =  l1.next;
            if(l2 != null) l2 =  l2.next;
        }
        head = reverse(head.next);

        //removing the leading zeros
        while(head.next != null){
            if(head.data == 0)
                head = head.next;
            else break;
        }
        return head;
    }
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static Node makeList(int n) {
        Node dummy = new Node(-1);
        Node prev = dummy;
        while (n-- > 0) {
            prev.next = new Node(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        Node head1 = makeList(scn.nextInt());
        Node head2 = makeList(scn.nextInt());

        Node ans = subtractTwoNumbers(head1, head2);
        printList(ans);
    }
}
