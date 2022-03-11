/*
https://www.geeksforgeeks.org/longest-substring-with-count-of-1s-more-than-0s/
*/
import java.util.*;
class longestSubstringWithOneGreaterThanZeros {
	public static void main(String[] args) {
		String s = "101100";
		int len = 0;
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			int v = s.charAt(i) - '0';
			if(v == 1) {
				sum += 1;
			}
			else{
				sum -= 1;
			}

			if(sum > 0){
				len = Math.max(len, i + 1);
			}
			else{
				int idx = map.containsKey(sum - 1) ? map.get(sum - 1) : 1;
				int clen = i - idx;
				len = Math.max(len, clen);
			}
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		System.out.println(len);
	}
}