/*
precedence is already handled in postfix so we dont need 2 stacks
postfix v1 v2 op => v1 op v2
*/
import java.util.*;
public class postfixToInfix {
    public static String convertToInfix(String s) {
        Stack<String> operands = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                    String op = c + "";
                    String v2 = operands.pop();
                    String v1 = operands.pop();
                    String val = "(" + v1 + op + v2 + ")";
                    operands.push(val);
            } else if (c == ' ') {

            } else {
                int val = s.charAt(i) - '0';
                operands.push(val + "");
            }
        }
        return operands.peek();
    }
    public static void main(String[] args) {
        String s = "231*+341*+-";
        String ans = convertToInfix(s);
        System.out.println(ans);
    }    
}
