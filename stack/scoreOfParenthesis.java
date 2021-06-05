import java.util.*;
public class scoreOfParenthesis {
    public static int scoreofParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        // ( -> 0
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(0);
            }
            else {
                if(st.peek() == 0){
                    // means seq = ()
                    st.pop();
                    st.push(1);
                }
                else{  //means seq = (A) or (A B)  so we pop val from the stack until we get a opening bracket
                    int val = 0;
                    while(st.peek() != 0){
                        val += st.pop();
                    }
                    st.pop();
                    st.push(2 * val);
                }
            }
        }

        //for test case ()()
        // after exiting the loop the stack contains 1 , 1
        int val = 0;
        while(st.size() > 0){
            val += st.pop();
        }
        return val;
    }
    public static void main(String[] args){
        String s = "(()())()(())";
        System.out.println(scoreofParentheses(s));
    }
}
