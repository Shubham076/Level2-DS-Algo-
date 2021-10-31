import java.util.*;
public class firstNonRepeatingCharacterInAStream {
    static class Node {
        int c;
        Node next;
        Node prev;
        Node() {

        }

        Node(char c) {
            this.c = c;
        }
    }
    static class DLL {
        Node head;
        Node tail;
        int size;
        DLL() {
            head = new Node('#');
            tail = new Node('-');
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void add(Node n) {
            Node tm1 = tail.prev;
            tm1.next = n;
            n.next = tail;
            tail.prev = n;
            n.prev = tm1;
            size++;
        }

        void remove(Node n) {
            Node left = n.prev;
            Node right = n.next;
            left.next = right;
            right.prev = left;
            n.next = n.prev = null;
            size--;
        }

        Node head() {
            if(size > 0)
                return head.next;
            else return null;
        }

        void display(){
           for(Node temp = head; temp != null; temp = temp.next){
                System.out.print((char)temp.c + " ");
            }
            System.out.println();
    }
    }

    
    static void solve2(String s) {
        boolean[] rep = new boolean[255]; // rep[i] = true if character repeated twice
        Node[] add = new Node[255];      // stores the address of each node
        DLL l = new DLL();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!rep[c]) {

                //character is seen for the first time
                if (add[c] == null) {
                    add[c] = new Node(c);
                    l.add(add[c]);
                } 
                else {
                    //character is seen for the second time
                    l.remove(add[c]);
                    add[c] = null;
                    rep[c] = true;
                }
            }
            Node n = l.head();
            if(n == null)
                System.out.print(" - ");
            else System.out.print((char)n.c + " ");
        }
    }

    static void solve1(String s) {
        int[] arr = new int[26];
        StringBuilder ans = new StringBuilder("");
        Queue<Character> q = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
            q.add(c);

            //at max q can grow upto 255 characters which is O(1) but still computationally expensive
            while (q.size() > 0) {
                if (arr[q.peek() - 'a'] > 1) {
                    q.remove();
                } else {
                    ans.append(q.peek());
                    break;
                }
            }
            if (q.size() == 0)
                ans.append('#');
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        String s = "abac";
        solve1(s);
        solve2(s);
    }
}
