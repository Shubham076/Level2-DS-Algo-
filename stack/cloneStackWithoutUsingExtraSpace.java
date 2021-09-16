import java.util.*;
public class cloneStackWithoutUsingExtraSpace {
    //O(n * n) + O(N) space iterative
    public static void reverseStack(Stack<Integer> s, Stack<Integer> d){
        int cnt = 0;
        while(cnt != s.size()){
            int top = s.pop();
            while(cnt != s.size()){
                d.push(s.pop());
            }
            s.push(top);
            while(d.size() != 0){
                s.push(d.pop());
            }
            cnt++;
        }
    }

    //O(N * N) recusive
    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int temp = s.pop();
        reverse(s);
        addAtLast(s, temp);
    }

    public static void addAtLast(Stack<Integer> s , int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        addAtLast(s , data);
        s.push(top);
    }
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        Stack<Integer> cs = new Stack<>();
        for(int i = 0; i < 5; i++){
            s.push(i + 1);
        } 
        System.out.println(s);
        reverseStack(s, cs);
        System.out.println(s);
    }
}
