//basic calculator2 leetcode 227
import java.util.*;
class infixEvaluation{
	public static int calculate(String s) {
		Stack<Integer> operands = new Stack<>();
		Stack<Character> operator = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				operator.push(c);
			}
			else if (c == ')') {
				while (operator.peek() != '(') {
					char op = operator.pop();
					int v2 = operands.pop();
					int v1 = operands.pop();
					int val = eval(v1, v2, op);
					operands.push(val);
				}
				operator.pop();
			}
			else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
				while (operator.size() > 0 && operator.peek() != '(' && precedence(c) <= precedence(operator.peek())) {
					char op = operator.pop();
					int v2 = operands.pop();
					int v1 = operands.pop();
					int val = eval(v1, v2, op);
					operands.push(val);
				}
				operator.push(c);
			}
			else if (c == ' ') {
			}
			else{
				//means it is a number
				//may conatins more than 2 digits
				StringBuffer sb = new StringBuffer();
				while(i < s.length() && Character.isDigit(s.charAt(i))){
					sb.append(s.charAt(i++));
				}
				operands.push(Integer.parseInt(sb.toString()));
				i--;
			}
		}
		while (operator.size() > 0) {
			char op = operator.pop();
			int v2 = operands.pop();
			int v1 = operands.pop();
			int val = eval(v1, v2, op);
			operands.push(val);
		}
		return operands.peek();
	}

	public static int precedence(char op) {
		if (op == '+' || op == '-') {
			return 1;
		} 
		else{
			return 2;
		} 
	}

	public static int eval(int v1, int v2, char op) {
		// System.out.println(v1 +  " " + v2);
		
		if (op == '+') {
			return v1 + v2;
		} else if (op == '-') {
			return v1 - v2;
		} else if (op == '*') {
			return v1 * v2;
		}
		else if(op == '%'){
			return v1 % v2;
		}
		 else {
			return v1 / v2;
		}
	}
	public static void main(String[] args) {
		String s = "(8 + 10 % 9)";
		System.out.println(calculate(s));
	}
}