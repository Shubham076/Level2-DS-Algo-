import java.util.*;
class removeDuplicatesFromUnSortedLinkedList {
	class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}

	public Node removeDuplicates(Node head) {
		HashSet<Integer> set = new HashSet<>();
		Node dummy = new Node(-1);
		Node temp = dummy;
		for(Node cur = head; cur != null; cur = cur.next){
			if(set.contains(cur.data)){
				continue;
			}
			else{
				temp.next = new Node(cur.data);
				temp = temp.next;
				set.add(cur.data);
			}
		}
		return dummy.next;
	}
}