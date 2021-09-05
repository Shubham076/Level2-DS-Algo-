/*
https://www.geeksforgeeks.org/sort-a-linked-list-in-wave-form/
list[0] >= list[1] <= list[2] >= …..
*/

public class waveSort {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void waveSort(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node cur = head;
        int i = 0;
        while (cur.next != null) {
            if (i % 2 == 0) {
                if (cur.data < cur.next.data) {
                    int temp = cur.next.data;
                    cur.next.data = cur.data;
                    cur.data = temp;
                }
            } else {
                if (cur.data > cur.next.data) {
                    int temp = cur.next.data;
                    cur.next.data = cur.data;
                    cur.data = temp;
                }
            }
            cur = cur.next;
            i++;
        }
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 3, 6, 5, 10, 7, 20 };
        Node dummy = new Node(-1);
        Node temp = dummy;
        for (int i : arr) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        waveSort(dummy.next);
    }
}
