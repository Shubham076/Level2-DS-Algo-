import java.util.*;
public class decodeString {
    public static void solve(String s){
        Stack<String> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '['){
                st.push(c + "");
            }
            else if(c == ']'){
                String val = "";
                while(!st.peek().equals("[")){
                    val = st.pop() + val;
                }
                st.pop();
                int n = Integer.parseInt(st.pop());
                String temp = "";
                for(int j = 1; j <= n; j++){
                    temp += val;
                }

                st.push(temp);
            }
            else if(Character.isLetter(c)){
                st.push(c + "");
            }
            else if(Character.isDigit(c)){
                int x = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    x = x * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                st.push(x + "");
            }
        }
        System.out.println(st.pop());
    }
    public static void main(String[] args){
        String s = "1[a2[b1[c11[d]]]]";
        solve(s);
    }
}
