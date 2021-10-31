import java.util.*;
class longestSubstringWithNonRepeatingCharacters{

	static int method1(String s){
		HashMap<Character, Integer> map = new HashMap<>();
        int j = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            //loop releasing the character
            while(map.get(c) >= 2){
                char d = s.charAt(j);
                int v = map.get(d);
                map.put(d,  v - 1);
				j++;
            }

            int curLen = i - j + 1;
            if(curLen > ans){
                ans = curLen;
            }
        }
        return ans;
	}

	static int method2(String s){
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

		return maxLen;
	}
	public static void main(String[] args){
		String s = "geeksforgeeks";
		int ans1 = method1(s);
		int ans2 = method2(s);
		System.out.println(ans1 + " " + ans2);
	}
}