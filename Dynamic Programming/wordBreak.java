//leetcode 139
import java.util.*;
public class wordBreak {

    // recursion
    private boolean wb(String s, Set<String> dict) {
        if (s.length() == 0) {
            return true;
        }
        for (int i = 1; i <= s.length(); ++i) {
            if (dict.contains(s.substring(0, i)) && wb(s.substring(i), dict)) {
                return true;
            }
        }
        return false;
    }

    // recursion with memoization
    //dp stores that if string can be segmented into words of dict or not
    private static boolean wb(String s, List<String> dict, HashMap<String, Boolean> dp) {
        if (s.length() == 0) {
            return true;
        }
        if(dp.containsKey(s)){
            return dp.get(s);
        }
        for (int i = 1; i <= s.length(); ++i) {
            if (dict.contains(s.substring(0, i)) && wb(s.substring(i), dict, dp)) {
                dp.put(s, true);
                return true;
            }
        }
        dp.put(s, false);
        return false;
    }


    //cnt is stored in dp[n - 1]
    // dict = [leet, code]
/*  leetcode  0 1 2 3 4 5 6 7
   dp =>    [ 0 0 0 0 0 0 0 0]

   j always starts from 0
   i iterated and we are checking for all the suffixes fom j -> i
   for eg at 5th index we checking  
   leetco present in dict
   eetco present in dict
   etco present in dict
   tco present in dict
   co present in dict
   o present in dict
   
   if any suffix is present in the dict
   then we adding the answer of j - 1th index which stores the number of sentence upto j - 1 th index
   O(l * l * l) l is the length of max word
   O(l * l) as general for not considering the substring function  
*/
    public boolean wordbreak(String s, List<String> dict) {
        if (s == null || s.length() == 0)
            return false;

        int n = s.length();
        // dp[i] represents no of sentences can be made upto ith index
        int[] dp = new int[n];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                String suffix = s.substring(j, i + 1);
                if(dict.contains(suffix)){
                    if(j > 0)
                        dp[i] += dp[j - 1];
                    else
                        dp[i] += 1;
                }
            }
        }
        return dp[n - 1] > 0;
    }

    public static void main(String[] args){
        String s = "leetcode";
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        HashMap<String, Boolean> dp = new HashMap<>();
        boolean ans = wb(s, dict, dp);
        System.out.println(ans);
    }
}