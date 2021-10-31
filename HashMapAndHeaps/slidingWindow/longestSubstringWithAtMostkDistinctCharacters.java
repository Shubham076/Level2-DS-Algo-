import java.util.*;
class longestSubstringWithAtMostkDistinctCharacters{
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
			ans = Math.max(ans, i - j + 1);
        }
        return ans;
	}

	static int method2(String s, int k){
		HashMap<Character, Integer> map = new HashMap<>();
		int len = 0;
		int i = -1;
		int j = -1;
		while(true){
			boolean flag1 = false;
			boolean flag2 = false;
			while(i < s.length() - 1){
				i++;
				flag1 = true;
				char c = s.charAt(i);
				map.put(c, map.getOrDefault(c, 0) + 1);
				if(map.size() > k){
					break;
				}
				else{
					int curLen = i - j;
					if(curLen > len){
						len = curLen;
					}
				}
			}

			while(j < i){
				flag2 = true;
				j++;
				char c = s.charAt(j);
				int v = map.get(c);
				if(v > 1){
					map.put(c, v - 1);
				}
				else{
					map.remove(c);
				}
				if(map.size() <= k){
					int curLen = i - j;
					if(curLen > len){
						len = curLen;
					}
					break;
				}
			}
			
			if(flag1 == false && flag2 == false){
				break;
			}
		}
		return len;
	}
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int k = scn.nextInt();
	}
}