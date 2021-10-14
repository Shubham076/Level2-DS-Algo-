/*
input = > m-->y--> --->n--->a--->m--->e --->i--->s  --->r-->a-->h--->u--->l
output = y--->m--> --->e--->m--->a--->n --->s--->i  --->l-->u--->h--->a--->r `
*/

public class reverseWords {
    static class Node{
        char c;
        Node next;
        Node(char c){
            this.c = c;
            next = null;
        }
    }

    public static void print(Node head){
        for(Node temp = head; temp != null; temp = temp.next){
            System.out.print(temp.c);
        }
        System.out.println();
    }

    public static Node solve(Node head){
        if(head == null || head.next == null) return head;
        Node prev = null;
        Node cur = head;
        Node next = null;
        while(cur != null && cur.c != ' '){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = cur;
        if(cur != null){
            cur.next = solve(cur.next);
        }
        return prev;
    }
    public static void main(String[] args){
        char[] arr = {'m', 'y',' ', 'n', 'a', 'm', 'e', ' ', 'i', 's', ' ','a',' ', 'r', 'a', 'h', 'u', 'l'};
        Node dummy = new Node('#');
        Node temp = dummy;
        for(char c: arr){
            temp.next = new Node(c);
            temp = temp.next;
        }
        print(dummy.next);
        Node ans = solve(dummy.next);
        print(ans);
    }
}
