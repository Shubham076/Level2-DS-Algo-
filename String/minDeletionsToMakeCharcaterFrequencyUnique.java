//leetcode 1647
import java.util.*;
public class minDeletionsToMakeCharcaterFrequencyUnique {
    public int minDeletions(String s) {
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
}
