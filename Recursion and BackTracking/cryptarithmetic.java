//leetcode 1307
import java.util.*;
public class cryptarithmetic {

	public static void main(String[] args) {
		String s1 = "team";
		String s2 = "pep";
		String s3 = "toppr";

		HashMap<Character, Integer> charIntMap = new HashMap<>();
		String unique = "";
		for (int i = 0; i < s1.length(); i++) {
			if (!charIntMap.containsKey(s1.charAt(i))) {
				charIntMap.put(s1.charAt(i), -1);
				unique += s1.charAt(i);
			}
		}

		for (int i = 0; i < s2.length(); i++) {
			if (!charIntMap.containsKey(s2.charAt(i))) {
				charIntMap.put(s2.charAt(i), -1);
				unique += s2.charAt(i);
			}
		}

		for (int i = 0; i < s3.length(); i++) {
			if (!charIntMap.containsKey(s3.charAt(i))) {
				charIntMap.put(s3.charAt(i), -1);
				unique += s3.charAt(i);
			}
		}

		boolean[] usedNumbers = new boolean[10];
		solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
	}

	public static long number(String s, HashMap<Character, Integer> map) {
		long num = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			num = num * 10 + map.get(c);
		}
		return num;
	}

	public static void solution(String unique, int idx, HashMap<Character, Integer> map, boolean[] usedNumbers,
			String s1, String s2, String s3) {

		if (idx == unique.length()) {
			long n1 = number(s1, map);
			long n2 = number(s2, map);
			long n3 = number(s3, map);

			if (n1 + n2 == n3) {
				for (int i = 0; i < 26; i++) {
					char c = (char) ('a' + i);
					if(map.containsKey(c) == true){
						System.out.print(c + "-" + map.get(c) + " ");
					}
				}
				System.out.println();
			}
			return;
		}
		char ch = unique.charAt(idx);
		for (int i = 0; i < 10; i++) {
			if (usedNumbers[i] == false) {
				usedNumbers[i] = true;
				map.put(ch, i);
				solution(unique, idx + 1, map, usedNumbers, s1, s2, s3);
				usedNumbers[i] = false;
				map.put(ch, -1);
			}
		}
	}
}
