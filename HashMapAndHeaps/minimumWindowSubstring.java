
// 1. You are given two strings s1 and s2 containing lowercase english alphabets.
// 2. You have to find the smallest substring of s1 that contains all the characters of s2.
// 3. If no such substring exists, print blank string("").

import java.util.*;
class minimumWindowSubstring {
	public String minWindow(String s, String p) {
		HashMap<Character, Integer> one = new HashMap<>();
		HashMap<Character, Integer> two = new HashMap<>();

		int j = 0;
		String ans = "";
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			two.put(c, two.getOrDefault(c, 0) + 1);
		}
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			char c  = s.charAt(i);
			one.put(c, one.getOrDefault(c, 0) + 1);
			if (one.get(c) <= two.getOrDefault(c, 0)) {
				cnt++;
			}

			while (cnt == p.length()) {
				String temp = s.substring(j, i + 1);
				if (ans.length() == 0 || ans.length() > temp.length()) {
					ans = temp;
				}
				char d = s.charAt(j++);
				int v = one.get(d);
				if (d == 1) {
					one.remove(d);
				} else {
					one.put(d, v - 1);
				}

				if (one.getOrDefault(d, 0) < two.getOrDefault(d, 0)) {
					cnt--;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String s1 = "abcdebdde";
		String s2 = "bde";
		int count = 0;
		int desiredCount = s2.length();
		String ans = "";
		HashMap<Character , Integer> map1 = new HashMap<>();
		HashMap<Character , Integer> map2 = new HashMap<>();
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			map2.put(c , map2.getOrDefault(c , 0) + 1);
		}

		int i = -1;
		int j = -1;
		while (true) {
			boolean flag1 = false;
			boolean flag2 = false;

			while (i < s1.length() - 1 && count < desiredCount) {
				i++;
				char c = s1.charAt(i);
				map1.put(c , map1.getOrDefault(c , 0) + 1);

				if (map1.getOrDefault(c , 0) <= map2.getOrDefault(c , 0)) {
					count++;
				}
				flag1 = true;
			}

			// collect ans and release
			while (j < i && count == desiredCount) {
				String curAns = s1.substring(j + 1 , i + 1);
				if (ans.length() == 0 || curAns.length() < ans.length()) {
					ans = curAns;
				}
				j++;
				char c = s1.charAt(j);
				if (map1.get(c) == 1) {
					map1.remove(c);
				} else {
					map1.put(c , map1.get(c) - 1);
				}

				if (map1.getOrDefault(c , 0) < map2.getOrDefault(c , 0)) {
					count--;
				}
				flag2 = true;
			}


			if (flag1 == false && flag2 == false) {
				break;
			}
		}

		System.out.println(ans);
	}
}