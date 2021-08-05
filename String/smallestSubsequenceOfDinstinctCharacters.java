/*
leetcode 1081 or leetcode 316
Return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.
smallestSubsequenceOfDinstinctCharacters
*/
import java.util.*;
class smallestSubsequenceOfDinstinctCharacters{
	public static String smallestSubsequence(String s) {
        boolean[] vis = new boolean[26];  // character used or not
        int[] freq = new int[26];  //frequency map;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length() ; i++){
        	char c = s.charAt(i);
        	freq[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);
        	freq[c - 'a']--;

        	//means character is used as we have to only use unique characters
        	if(vis[c - 'a']){
        		continue;
        	}

        	//now the check if we can replace the bigger character that is present in previous indices
        	while(st.size() > 0 && st.peek() > c && freq[st.peek() - 'a'] > 0){
        		char rm = st.pop();
        		vis[rm - 'a'] = false;
        	}
        	st.push(c);
        	vis[c - 'a'] = true;
        }
        char[] ans = new char[st.size()];
        int i = ans.length - 1;
        while(i >= 0){
        	ans[i--] = st.pop();
        } 
        return new String(ans);
    }
	public static void main(String[] args){
		String s = "bcabc";
		System.out.println(smallestSubsequence(s));
	}
}