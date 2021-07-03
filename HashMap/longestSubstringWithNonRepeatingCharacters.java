import java.util.*;
class longestSubstringWithNonRepeatingCharacters{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int i = -1;
		int j = -1;
		int maxLen = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		while(true){
			boolean f1 = false;
			boolean f2 = false;
			while(i < s.length() - 1){
				f1 = true;
				i++;
				char c = s.charAt(i);
				map.put(c , map.getOrDefault(c , 0) + 1);

				if(map.get(c) == 2){
					break;
				}
				else{
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
				map.put(c , map.get(c) - 1);
				if(map.get(c) == 1){
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