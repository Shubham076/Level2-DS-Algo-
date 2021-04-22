//leetcode 290
import java.util.*;
class wordPattern {
	public static boolean wordPattern(String p, String s) {
		String[] words = s.split(" ");
		if(words.length != p.length()){
            return false;
        }
		HashMap<Character, String> map1 = new HashMap<>();   // for 1 : 1 mapping
		HashMap<String, Boolean> used = new HashMap<>(); // for storing if we have used it or not

		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			String d = words[i];
			if (map1.containsKey(c)) {
				if (!map1.get(c).equals(d))
					return false;
				else {
					continue;
				}
			} else {
				if (used.containsKey(d) && used.get(d)) {
					System.out.println("running2");
					return false;
				} else {
					map1.put(c , d);
					used.put(d , true);
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String p = "abba";
		String s = "dog cat cat dog";
		System.out.println(wordPattern(p, s));
	}
}