import java.util.*;
class FractionToDecimal {
    public String fractionToDecimal(int n, int d) {
        if(n == 0) return "0";
		StringBuilder ans = new StringBuilder("");
		HashMap<Long, Integer> map = new HashMap<>();
		boolean isNegative = (n > 0 ^ d > 0);
		ans.append( isNegative ? "-" : "");
		long num = Math.abs((long)n);
		long den = Math.abs((long)d);
		long q = num / den;
		long r = num % den;
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
}