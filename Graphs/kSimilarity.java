//leetcode 854 use bfs as we have to find the minimum value of k
import java.util.*;
class kSimilarity {
	public static int kSimilarity(String s1, String s2) {
		Queue<StringBuilder> q = new ArrayDeque<>();
		HashSet<String> set = new HashSet<>();
		q.add(new StringBuilder(s1));
		set.add(s1);
		int level = 0;
		while (q.size() > 0) {
			int s = q.size();
			while (s-- > 0) {
				StringBuilder rm = q.remove();

				if (rm.toString().equals(s2)) {
					return level;
				}
				int idx = 0;
				char ch1 = '#';
				char ch2 = '#';
				for (int i = 0; i < rm.length(); i++) {
					ch1 = rm.charAt(i);
					ch2 = s2.charAt(i);

					if (ch1 == ch2)
						continue;
					else{
						idx = i;
						break;
					}
				}

				/*
					eg :  s1 : abc
				          s2:  cba
				          as we can see a != c so we have to replace a with c
				          so find all the occurences of c in rm and swap it
				*/
				 //adding the nbrs
				for (int j = idx; j < rm.length(); j++) {
					char c = rm.charAt(j);
					if (c == ch2) {
						StringBuilder temp = new StringBuilder(rm);
						temp.setCharAt(idx, ch2);
						temp.setCharAt(j, ch1);

						if (!set.contains(temp.toString())) {
							set.add(temp.toString());
							q.add(temp);
						}
					}
				}
			}
			level++;
		}
		return -1;
	}
	public static void main(String[] args) {
		String s1 = "bccaba";
		String s2 = "abacbc";
		System.out.println(kSimilarity(s1, s2));
	}
}