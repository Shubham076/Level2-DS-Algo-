import java.util.*;
class countSubstringWithoutRepeatingCharacters{
	static int method1(String s){
		HashMap<Character, Integer> map = new HashMap<>();
        int j = 0;
        int cnt = 0;
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

			cnt += i - j + 1;
        }
        return cnt;
	}
	static int method2(String s){
		int i = -1;
		int j = -1;
		int ans = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		while(true){
			boolean f1 = false;
			boolean f2 = false;

			while(i < s.length() - 1){
				i++;
				f1 = true;
				char c = s.charAt(i);
				map.put(c , map.getOrDefault(c , 0) + 1);

				if(map.get(c) == 2){
					break;
				}
				else{
					ans += i - j;
				}

			}

			while(j < i){
				j++;
				f2 = true;
				char c = s.charAt(j);
				map.put(c , map.get(c) - 1);
				if(map.get(c) == 1){
					ans += i - j;
					break;
				}

			}

			if(f1 == false && f2 == false){
				break;
			}
		}
		return ans;
	}
	public static void main(String[] args){
		String s = "ab";
		int ans1 = method1(s);
		int ans2 = method2(s);
		System.out.print(ans1 + " " + ans2);
	}
}