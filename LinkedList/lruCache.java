/*
to handle the edge cases we made 2 node head and tail already
need 2 functions

1: add node before tail
                        (tail - 1)
head ------> n1 --------> n2 -------> tail
     <------    <--------    <-------

n = new Node
n2.next = n
n.next = tail
tail.prev = n;
n.prev = n2;

2: extract node
            (left)       (n)         (right)
head ------> n1 --------> n2 -------> tail
     <------    <--------    <-------
left.next = left.next.next; 
right.prev = right.prev.prev;
n.next = null;
n.prev = null; 

*/

//leetcode 146
import java.util.*;
class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
    }
    
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity = 0;
    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }
    void extract(Node n){
        Node left = n.prev;
        Node right = n.next;

        left.next = right;
        right.prev = left;
        n.next = null;
        n.prev = null;
    }

    void addBeforeTail(Node n){
        Node tailm1 = tail.prev;

        tailm1.next = n;
        n.next = tail;
        tail.prev = n;
        n.prev = tailm1;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            extract(temp);
            addBeforeTail(temp);
            return temp.val;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            extract(temp);
            temp.val = value;
            addBeforeTail(temp);
        }
        else{
            if(map.size() == capacity){
                Node next = head.next;
                extract(next);
                map.remove(next.key);
            }
            Node n = new Node();
            n.key = key;
            n.val = value;
            map.put(key, n);
            addBeforeTail(n);
        }
    }
}
