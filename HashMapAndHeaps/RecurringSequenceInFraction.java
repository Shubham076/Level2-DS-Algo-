/*
leetcode 166
Given a fraction. Convert it into a decimal. 
If the fractional part is repeating, enclose the repeating part in parentheses.
*/
import java.util.*;
class RecurringSequenceInFraction {
	public static String fractionToDecimal(int num, int den) {
		if(num == 0) return "0";
		StringBuilder ans = new StringBuilder("");
		HashMap<Integer, Integer> map = new HashMap<>();
		boolean isNegative = (num > 0 ^ den > 0);
		ans.append( isNegative ? "-" : "");
		num = Math.abs(num);
		den = Math.abs(den);
		int q = num / den;
		int r = num % den;
		ans.append(q);
		if(r == 0){
			return ans.toString();
		}
		else{
			ans.append(".");
		}

		while(r != 0 && !map.containsKey(r)){
			map.put(r, ans.length());
			r *= 10;
			q = r / den;
			r %= den;
			ans.append(q);
		}

		if(r != 0){ //repeating or recurrring decimal
			int len = map.get(r);
			ans.insert(len, "(");
			ans.append(")");
		}

		return ans.toString();
	}
	public static void main(String[] args) {
		int n = -1;
		int d = -2;
		System.out.println(fractionToDecimal(n, d));
	}
}