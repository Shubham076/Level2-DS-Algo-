/*
The problem says that we can make at most k changes to the string (any character can be replaced with
any other character).So, let's say there were no constraints like the k. Given a string convert it to
a string with all same characters with minimal changes.The answer to this is
length of the entire string - number of times of the maximum occurring character in the string
Given this, we can apply the at most k changes constraint and maintain a sliding window such that
(length of substring - number of times of the maximum occurring character in the substring) <= k

leetcode 424
*/
class longestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
    	int[] cnt = new int[26];
    	int j = 0, max = 0, res = 0;
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		cnt[c - 'A']++;
    		max = Math.max(max, cnt[c - 'A']);

    		while(i - j + 1 - max > k) {
    			char d = s.charAt(j++);
    			cnt[d - 'A']--;
    			max = 0;
    			for(int a = 0; a < 26; a++){
    				max = Math.max(max, cnt[a]);
    			}
    		}
    		res = Math.max(res, i - j + 1);
    	}
    	return res;    
    }
}