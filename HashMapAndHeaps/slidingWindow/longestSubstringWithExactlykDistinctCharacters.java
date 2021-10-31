/*
https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
*/
import java.util.*;
class longestSubstringWithExactlykDistinctCharacters{
	static int method1(String s, int k){
		HashMap<Character, Integer> map = new HashMap<>();
        int j = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if(map.get(s.charAt(j)) == 0) map.remove(s.charAt(j));
                j++;
            }

			//collect the ans
			if(map.size() == k)
				ans = Math.max(ans, i - j + 1);
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
	}

	static int method2(String s, int k){
		HashMap<Character , Integer> map = new HashMap<>();
		int i = -1 , j = -1;
		int maxLen = Integer.MIN_VALUE;
		while(true){
			boolean f1 = false;
			boolean f2 = false;
			while(i < s.length() - 1){
				f1 = true;
				i++;
				char c = s.charAt(i);
				map.put(c , map.getOrDefault(c , 0) + 1);

				if(map.size() > k){
					break;
				}
				else if(map.size() == k){
					int curLen = i - j;
					if(curLen > maxLen){
						maxLen = curLen;
					}
				}
			}

			while(j < i){
				f2 = true;
				j++;
				char c = s.charAt(j);
				int freq = map.get(c);
				if(freq == 1){
					map.remove(c);
				}
				else{
					map.put(c , freq - 1);
				}

				if(map.size() == k){
					int curLen = i - j;
					if(curLen > maxLen){
						maxLen = curLen;
					}
					break;
				}
			}

			if(f1 == false && f2 == false){
				break;
			}
		}
		return maxLen == Integer.MIN_VALUE ? -1: maxLen;
	}
	public static void main(String[] args){
		String s = "gbwkfnqduxwfn";
		int k = 15;
		int ans1 = method1(s, k);
		int ans2 = method2(s, k);
		System.out.println(ans1 + " " + ans2);
	}
}