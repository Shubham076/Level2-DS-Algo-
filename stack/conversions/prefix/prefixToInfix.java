import java.util.*;
public class prefixToInfix {
    public static String convertToInfix(String s) {
        Stack<String> operands = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                    String op = c + "";
                    String v1 = operands.pop();
                    String v2 = operands.pop();
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
        String s = "-+2*31+3*41";
        String ans = convertToInfix(s);
        System.out.println(ans);
    }
}
