/*
leetcode 460
using 2 hashmap
1: key vs node
2: freq vs DLL

when we are out of limit remove the node with min freq;
if multiple nodes are present at min freq lru is followed
*/

import java.util.*;
public class lfuCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        int freq = 1;
    }

    class DLL{
        Node head;
        Node tail;
        int size;
        public DLL() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        Node extract(Node n){
            Node left = n.prev;
            Node right = n.next;
    
            left.next = right;
            right.prev = left;
            n.next = null;
            n.prev = null;
            this.size--;
            return n;
        }
    
        void addBeforeTail(Node n){
            Node tailm1 = tail.prev;
    
            tailm1.next = n;
            n.next = tail;
            tail.prev = n;
            n.prev = tailm1;
            this.size++;
        }

        Node removeheadNext(){
            if(size > 0)
                return extract(head.next);
            else return null;
        }
    }

    HashMap<Integer, Node> map;
    HashMap<Integer, DLL> freqMap;
    int capacity;
    int min;

    lfuCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }

    void increment(Node n){
        DLL olist = freqMap.get(n.freq);
        olist.extract(n);
        //if this frequency was the min frequency and no node is having this freq anymore
        if(n.freq == min && olist.size == 0) min += 1;
        n.freq++;
        DLL nlist = freqMap.getOrDefault(n.freq, new DLL());
        nlist.addBeforeTail(n);
        freqMap.put(n.freq, nlist);
    }
    
    public int get(int key) {
        Node temp = map.get(key);
        if(temp != null){
            increment(temp);
            return temp.val;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        Node temp = map.get(key);
        if(temp != null){
            temp.val = value;
            increment(temp);
        }
        else{
            if(map.size() == capacity){
                DLL list = freqMap.get(min);
                Node rm = list.removeheadNext();
                map.remove(rm.key);
            }
            Node n = new Node();
            n.key = key;
            n.val = value;
            min = 1;
            DLL list = freqMap.getOrDefault(n.freq, new DLL());
            list.addBeforeTail(n);
            map.put(key, n);
            freqMap.put(min, list);
        }
    }
}
