///leetcode 946
import java.util.*;
public class validStackSequence {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int j = 0;
        for(int i : pushed){
            s.push(i);
            while(s.size() > 0 && s.peek() == popped[j]){
                s.pop();
                j++;
            }
        }

        return j == popped.length;
    }
    public static void main(String[] args){
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, poped));
    }
}
