/*leetcode 402
*/
import java.util.*;
class removeKDigits{
	public String removeKdigits(String s, int k) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            while(st.size() > 0 && st.peek() > c && k > 0){
                st.pop();
                k--;
            }
            st.push(c);
        }
        
         while(k > 0){
            st.pop();
            k--;            
        }
        
        char[] ans = new char[st.size()];
        int i = ans.length - 1;
        while(i >= 0){
            ans[i--] = st.pop();
        }
        String res = "";
        for(char c: ans){
            if(res.length() == 0 && c == '0'){
                continue;
            }
            else{
                res += c;
            }
        }
        return res.length() != 0 ? res : "0" ;
    }
}