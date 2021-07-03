//leetcode 227
import java.util.*;
class basicCalculator2{
	public static int calculate(String s) {
        Stack<Integer>st = new Stack<>();
        int n = s.length();
        int sum = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);

        	int val = 0;
        	if(Character.isDigit(c)){
        		while(i < n && Character.isDigit(s.charAt(i))){
        			val = val * 10 + s.charAt(i) - '0';
        			i++;
        		}

        		i--;

        		if(sign == '+'){
        			st.push(val);
        		}
        		else if(sign == '-'){
        			st.push(-val);
        		}
        		else if(sign == '*'){
        			int x = st.pop();
        			st.push(x * val);
        		}
        		else{
        			int x = st.pop();
        			st.push(x / val);
        		}
        	}
        	else if(c != ' '){
        		sign = c;
        	}
        }

        while(st.size() > 0){
        	sum += st.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
    	String s = "42";
    	System.out.println(calculate(s));
    }
}