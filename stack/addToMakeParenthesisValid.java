//leetcode 921
// O(N)
import java.util.*;
public class addToMakeParenthesisValid {
    public static int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                st.push(c);
            }
            else{
                if(st.size() > 0 && st.peek() == '('){
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }
        }
        return st.size();
    }
    public static void main(String[] args){
        String s = "))";
        System.out.println(minAddToMakeValid(s));
    }    
}
