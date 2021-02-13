import java.util.*;
class longestSubstringWithExactlykDistinctCharacters{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int k = scn.nextInt();
		HashMap<Character , Integer> map = new HashMap<>();
		int i = -1 , j = -1;
		int maxLen = 0;
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

		System.out.println(maxLen);

	}
}