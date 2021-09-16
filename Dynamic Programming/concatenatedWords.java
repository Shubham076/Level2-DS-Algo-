//leetcode 472  same as word break O(n * l * l) l is the length of max word
import java.util.*;
public class concatenatedWords {
    private static boolean divide(String s, HashSet<String> dict) {
        if (s == null || s.length() == 0)
            return false;

        int n = s.length();
        boolean[] dp = new boolean[n];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                if(j > 0 && !dp[j - 1]) continue;
                String suffix = s.substring(j, i + 1);
                if(dict.contains(suffix)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(Arrays.asList(words));
    
        for (int i = 0; i < words.length; i++) {
            dict.remove(words[i]);
            
            if (divide(words[i], dict) && words[i].length() > 0) {
                result.add(words[i]);
            }
            
            dict.add(words[i]);
        }
        return result;
    }
}
