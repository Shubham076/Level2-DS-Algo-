/*leetcode 237
You are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes. The task is to delete the node. Pointer/ reference to head node is not given. 
Note: No head reference is given to you. It is guaranteed that the node to be deleted is not a tail node in the linked list.

*/
public class deleteWithoutHeadPointer {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    // 1 -> 2 -> 3 -> 4
    void deleteNode(Node del) {
       Node temp = del.next;
       del.data = temp.data;
       del.next = temp.next;
       temp = null;
    }
}
