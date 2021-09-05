import java.util.*;
public class copyWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    //method1 hashing O(N)
    public Node copyRandomList1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        
        for(Node temp = head; temp != null; temp = temp.next){
            Node n = new Node(temp.val);
            map.put(temp, n);
        }
        
        for(Node temp = head; temp != null; temp = temp.next){
            Node n = map.get(temp);
            n.next = map.get(temp.next);
            n.random = map.get(temp.random);
        }
        return map.get(head);
    }

    public Node copyRandomList2(Node head){
        //step one insert copy of cur nodes next to cur next
        Node cur = head;
        Node forw = null;
        while(cur != null){
            forw = cur.next;
            Node n = new Node(cur.val);
            cur.next = n;
            n.next = forw;

            //move the current to forw
            cur = forw;
        }

        //step 2 connect the random poiners
        cur = head;
        while(cur != null){
            Node random = cur.random;
            if(random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }


        //step 3 connecting the next pointer
        Node dummy = new Node(-1);
        Node prev = dummy;
        cur = head;
        while(cur != null){
            prev.next = cur.next;
            cur.next = cur.next.next;

            prev = prev.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
