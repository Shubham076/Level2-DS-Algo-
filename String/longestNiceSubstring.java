//leetcode 1763
import java.util.*;
class longestNiceSubstring {
	public static String longestNiceSubstring(String s) {
	    if(s.length() == 0) return "";
	    HashSet<Character> set = new HashSet<>();
	    for(int i = 0; i < s.length(); i++) {
	    	set.add(s.charAt(i));
	    }
	    for(int i = 0; i < s.length(); i++) {
	    	char c = s.charAt(i);
	    	if(set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) continue;
	    	String left = longestNiceSubstring(s.substring(0, i));
	    	String right = longestNiceSubstring(s.substring(i + 1));
	    	return left.length() >= right.length() ? left: right;
	    }   
	    return s;
	}	
	public static void main(String[] args) {
		String s = "YazaAay";
		System.out.println(longestNiceSubstring(s));
	}
}