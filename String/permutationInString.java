import  java.util.*;
//leetcode 567
class permutationInString {
	public static boolean checkInclusion(String s1, String s2) {
		if(s1.length() > s2.length()) return false;
		HashMap<Character,Integer> map1 = new HashMap<>();
		HashMap<Character,Integer> map2 = new HashMap<>();
		int n = s1.length();
		for(int i = 0; i < n - 1; i++){
			char c = s2.charAt(i);
			map1.put(c , map1.getOrDefault(c, 0) + 1);
		}

		for(int i = 0; i < n - 1; i++){
			char c = s1.charAt(i);
			map2.put(c , map2.getOrDefault(c, 0) + 1);
		}

		int j = 0;
		for(int i = n - 1; i < s2.length(); i++){
			char c = s2.charAt(i);
			map1.put(c , map1.getOrDefault(c, 0) + 1);
			if(map1.equals(map2)){
				return true;
			}

			char ch = s2.charAt(j);
			int v = map1.get(ch);
			if(v > 1){
				map1.put(ch , v - 1);
			}
			else{
				map1.remove(ch);
			}
			j++;
		}
		return false;
	}
	public static void main(String[] args) {
		String s = "horse";
		String p = "rosss";
		System.out.println(checkInclusion(s, p));
	}
}