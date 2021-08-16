//sort a linked list that is already sorted according to absolute value
//for eg = 1 -> -2 -> 2 -> 4 -> -5 if we say carefully all the negative numbers are sorted in reverse order
//we simply remove a negative number and add it to the first of linked list 
class sortAlreadySortedLinkedList{
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}

	public static void sort(Node head){
		Node prev = head;
		Node cur = head.next;
		while(cur != null){
			if(cur.data < prev.data){
				prev.next = cur.next;

				//adding to the first
				cur.next = head;
				head = cur;

				cur = prev;
			}

			prev = cur;
			cur = cur.next;
		}

		for(Node temp = head; temp != null; temp = temp.next){
			System.out.print(temp.data + " ");
		}
	}

	public static void main(String[] args){
		int[] arr = {-2, 2, 4, -5, -6};
		Node dummy = new Node(-1);
		Node temp = dummy;
		for(int i: arr){
			temp.next = new Node(i);
			temp = temp.next;
		}
		sort(dummy.next);
	}
}