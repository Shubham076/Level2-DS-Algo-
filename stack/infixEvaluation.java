//basic calculator3 leetcode 227
import java.util.*;
class infixEvaluation{
	public static int precedence(char op) {
		if (op == '+' || op == '-') {
			return 1;
		} 
		else{
			return 2;
		} 
	}

	public static long eval(long v1, long v2, char op) {
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

	public static long calculate(String s) {
		Stack<Long> operands = new Stack<>();
		Stack<Character> operator = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				operator.push(c);
			}
			else if (c == ')') {
				while (operator.peek() != '(') {
					char op = operator.pop();
					long v2 = operands.pop();
					long v1 = operands.pop();
					long val = eval(v1, v2, op);
					operands.push(val);
				}
				operator.pop();
			}
			else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
				while (operator.size() > 0 && operator.peek() != '(' && precedence(c) <= precedence(operator.peek())) {
					char op = operator.pop();
					long v2 = operands.pop();
					long v1 = operands.pop();
					long val = eval(v1, v2, op);
					operands.push(val);
				}
				operator.push(c);
			}
			else if (c == ' ') {
			}
			else{
				//means it is a number
				//may contains more than 2 digits
				long val = 0;
				while(i < s.length() && Character.isDigit(s.charAt(i))){
					val = val * 10 + (s.charAt(i++) - '0');
				}
				operands.push(val);
				i--;
			}
		}

		while (operator.size() > 0) {
			char op = operator.pop();
			long v2 = operands.pop();
			long v1 = operands.pop();
			long val = eval(v1, v2, op);
			operands.push(val);
		}
		return operands.peek();
	}

	public static void main(String[] args) {
		String s = "0-2147483648";
		System.out.println(calculate(s));
	}
}