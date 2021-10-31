/*
leetcode 1048
You are given an array of words where each word consists of lowercase English letters.
wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere
in wordA without changing the order of the other characters to make it equal to wordB.
For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on.
A single word is trivially a word chain with k == 1.
Return the length of the longest possible word chain with words chosen from the given list of words.
O(Nlogn + n * len) len = max length of string
*/
import java.util.*;
class longestStringChain{
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> dp = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < words.length; i++){
            int cmax = 0;
            StringBuilder w = new StringBuilder(words[i]);
            for(int j = 0; j < w.length(); j++){
                String temp = w.substring(0, j) + w.substring(j + 1);
                cmax = Math.max(cmax, dp.getOrDefault(temp.toString(), 0) + 1);
            }
            dp.put(words[i], cmax);
            max = Math.max(max, cmax);
        }
        return max;   
    }
}