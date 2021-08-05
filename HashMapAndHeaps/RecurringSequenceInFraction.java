/*
Given a fraction. Convert it into a decimal. 
If the fractional part is repeating, enclose the repeating part in parentheses.
*/
import java.util.*;
class  RecurringSequenceInFraction {
	public static String fractionToDecimal(int num, int den) {
		HashMap<Integer, Integer> map = new HashMap<>();
		String ans = "";
		int q = num / den;
		int r = num % den;

		if(r == 0){
			return q + "";
		}

		while(r != 0 && !map.containsKey(r)){
			map.put(r, ans.length());

			r *= 10;
			ans += r / den;
			r %= den;
		}

		if(r == 0){
			return q + "." + ans;
		}
		else {
			return q + "." + ans.substring(0, map.get(r)) + "(" + ans.substring(map.get(r)) + ")";
		}
	}
	public static void main(String[] args) {
		int n = 5;
		int d = 2;
		System.out.println(fractionToDecimal(n, d));
	}
}