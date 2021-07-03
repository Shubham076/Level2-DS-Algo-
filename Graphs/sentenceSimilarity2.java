/*lintcode 855
Given two sentences words1, words2 (each represented as an
array of strings), and a list of similar word pairs pairs, determine if two
sentences are similar.

Note that the similarity relation is transitive. For example, if "great"
and "good" are similar, and "fine" and "good" are similar, then "great"
and "fine" are similar.

Input:["great","acting","skills"]
["fine","drama","talent"]
[["great","good"],["fine","good"],
["drama","acting"],["skills","talent"]] Output: true

use dsu to group similar items

*/
import java.util.*;
class sentenceSimilarity2 {
	static HashMap<String, String> par;
	static HashMap<String, Integer> rank;
	public static String find(String s) {
		if (par.get(s) == null) {
			return "";
		}
		if (par.get(s).equals(s)) {
			return s;
		}
		String temp = find(par.get(s));
		par.put(s, temp);
		return temp;
	}
	public static void union(String s1, String s2) {
		String l1 = find(s1);
		String l2 = find(s2);

		if (!l1.equals(l2)) {
			if (rank.get(l2) > rank.get(l1)) {
				par.put(l1, l2); //l2 is the parent of l1
			} 
			else if (rank.get(l1) > rank.get(l2)) {
				par.put(l2, l1);
			}
			else {
				par.put(l2, l1);
				rank.put(l1, rank.get(l1) + 1);
			}
		}
	}
	public static boolean areSentencesSimilarTwo(List<String> words1, List<String> words2, List<List<String>> pairs) {
		if (words1 == null || words2 == null || words1.size() != words2.size()) {
			return false;
		}
		par = new HashMap<>();
		rank = new HashMap<>();
		for (List<String> p : pairs) {
			for (String s : p) {
				if (!par.containsKey(s)) {
					par.put(s, s);
					rank.put(s, 1);
				}
			}
			union(p.get(0), p.get(1));
		}

		for (int i = 0; i < words1.size(); i++) {
			String s1 = words1.get(i);
			String s2 = words2.get(i);
			if (words1.get(i) == null || words2.get(i) == null) {
				return false;
			}
			if (!find(s1).equals(find(s2))) {
				return false;
			}
		}
		return true;
	}
}