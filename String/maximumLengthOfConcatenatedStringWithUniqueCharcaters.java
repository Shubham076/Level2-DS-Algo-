//leetcode 1239
import java.util.*;
public class maximumLengthOfConcatenatedStringWithUniqueCharcaters {
    public static boolean unique(String s){
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(!set.add(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static int dfs(int i, String s, List<String> arr, int max, HashMap<String, Integer> dp){
        if(unique(s)){
            max = Math.max(max, s.length());
        }
        else{
            return Integer.MIN_VALUE;
        }
        if(dp.containsKey(s)){
            return dp.get(s);
        }
        for(int j = i; j < arr.size(); j++){
            max = Math.max(max, dfs(j + 1, s + arr.get(j), arr, max, dp));
        }

        dp.put(s, max);
        return max;
    }
    public int maxLength(List<String> arr) {
        HashMap<String, Integer> dp = new HashMap<>();
        return dfs(0, "", arr, Integer.MIN_VALUE, dp);
    }
}
