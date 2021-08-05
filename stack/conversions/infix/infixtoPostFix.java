/*
logic same as infix evaluation just when we evaluate instead of doinf v1 op v2 
we push val in form of string ans v1 v2 op as we are converting to postfix
*/
import java.util.*;
public class infixtoPostFix {
    public static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if(op == '*' || op == '/'){
            return 2;
        }
        else return 3; //for ^
    }

    public static String convertToPostfix(String s) {
        Stack<String> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                operators.push(c);
            } 
            else if (c == ')') {
                while (operators.peek() != '(') {
                    char op = operators.pop();
                    String v2 = operands.pop();
                    String v1 = operands.pop();
                    String val = v1 + v2 + op;
                    operands.push(val);
                }
                operators.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                while (operators.size() > 0 && operators.peek() != '('
                        && precedence(c) <= precedence(operators.peek())) {
                    char op = operators.pop();
                    String v2 = operands.pop();
                    String v1 = operands.pop();
                    String val = v1 + v2 + op;
                    operands.push(val);
                }
                operators.push(c);
            } else if (c == ' ') {

            } else {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                operands.push(val + "");
            }
        }
        while (operators.size() > 0) {
            char op = operators.pop();
            String v2 = operands.pop();
            String v1 = operands.pop();
            String val = v1 + v2 + op;
            operands.push(val);
        }
        return operands.peek();
    }

    public static void main(String[] args) {
        String s = "2+3*1-(3+4*1)";
        String ans = convertToPostfix(s);
        System.out.println(ans);
    }
}
