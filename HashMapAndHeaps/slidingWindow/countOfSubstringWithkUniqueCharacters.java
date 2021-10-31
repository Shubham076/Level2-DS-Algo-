/*
same logic as cnt of subarray with k diff integers
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-substrings-with-exactly-k-unique-characters-official/ojquestion#!
*/
import java.util.*;
class countOfSubstringWithkUniqueCharacters{
	public static int findAtmostK(String s , int k) {
		HashMap<Character, Integer> map = new HashMap<>();
        int j = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if(map.get(s.charAt(j)) == 0) map.remove(s.charAt(j));
                j++;
            }
			cnt += i - j + 1;
        }
        return cnt;
	}
	public static int solution(String str, int k){
		int cnt1 = findAtmostK(str, k);
        int cnt2 = findAtmostK(str, k - 1);
        return cnt1 - cnt2;
	}
	
	public static void main(String[] args) {
        String str = "abc";
        int k = 3;
		System.out.println(solution(str,k));
	}
}
