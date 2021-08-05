import java.util.*;
public class prefixEvaluation {
    public static int eval(int v1, int v2, char op) {
		if (op == '+') {
			return v1 + v2;
		}
		else if (op == '-') {
			return v1 - v2;
		}
		else if (op == '*') {
			return v1 * v2;
		}
		else if(op == '%'){
			return v1 % v2;
		}
		 else {
			return v1 / v2;
		}
	}
    public static int PrefixEvaluation(String s) {
        Stack<Integer> operands = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                    int v1 = operands.pop();
                    int v2 = operands.pop();
                    int val = eval(v1, v2, c);
                    operands.push(val);
            } else if (c == ' ') {

            } else {
                int val = s.charAt(i) - '0';
                operands.push(val);
            }
        }
        return operands.peek();
    }

    public static void main(String[] args) {
        String s = "-+2*31+3*41";
        int ans = PrefixEvaluation(s);
        System.out.println(ans);
    }
}
