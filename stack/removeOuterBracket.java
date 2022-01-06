//leetcode 1021
public class removeOuterBracket {
    public String removeOuterParentheses(String s) {
        int left = 0, right = 0, start = 0;
        StringBuilder ans = new StringBuilder("");
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') left++;
            else right++;

            if(left == right){
                ans.append(s.substring(start + 1, i));
                start = i + 1;
            }
        }
        return ans.toString();
    }
}
