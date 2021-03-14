import java.util.*;
class longestSubstringWithAtMostkDistinctCharacters{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int k = scn.nextInt();
		HashMap<Character, Integer> map = new HashMap<>();
		int len = 0;
		int i = -1;
		int j = -1;
		while(true){
			boolean f1 = false;
			boolean f2 = false;

			while(i < s.length() - 1){
				i++;
				f1 = true;
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
				j++;
				f2 = true;
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

			if(f1 == false && f2 == false){
				break;
			}
		}
		System.out.println(len);
	}
}