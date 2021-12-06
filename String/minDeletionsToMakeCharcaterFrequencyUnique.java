/*
leetcode 1647
A string s is called good if there are no two different characters in s that have the same frequency.
Given a string s, return the minimum number of characters you need to delete to make s good.
*/
import java.util.*;
public class minDeletionsToMakeCharcaterFrequencyUnique {
    public static int minDeletions(String s) {
        HashSet<Integer> set = new HashSet<>();
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            freq[c - 'a']++;
        }
        
        int ans = 0;
        for(int i = 0; i < 26; i++){
            while(freq[i] > 0 && !set.add(freq[i])){
                freq[i]--;
                ans++;
            }
        }            
        return ans;
    }

    public static void main(String[] args){
        String a = "aabcc";
        System.out.println(minDeletions(a));
    }
}
