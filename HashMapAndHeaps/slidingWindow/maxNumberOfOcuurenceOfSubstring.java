/*
leetcode 1297
intuition
If you are able to find substrings with size > minSize meeting the maxLetters reqirement,
 substrings with smaller sizes have atleast the same frequency!

If string S with size N > minSize has frequency F, then the substring of S must also have frequency F.
Therefore, we only need to consider the minSize substring.
Apply sliding window to scan the candidate substrings with length minSize.

We also know that number of shorter substrings are more than the longer ones
O(N)
*/
package slidingWindow;
import java.util.*;
public class maxNumberOfOcuurenceOfSubstring {

    public static boolean isValid(String s, int max){
        HashMap<Character, Integer> m = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            m.put(c, m.getOrDefault(c, 0) + 1);

            if(m.size() > max){
                return false;
            }
        }
        return true;
    }
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < s.length() - minSize + 1; i++){
            String cur = s.substring(i, i + minSize);
            if(isValid(cur, maxLetters)){
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                max = Math.max(max, map.get(cur));
            }
        }
        return max;
    }
    public static void main(String[] args){
        String s = "aababcaab";
        int max = 2;
        int minsize = 3;
        int maxsize = 4;
        System.out.println(maxFreq(s, max, minsize, maxsize));
    }
}
