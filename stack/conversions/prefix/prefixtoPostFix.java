//logic is same but in prefix we start from right hand side and return the answer
//rest is same as postix conversions;
import java.util.*;
public class prefixtoPostFix {
    public static String convertToPostfix(String s) {
        Stack<String> operands = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                    String op = c + "";
                    String v1 = operands.pop();
                    String v2 = operands.pop();
                    String val = v1 + v2 + op;
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
        String s = "-+2*31+3*41";
        String ans = convertToPostfix(s);
        System.out.println(ans);
    }
}
