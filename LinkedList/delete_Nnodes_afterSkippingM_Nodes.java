/*
https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1/#
*/
class delete_Nnodes_afterSkippingM_Nodes{
	static class Node{
		int data;
		Node next;
	}
	static void linkdelete(Node head, int m, int n){
        Node temp = head;
        while(temp != null){
            for(int i = 1; i < m && temp != null; i++){
                temp = temp.next;
            }
            if(temp == null) return;
            for(int i = 0; i < n && temp != null && temp.next != null; i++){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }   
    }
}