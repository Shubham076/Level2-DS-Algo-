//leetcode 224 infix
import java.util.*;
class basicCalculator {
	public static int calculate(String s) {
		int sum = 0;
		int sign = 1;
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);

			if(Character.isDigit(c)){
				//may contains more than 1 digits
				int val = 0;
				while(i < s.length() && Character.isDigit(s.charAt(i))){
					val = val * 10 + s.charAt(i) - '0';
					i++;
				}
				i--;
				val *= sign;
				sign = 1; //reset the sign
				sum += val;
			}
			else if(c == '('){
				st.push(sum);
				st.push(sign);
				sum = 0;  //resetting sum and sign
				sign = 1;
			}
			else if(c == ')'){
				sum *= st.pop();  //first multiply with the sign
				sum += st.pop();  //add the previous result
			}
			else if(c == '-'){
				sign *= -1;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		String s = "+48 + -48";
		System.out.println(calculate(s));
	}
}