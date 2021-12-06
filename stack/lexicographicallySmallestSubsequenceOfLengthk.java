//https://www.geeksforgeeks.org/lexicographically-smallest-k-length-subsequence-from-a-given-string/
import java.util.*;
public class lexicographicallySmallestSubsequenceOfLengthk {
    public static void main(String[] args){
        String s = "bbcaab";
        int n = s.length();
        int k = 1;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(st.size() == 0) st.push(c);

            else{
                while(st.size() > 0 && st.peek() > c && st.size() - 1 + n - i >= k){
                    st.pop();
                }

                if(st.size() < k){
                    st.push(c);
                }
            }
        }
        while(st.size() > 0){
            System.out.print(st.pop());
        }
    }
}
