//same logic as cnt of subarray with k diff integers
import java.util.*;
class countOfSubstringWithkUniqueCharacters{
	public static int findAtmostK(String s , int k) {
		HashMap<Character, Integer> map = new HashMap<>();
		int i = -1;
		int j = -1;
		int cnt = 0;
		while (true) {
			while (i < s.length() - 1) {
				i++;
				char c = s.charAt(i);
				map.put(c, map.getOrDefault(c, 0) + 1);
				if (map.size() <= k) {
					cnt += (i - j);
				}
				else {
					break;
				}
			}
                
			if (i == s.length() - 1 && map.size() <= k) {
				break;
			}

			while (j < i) {
				j++;
				char d = s.charAt(j);
				int v = map.get(d);
				if (v > 1) {
					map.put(d, v - 1);
				} 
				else {
					map.remove(d);
				}
				if (map.size() <= k) {
					cnt += (i - j);
					break;
				}
			}
		}
		return cnt;
	}
	public static int solution(String str, int k){
		int cnt1 = findAtmostK(str, k);
        int cnt2 = findAtmostK(str, k - 1);
        return cnt1 - cnt2;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}
}
